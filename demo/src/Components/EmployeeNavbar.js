import React from 'react'
import './EmployeeNavbar.css'
import { Link } from "react-router-dom";

const EmployeeNavbar = () => {
  return (
    <nav className="empnav">
      <a href="/employee/home" className="emp-site-title">
        Help Desk Portal
      </a>
      <ul>
        <div className="empdropdown">
          <li className="empdrop-btn">
            Tickets &nbsp;<i class="fa fa-caret-down"></i>
          </li>
          <div className="empdropdown-content">
            <li className="emplist-element">
              <Link className="empnavbar-option" to="/Add-ticket">
                Create Ticket
              </Link>
            </li>
          </div>
        </div>
        <li className="emplist-element">
          <Link className="empnavbar-option" to="/">
            Logout
          </Link>
        </li>
      </ul>
    </nav>
  )
}

export default EmployeeNavbar;