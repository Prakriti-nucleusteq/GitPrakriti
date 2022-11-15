import "./Navbar.css";
import { Link } from "react-router-dom";
export default function Navbar() {
  return (
    <nav className="nav">
      <a href="/admin/home" className="site-title">
        Help Desk Portal
      </a>
      <ul>
        <div className="dropdown">
          <li className="drop-btn">
            Users &nbsp;<i class="fa fa-caret-down"></i>
          </li>
          <div className="dropdown-content">
            <li className="list-element">
              <Link className="navbar-option" to="/view-employee">
                View Users
              </Link>
            </li>
            <li className="list-element">
              <Link className="navbar-option" to="/add-employee">
                Add User
              </Link>
            </li>
          </div>
        </div>
        <div className="dropdown">
          <li className="drop-btn">
            Categories &nbsp;<i class="fa fa-caret-down"></i>
          </li>
          <div className="dropdown-content">
            <li className="list-element">
              <Link className="navbar-option" to="/add-category">
                Add Categories
              </Link>
            </li>
            <li className="list-element">
              <Link className="navbar-option" to="/view-category">
                View Categories
              </Link>
            </li>
          </div>
        </div>

        <li className="list-element">
          <Link className="navbar-option" to="/">
            Logout
          </Link>
        </li>
      </ul>
    </nav>
  );
}
