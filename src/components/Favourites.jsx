import { useEffect, useState } from "react";

const Favourites = () => {
  const [favourites, setFavourites] = useState([]);
  const [newFavourite, setNewFavourite] = useState({
    user: { id: "" },
    audiocast: { audiocastid: "" },
  });

  // Fetch all favourites on component load
  useEffect(() => {
    fetch("http://localhost:8080/api/favourites")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch favourites.");
        }
        return response.json();
      })
      .then((data) => setFavourites(data))
      .catch((error) => console.error("Error fetching favourites:", error));
  }, []);

  // Add a new favourite
  const handleAddFavourite = (event) => {
    event.preventDefault();

    // Log data before sending
    console.log("Adding new favourite:", newFavourite);

    fetch("http://localhost:8080/api/favourites/addFavouritesDetails", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newFavourite),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to add favourite.");
        }
        return response.json();
      })
      .then((addedFavourite) => {
        setFavourites((prevFavourites) => [...prevFavourites, addedFavourite]);
        setNewFavourite({ user: { id: "" }, audiocast: { audiocastid: "" } });
      })
      .catch((error) => console.error("Error adding favourite:", error));
  };

  return (
    <div className="favourites-container">
      <h1 className="text-2xl font-bold mb-4">Favourites List</h1>

      {/* Displaying the list */}
      <table className="w-full border-collapse border border-gray-300">
        {/* <thead>
          <tr className="bg-gray-200">
            <th className="border border-gray-300 px-4 py-2">ID</th>
            <th className="border border-gray-300 px-4 py-2">User ID</th>
            <th className="border border-gray-300 px-4 py-2">Audiocast ID</th>
          </tr>
        </thead> */}
        <tbody>
          {favourites.map((favourite) => (
            <tr key={favourite.favouritesid} className="border-b">
              <td className="border border-gray-300 px-4 py-2">
                {favourite?.favouritesid ?? "N/A"}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {favourite?.user?.id ?? "N/A"}
              </td>
              <td className="border border-gray-300 px-4 py-2">
                {favourite?.audiocast?.audiocastid ?? "N/A"}
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Form to add a new favourite */}
      <h2 className="text-xl font-bold mt-6 mb-2">Add New Favourite</h2>
      <form onSubmit={handleAddFavourite}>
        <div className="mb-4">
          <label className="block font-bold mb-1">User ID:</label>
          <input
            type="text"
            value={newFavourite.user.id}
            onChange={(e) =>
              setNewFavourite({
                ...newFavourite,
                user: { id: e.target.value },
              })
            }
            className="border rounded px-2 py-1 w-full"
            required
          />
        </div>

        <div className="mb-4">
          <label className="block font-bold mb-1">Audiocast ID:</label>
          <input
            type="text"
            value={newFavourite.audiocast.audiocastid}
            onChange={(e) =>
              setNewFavourite({
                ...newFavourite,
                audiocast: { audiocastid: e.target.value },
              })
            }
            className="border rounded px-2 py-1 w-full"
            required
          />
        </div>

        <button
          type="submit"
          className="bg-blue-500 text-white px-4 py-2 rounded"
        >
          Add Favourite
        </button>
      </form>
    </div>
  );
};

export default Favourites;