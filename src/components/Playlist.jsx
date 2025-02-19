import { useEffect, useState } from "react";
import { Search, Music, Plus, CheckCircle } from "lucide-react";
import './playlist.css';

const Playlist = () => {
  const [audioList, setAudioList] = useState([]);
  const [selectedAudios, setSelectedAudios] = useState([]);
  const [playlistTitle, setPlaylistTitle] = useState("");
  const [playlists, setPlaylists] = useState([]);
  const [selectAll, setSelectAll] = useState(false);
  const [searchTerm, setSearchTerm] = useState("");
  const [filteredAudios, setFilteredAudios] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/api/audio")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setAudioList(data);
        setFilteredAudios(data);
        setIsLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching audio list:", error);
        setIsLoading(false);
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/api/playlist")
      .then((response) => response.json())
      .then((data) => setPlaylists(data))
      .catch((error) => console.error("Error fetching playlists:", error));
  }, []);

  useEffect(() => {
    const filtered = audioList.filter((audio) =>
      audio.title.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredAudios(filtered);
  }, [searchTerm, audioList]);

  const handleAudioSelection = (audioId) => {
    setSelectedAudios((prevSelected) => {
      const updatedSelection = prevSelected.includes(audioId)
        ? prevSelected.filter((id) => id !== audioId)
        : [...prevSelected, audioId];
      
      setSelectAll(updatedSelection.length === audioList.length);
      return updatedSelection;
    });
  };

  const handleSelectAll = () => {
    setSelectAll(!selectAll);
    if (!selectAll) {
      const allAudioIds = filteredAudios.map((audio) => audio.audioid);
      setSelectedAudios(allAudioIds);
    } else {
      setSelectedAudios([]);
    }
  };

  const handleCreatePlaylist = () => {
    if (!playlistTitle || selectedAudios.length === 0) {
      alert("Please provide a title and select at least one audio.");
      return;
    }

    const playlistData = {
      title: playlistTitle,
      audioIds: selectedAudios,
    };

    fetch("http://localhost:8080/api/playlist/addPlaylistDetails", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(playlistData),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to create playlist");
        }
        return response.json();
      })
      .then(() => {
        alert("Playlist created successfully!");
        setPlaylistTitle("");
        setSelectedAudios([]);
        setSelectAll(false);

        // Refresh the playlists
        return fetch("http://localhost:8080/api/playlist");
      })
      .then((response) => response.json())
      .then((data) => setPlaylists(data))
      .catch((error) => {
        console.error("Error creating playlist:", error);
        alert("Failed to create playlist. Please try again.");
      });
  };

  return (
    <div className="playlist-container">
      <div className="mb-8">
        <h2 className="text-2xl font-bold mb-4 flex items-center">
          <Music className="mr-2" /> Create New Playlist
        </h2>
        <div className="bg-white rounded-lg shadow p-6">
          <input
            type="text"
            placeholder="Playlist Title"
            value={playlistTitle}
            onChange={(e) => setPlaylistTitle(e.target.value)}
            required
            className="w-full p-3 border rounded-lg mb-4 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
          />
          
          <div className="flex items-center mb-4">
            <div className="relative flex-1">
              <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400" aria-label="Search" />
              <input
                type="text"
                placeholder="Search audio files..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="w-full pl-10 pr-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
              />
            </div>
            <button
              onClick={handleSelectAll}
              className="ml-4 px-4 py-2 text-sm bg-gray-100 border rounded-lg hover:bg-gray-200 transition-colors"
            >
              {selectAll ? 'Deselect All' : 'Select All'}
            </button>
          </div>

          <div className="max-h-96 overflow-y-auto border rounded-lg p-4">
            {isLoading ? (
              <p className="text-center py-4">Loading audio files...</p>
            ) : filteredAudios.length > 0 ? (
              <div className="space-y-2">
                {filteredAudios.map((audio) => (
                  <div
                    key={audio.audioid}
                    className="flex items-center p-3 hover:bg-gray-50 rounded-lg cursor-pointer"
                    onClick={() => handleAudioSelection(audio.audioid)}
                  >
                    <div className="flex items-center flex-1">
                      <input
                        type="checkbox"
                        id={`audio-${audio.audioid}`}
                        checked={selectedAudios.includes(audio.audioid)}
                        onChange={() => {}}
                        className="mr-3 h-4 w-4 text-blue-500"
                      />
                      <label
                        htmlFor={`audio-${audio.audioid}`}
                        className="flex-1 cursor-pointer"
                      >
                        {audio.title}
                      </label>
                    </div>
                    {selectedAudios.includes(audio.audioid) && (
                      <CheckCircle className="text-green-500 ml-2" size={20} />
                    )}
                  </div>
                ))}
              </div>
            ) : (
              <p className="text-gray-500 text-center py-4">No audio files found.</p>
            )}
          </div>

          <button
            onClick={handleCreatePlaylist}
            className="mt-4 w-full px-4 py-3 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition-colors flex items-center justify-center"
            disabled={!playlistTitle || selectedAudios.length === 0}
          >
            <Plus className="mr-2" size={20} />
            Create Playlist ({selectedAudios.length} audio{selectedAudios.length !== 1 ? 's' : ''} selected)
          </button>
        </div>
      </div>

      <div className="mt-8">
        <h3 className="text-xl font-bold mb-4 flex items-center">
          <Music className="mr-2" /> Existing Playlists
        </h3>
        <div className="bg-white rounded-lg shadow">
          {playlists.length > 0 ? (
            <ul className="divide-y">
              {playlists.map((playlist) => (
                <li key={playlist.playlistid} className="p-4 hover:bg-gray-50">
                  <div className="flex items-center justify-between">
                    <strong className="text-lg">{playlist.title}</strong>
                    <span className="text-sm text-gray-500">
  {/* {playlist.user && playlist.user.id ? `User ID: ${playlist.user.id}` : 'No user assigned'} */}
</span>

                  </div>
                </li>
              ))}
            </ul>
          ) : (
            <p className="text-gray-500 text-center py-6">No playlists available. Create one to get started!</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Playlist;