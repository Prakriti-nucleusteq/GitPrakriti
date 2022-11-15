//import logo from './logo.svg';
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { AuthProvider } from "./Components/auth";
import Registration from "./Components/Registration";
import Home from "./Components/Home";
import Login from "./Components/Login";
import Base from "./Components/Base";

import AddEmployee from "./Components/AddEmployee";
import ViewEmployees from "./Components/ViewEmployees";
import HomeEmployee from "./Components/HomeEmployee";
import Categories from "./Components/Categories";
import ViewCategories from "./Components/ViewCategories";
import AddCategory from "./Components/AddCategory";
import UpdateEmployee from "./Components/UpdateEmployee";

import ViewTicket from "./Components/ViewTicket";
import AddTicket from "./Components/AddTicket";
import UpdateTicket from "./Components/UpdateTicket";
import { RequireAuth } from "./Components/RequireAuth";
import ticketUpdate from "./Components/ticketUpdate";


function App() {
  return (
    <><div className="App">
      <Base />
      <AuthProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<RequireAuth><Home /></RequireAuth>} />
          <Route path="/register" element={<RequireAuth><Registration /></RequireAuth>} />
          <Route path="/add-employee" element={<RequireAuth><AddEmployee /></RequireAuth>} />
          <Route path="/view-employee" element={<RequireAuth><ViewEmployees /></RequireAuth>} />
          <Route path="/home-employee" element={<RequireAuth><HomeEmployee /></RequireAuth>} />
          <Route path="/view-category" element={<RequireAuth><ViewCategories /></RequireAuth>} />
          <Route path="/add-category" element={<RequireAuth><AddCategory /></RequireAuth>} />
        
          <Route path="/update-employee" element={<UpdateEmployee />} />
          <Route path="/update-ticket" element={<UpdateTicket />} />
          <Route path="/view-ticket" element={<RequireAuth><ViewTicket /></RequireAuth>} />
          <Route path="/Add-ticket" element={<RequireAuth><AddTicket /></RequireAuth>} />
          {/* <Route path="/u-ticket" element={<ticketUpdate/>} /> */}

        </Routes>
      </Router>
      </AuthProvider>
    </div>
    </>
  );
}

export default App;