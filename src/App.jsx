import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';
 import Layout from './components/Layout'; 
//  import History from './components/History';
 import Playlist from './components/Playlist';
import ViewPage from './components/ViewPage';
import PaymentPage from './components/PaymentPage';
import Favourites from './components/Favourites';


// import HistoryIcon from '@mui/icons-material/History';
// import PlaylistPlayIcon from '@mui/icons-material/PlaylistPlay';
// import FavoriteIcon from '@mui/icons-material/Favorite';

// import Playlist from './Playlist';
// import Favorites from './Favorites';
function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Register />} />   
               <Route path="/Register" element={<Register />} />
                <Route path="/Login" element={<Login />} />
                <Route path="/Layout" element={<Layout />} />
                {/* <Route path="/History" element={<History />} /> */}
                <Route path="/Playlist" element={<Playlist />} />
                <Route path="/view/:audioId" element={<ViewPage />} />
                <Route path="/order/:audioId" element={<PaymentPage />} />
                <Route path="/Favourites" element={<Favourites />} />
            </Routes>
        </Router>
    );
 }

 export default App;
// import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
// import { BottomNavigation, BottomNavigationAction } from '@mui/material';
// import Register from './components/Register';
// import Login from './components/Login';
// import Home from './components/Home';
// // import PersonAddIcon from '@mui/icons-material/PersonAdd';
// // import LoginIcon from '@mui/icons-material/Login';
// // import HomeIcon from '@mui/icons-material/Home';
// import { useState } from 'react';
//  // Import the external CSS

// function App() {
//     const [value, setValue] = useState(0);

//     return (
//         <Router>
//             <div className="app-container">
//                 {/* Routes for different pages */}
//                 <Routes>
//                     <Route path="/" element={<Register />} />
//                     <Route path="/register" element={<Register />} />
//                     <Route path="/login" element={<Login />} />
//                     <Route path="/home" element={<Home />} />
//                 </Routes>

//                 {/* Bottom Navigation */}
//                 <BottomNavigation
//                     value={value}
//                     onChange={(event, newValue) => setValue(newValue)}
//                     showLabels
//                     className="bottom-nav"
//                 >
//                     <BottomNavigationAction
//                         label="Register"
//                         icon={<PersonAddIcon />}
//                         component={Link}
//                         to="/register"
//                     />
//                     <BottomNavigationAction
//                         label="Login"
//                         icon={<LoginIcon />}
//                         component={Link}
//                         to="/login"
//                     />
//                     <BottomNavigationAction
//                         label="Home"
//                         icon={<HomeIcon />}
//                         component={Link}
//                         to="/home"
//                     />
//                 </BottomNavigation>
//             </div>
//         </Router>
//     );
// }

// export default App;
