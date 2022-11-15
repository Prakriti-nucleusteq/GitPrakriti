import React from 'react'
import EmployeeNavbar from './EmployeeNavbar';
import './HomeEmployee.css'
import ViewEmployees from './ViewEmployees';
import ViewSingleTicket from './ViewSingleTicket';
import {useNavigate} from "react-router-dom";

const HomeEmployee = () => {
  const navigate = useNavigate();
  return (
    <><EmployeeNavbar/>
    <ViewSingleTicket/>
    <button
            className="form-cancel-btn"
            onClick={() => navigate('/')}
          >
            Back
          </button> 
    </>
  )
}

export default HomeEmployee;