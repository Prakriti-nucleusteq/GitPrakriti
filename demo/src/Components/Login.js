import React, { useState } from "react";
import axios from "axios";
import "./Login.css";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useAuth } from "./auth";
import ViewSingleTicket from "./ViewSingleTicket";
const Login = () => {
  const navigate = useNavigate();
  
  const initialValues = { emailId: "", lpassword: "" };
  const [loginValues, setLoginValues] = useState(initialValues);
  const [loginError, setLoginErrors] = useState({});
  const auth = useAuth();
  let isValid = false;
  const loginHandle = (e) => {
    const { name, value } = e.target;
    setLoginValues({ ...loginValues, [name]: value });
    console.log(loginValues);
  };

  const loginSubmitHandle = (e) => {
    auth.login(loginValues);
    setLoginErrors(valid(loginValues));
    if (isValid) {
      axios
        .post("http://54.95.126.93:9090/api/users/login", {
          email: loginValues.emailId,
          password: loginValues.lpassword,
        })
        .then(({ data }) => {
          console.log("response", data);
      
          localStorage.setItem("users", JSON.stringify(data))
          localStorage.setItem("eid",data.employeeId)
          localStorage.setItem("first",data.firstName)
          localStorage.setItem("last",data.lastName)

          if (data.gender === "Admin") {
            navigate("/home");

            
          } else {
            navigate("/home-employee");
            
          }
        })

        .catch((error) => {
          toast.error( error.response.data.message, {
            position: toast.POSITION.TOP_RIGHT,
          });
          console.log("error", error.response.data.message);
        });
    }
    setLoginValues(initialValues);
  };

  const valid = (values) => {
    const errors = {};
    if (!values.emailId) {
      errors.emailId = "Email Id is required";
    } else if (!/^[a-zA-Z0-9]+@nucleusteq.com+$/i.test(values.emailId)) {
      errors.emailId = "Email address invalid";
    }
    if (!values.lpassword) {
      errors.lpassword = "Password required";
    } else isValid = true;
    return errors;
  };

  return (
    <>
      <ToastContainer />
      <div className="main-box">
        <div className="image-box">
          <img
            src="https://efacility.r.worldssl.net/wp-content/uploads/2020/05/Helpdesk.png"
            alt="login-image"
            className="loginimage"
          />
        </div>
        <div className="login-box">
          <div className="login-form">
          
            <h1 className="heading">HelpDesk Portal</h1>
            <h3 className="subheading">Login</h3>
            <div className="login-input">
              <label for="emailId" className="login-label">
                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                &nbsp;&nbsp;Email ID:{" "}
                
              </label>
              <input
                type="text"
                id="emailId"
                name="emailId"
                className="form-input"
                placeholder="Enter your email id"
                title="Email should be of nucleusteq domain only"
                value={loginValues.emailId}
                onChange={loginHandle}
              />
              <div className="validation-msg">{loginError.emailId}</div>
            </div>
            <br></br>
            <div className="login-input">
              <label for="lpassword" className="login-label">
                <i class="fa fa-lock" aria-hidden="true"></i>
                &nbsp;&nbsp;Password:{" "}
                
              </label>
              <input
                type="password"
                id="lpassword"
                name="lpassword"
                className="form-input"
                placeholder="Enter password"
                value={loginValues.lpassword}
                onChange={loginHandle}
              />
              <div className="validation-msg">{loginError.lpassword}</div>
            </div>
            <button
              className="submit-btn"
              type="submit"
              onClick={() => loginSubmitHandle()}
            >
              Login
            </button>

          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
