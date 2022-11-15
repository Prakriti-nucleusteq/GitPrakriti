import React from 'react'
import './Home.css'
import Navbar from './Navbar'
import ViewTicket from './ViewTicket'
import {useNavigate} from "react-router-dom";

const AdminHomePage = () => {
  const navigate = useNavigate();
  
  return (
    <>
    <Navbar/>
    <ViewTicket/>
    <button
            className="form-cancel-btn"
            onClick={() => navigate('/')}
          >
            Back
          </button> 
    </>
  )
}

export default AdminHomePage;