// import { useState, useEffect } from 'react';
// import './History.css';

//  const History = () => {
//   const [historyData, setHistoryData] = useState([]); // To store the fetched history data
//   const [loading, setLoading] = useState(true); // To manage loading state
//   const [error, setError] = useState(null); // To store any error message

//   // Fetch history details from backend
//   useEffect(() => {
//     fetch('http://localhost:8080/api/history') // Adjust URL based on your backend
//       .then(response => {
//         if (!response.ok) {
//           throw new Error('Failed to fetch history data');
//         }
//         return response.json();
//       })
//       .then(data => {
//         console.log('Fetched history data:', data); // Log data structure for debugging
//         setHistoryData(data);
//         setLoading(false);
//       })
//       .catch(error => {
//         setError(error.message);
//         setLoading(false);
//       });
//   }, []);

//   return (
//     <div className="container mx-auto p-4">
//       <h1 className="text-2xl font-bold mb-4">User History</h1>

//       {loading && <p>Loading history...</p>}
//       {error && <p style={{ color: 'red' }}>Error: {error}</p>}
      
//       {/* Display if no data is found and loading is done */}
//       {historyData.length === 0 && !loading && !error && <p>No history records found.</p>}

//       <div className="history-list">
//         {historyData.map((history) => (
//           <div key={history.historyid} className="history-item border p-4 mb-4 rounded-md">
//             <h2 className="text-xl font-semibold" ><p style ={{color:'black'}}>History ID: {history.historyid}</p></h2>
//             <p style={{color:'black'}}><strong>User ID:</strong> {history.user?.id || 'N/A'}</p>
//             <p style={{color:'black'}}><strong>AudioBook ID:</strong> {history.audiobookid || 'N/A'}</p>
//             <p style={{color:'black'}}><strong>Podcast ID:</strong> {history.podcastid || 'N/A'}</p>
//             <p style={{color:'black'}}><strong>Last Listened:</strong> {history.lastlistened ? new Date(history.lastlistened).toLocaleString() : 'N/A'}</p>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// };

// export default History;
import  { useEffect, useState } from 'react';

const History = () => {
  const [history, setHistory] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Fetch user's history from the backend using fetch API
    fetch('http://localhost:8080/api/history')  // Update with your actual backend URL
      .then((response) => {
        if (!response.ok) {
          throw new Error('Error fetching history');
        }
        return response.json();
      })
      .then((data) => {
        setHistory(data);
      })
      .catch((err) => {
        setError(err.message);
        console.error(err);
      });
  }, []);

  return (
    <div className="history-container">
      <h2>Last Listened Audio History</h2>

      {error && <p className="error-message">{error}</p>}

      {history.length === 0 ? (
        <p>No history available.</p>
      ) : (
        <ul>
          {history.map((entry) => (
            <li key={entry.historyid}>
              <div>
                <h3>Last Listened to:</h3>
              
                <p>Last listened on: {new Date(entry.lastlistened).toLocaleString()}</p>
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default History;

