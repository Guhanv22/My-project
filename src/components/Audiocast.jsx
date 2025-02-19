// Audiocast.jsx
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Eye, ShoppingCart } from 'lucide-react';
import './Audiocast.css';

const Audiocast = () => {
  const [audiocasts, setAudiocasts] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    fetch('http://localhost:8080/api/audiocast')
      .then((response) => {
        if (!response.ok) throw new Error('Failed to fetch audiocast data');
        return response.json();
      })
      .then((data) => {
        setAudiocasts(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error.message);
        setLoading(false);
      });
  }, []);

  const filteredAudiocasts = audiocasts.filter((audiocast) =>
    audiocast.title.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div className="audiocast-container">
      <nav className="navbar">
        <h1>Vocal Haven</h1>
        <input
          type="text"
          placeholder="Search audiocasts..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
      </nav>
      <main>
        {loading && <p>Loading audiocasts...</p>}
        {error && <p className="error">Error: {error}</p>}
        <div className="audiocast-list">
          {filteredAudiocasts.length > 0 ? (
            filteredAudiocasts.map((audiocast) => (
              <div key={audiocast.audiocastid} className="audiocast-card">
                <img
                  src={audiocast.imageUrl || '/default-image.jpg'}
                  alt={audiocast.title || 'Audiocast Image'}
                />
                <h2>{audiocast.title || 'Unknown Title'}</h2>
                <p>{audiocast.description || 'No description available'}</p>
                <div className="card-actions">
                  <button
                    onClick={() => navigate(`/view/${audiocast.audiocastid}`)}
                  >
                    <Eye size={20} /> View
                  </button>
                  <button
                    onClick={() => navigate(`/order/${audiocast.audiocastid}`)}
                  >
                    <ShoppingCart size={20} /> Buy
                  </button>
                </div>
              </div>
            ))
          ) : (
            <p>No audiocasts found.</p>
          )}
        </div>
      </main>
      <footer>
        <p>&copy; 2025 Vocal Haven. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default Audiocast;