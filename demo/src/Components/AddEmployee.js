import React, { useState } from "react";
import "./AddEmployee.css";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Navbar from "./Navbar";
import {useNavigate} from "react-router-dom";
import { BASE_URL } from "../Api/EndPoint/Index.js";

const AddEmployee = () => {

  const navigate = useNavigate();
  const postValues = { firstName: "",
  lastName: "",
  email: "",
  contact: "",
  gender:"",
  dob:"",
  password: "",
  confirm_pass: "",
  role: "",
  employeeId: "",
  city:"",
  state:"",
  designation:"",
  country:"" };

  const initialValues = { 
  firstName: "",
  lastName: "",
  email: "",
  contact: "",
  gender:"",
  dob:"",
  password: "",
  confirm_pass: "",
  role: "",
  employeeId: "" ,
  city:"",
  state:"",
  designation:"",
  country:"" 
};

  const [formValues, setFormValues] = useState(postValues);
  const [formErrors, setFormErrors] = useState({});
  const [isActiveValidate, setIsActiveValidate] = useState(false);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
    if (isActiveValidate) {
      isValidate(formValues);
    }
  };
  const handleSubmit = () => {
    console.log(isValidate(formValues));
    setIsActiveValidate(true);
    if (isValidate(formValues)) {
      axios
      .post(BASE_URL+"/api/users/create", {
        firstName: formValues.firstName,
        lastName: formValues.lastName,
        email: formValues.email,
        contact: formValues.contact,
        employeeId: formValues.employeeId,
        password: formValues.password,
        role: formValues.role,
        gender: formValues.gender,
        dob: formValues.dob,
        city: formValues.city,
        state: formValues.state,
        country: formValues.country,
        designation: formValues.designation
      })
      .then(data=>{
        console.log("response data", data);
        toast.success(" User added Successfully!", {
          position: toast.POSITION.TOP_RIGHT,
        });
      })
      .catch((err) => {
        console.log("err", err);
        toast.error("Email Id Already in use", {
          draggable: true,
          position: toast.POSITION.TOP_CENTER,
        });
      });
    }
  };

  const handleCancel = () => {
    setFormValues(initialValues)
  }
  const isValidate = (values) => {
    var isStatus = true;
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;
    
    if (!values.firstName) {
      initialValues.firstName = "firstName is required!";
      isStatus = false;
    } else {
      initialValues.firstName = "";
    }

    if (!values.lastName) {
      initialValues.lastName = "lastName is required!";
      isStatus = false;
    } else {
      initialValues.lastName = "";
    }

    if (!values.email) {
      initialValues.email = "Email is required!";
      isStatus = false;
    } else if (!regex.test(values.email)) {
      initialValues.email = "Company Domain required!";
      isStatus = false;
    } else {
      initialValues.email = "";
    }

    if (!values.password) {
      initialValues.password = "Password required";
      isStatus = false;
    } else if (values.password.length < 8) {
      initialValues.password = "Password should have atleast 8 characters";
    } else {
      initialValues.password = "";
    }

    if (!values.confirm_pass) {
      initialValues.confirm_pass = "Password required";
      isStatus = false;
    } else if (values.password !== values.confirm_pass) {
      initialValues.confirm_pass = "Passwords do not match";
      isStatus = false;
    } else {
      initialValues.confirm_pass = "";
    }

    if (!values.contact) {
      initialValues.contact = "Mobile number required";
      isStatus = false;
    } else if (!/^([6789]{1})([0-9]{9})$/.test(values.contact)) {
      initialValues.contact = "Mobile number is invalid";
      isStatus = false;
    } else {
      initialValues.contact = "";
    }
   
    if (!values.dob){
      initialValues.dob = "DoJ required";
      isStatus = false;
    } else {
      initialValues.dob = "";
    }

    if (!values.employeeId) {
      initialValues.employeeId = "employeeId required";
      isStatus = false;
    } else {
      initialValues.employeeId = "";
    }

    //Gender
    if(!values.gender){
      initialValues.gender = "Gender required"
      isStatus = false;
    } else {
      initialValues.gender = "";
    }

    if(!values.city){
      initialValues.city = "city required"
      isStatus = false;
    } else {
      initialValues.city = "";
    }

    if(!values.state){
      initialValues.state = "state required"
      isStatus = false;
    } else {
      initialValues.state = "";
    }

    if(!values.country){
      initialValues.country = "country required"
      isStatus = false;
    } else {
      initialValues.country = "";
    }

    if(!values.designation){
      initialValues.designation = "designation required"
      isStatus = false;
    } else {
      initialValues.designation = "";
    }



    if (!values.role) {
      initialValues.role = "Role cannot be empty";
      isStatus = false;
    } else {
      initialValues.role = "";
    }

    setFormErrors(initialValues);
    return isStatus;
  };

 


  

  return (
    <>
      <Navbar />
      <div className="registration-form">
        <ToastContainer />

        
        <div className="form">
          <h1 className="heading1">Create an user</h1>
          <hr className="hrule"></hr>
          <div className="grid_container">
            <div className="form-inputs">
              <label for="first_name" className="form_label">
                First Name:{" "}
              </label>
              <input
                type="text"
                id="first_name"
                name="firstName"
                className="form_input"
                placeholder="Enter your first name"
                value={formValues.firstName}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.firstName}
              </span>
            </div>

            <div className="form-inputs">
              <label for="lastName" className="form_label">
                Last Name:{" "}
              </label>
              <input
                type="text"
                id="last_name"
                name="lastName"
                className="form_input"
                placeholder="Enter your last name"
                value={formValues.lastName}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.lastName}
              </span>
            </div>

            <div className="form-inputs">
              <label for="email" className="form_label">
                Email:{" "}
              </label>
              <input
                type="text"
                id="email"
                name="email"
                className="form_input"
                placeholder="Enter your email id"
                title="Email should be of nucleusteq domain only"
                value={formValues.email}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">{formErrors.email}</span>
            </div>

            <div className="form-inputs">
              <label for="mobile_no" className="form_label">
                Mobile Number:{" "}
              </label>
              <input
                type="text"
                id="mobile_no"
                name="contact"
                className="form_input"
                placeholder="Enter your mobile number"
                title="10 Digit Phone number starting with 6/7/8/9"
                maxLength={10}
                minLength={10}
                value={formValues.contact}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.contact}
              </span>
            </div>
            
          </div>
          <div className="grid_container">
            
          <div className="form-inputs">
              <label for="employeeId" className="form_label">
                EmployeeId:{" "}
              </label>
              <input
                type="text"
                id="employeeId"
                name="employeeId"
                className="form_input"
                placeholder="Enter your employeeId"
                value={formValues.employeeId}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.employeeId}
              </span>
            </div>

            <div className="form-inputs">
              <label for="gender" className="form_label">
                Gender:{" "}
              </label>
             
              <select
                id="gender"
                name="gender"
                className="form_input"
                value={formValues.gender}
                onChange={handleChange}
                >
                  <option value="" disabled selected hidden>Select your option</option>
                  <option value="MALE">MALE</option>
                  <option value="FEMALE">FEMALE</option>
              </select>
              <span className="valid-registration-msg">
                {formErrors.gender}
              </span>
            </div>

            <div className="form-inputs">
              <label for="dob" className="form_label">
                Date Of Joining:{" "}
              </label>
              <input
                type="date"
                id="dob"
                name="dob"
                className="form_input"
                placeholder="Enter your dob"
                value={formValues.dob}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.dob}
              </span>
            </div>
            <div className="form-inputs">
              <label for="city" className="form_label">
                City:{" "}
              </label>
              <input
                type="text"
                id="city"
                name="city"
                className="form_input"
                placeholder="Enter your city"
                value={formValues.city}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.city}
              </span>
            </div>

            <div className="form-inputs">
              <label for="state" className="form_label">
                State:{" "}
              </label>
              <input
                type="text"
                id="state"
                name="state"
                className="form_input"
                placeholder="Enter your state"
                value={formValues.state}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.state}
              </span>
            </div>

            <div className="form-inputs">
              <label for="country" className="form_label">
                Country:{" "}
              </label>
              <input
                type="text"
                id="country"
                name="country"
                className="form_input"
                placeholder="Enter your country"
                value={formValues.country}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.country}
              </span>
            </div>

           
            <div className="form-inputs">
              <label for="designation" className="form_label">
              Designation:{" "}
              </label>
              
              <select
                id="designation"
                name="designation"
                className="form_input"
                value={formValues.designation}
                onChange={handleChange}
                
                >
                  <option value=""  disabled selected hidden>Select an option</option>
                  <option value="INTERN" >INTERN</option>
                  <option value="ENGINEER" >ENGINEER</option>
                  <option value="SENIOR ENGINEER" >SENIOR ENGINEER</option>
                  <option value="PROJECT MANAGER" >PROJECT MANAGER</option>
                  <option value="DELIVERY MANAGER" >DELIVERY MANAGER</option>
                  <option value="ARCHITECT" >ARCHITECT</option>
                  <option value="SENIOR ARCHITECT" >SENIOR ARCHITECT</option>
                  <option value="TECH LEAD" >TECH LEAD</option>
                  <option value="HR" >HR</option>
                  <option value="OTHER" >OTHER</option>
              </select>
              <span className="valid-registration-msg">
                {formErrors.designation}
              </span>
            </div>


            <div className="form-inputs">
              <label for="password" className="form_label">
                Password:{" "}
              </label>
              <input
                type="password"
                id="password"
                name="password"
                className="form_input"
                placeholder="Enter a password"
                value={formValues.password}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.password}
              </span>
            </div>
            <div className="form-inputs">
              <label for="confirm_pass" className="form_label">
                Confirm Password:{" "}
              </label>
              <input
                type="password"
                id="confirm_pass"
                name="confirm_pass"
                className="form_input"
                placeholder="Confirm your password"
                value={formValues.confirm_pass}
                onChange={handleChange}
              />
              <span className="valid-registration-msg">
                {formErrors.confirm_pass}
              </span>
            </div>
            <div className="form-inputs">
              <label for="role" id="role" className="form_label">
                Role:
              </label>
              <span className="radio-btns">
                <input
                  type="radio"
                  name="role"
                  id="admin"
                  value="admin"
                  checked={formValues.role === "admin"}
                  onChange={handleChange}
                />
                &nbsp; Admin
                <input
                  type="radio"
                  name="role"
                  id="employee"
                  value="employee"
                  checked={formValues.role === "employee"}
                  onChange={handleChange}
                />
                &nbsp; Employee
                {/* <p>{formValues.role}</p> */}
              </span>
              <span
                className="valid-registration-msg"
                id="validation-radio-btn"
              >
                {formErrors.role}
              </span>
            </div>
          </div>
          <button
            className="form-cancel-btn"
            onClick={() => navigate('/home')}
          >
            Back
          </button> 

          <button className="form-input-btn" onClick={() => handleSubmit()}>
          {/* disabled = {formValues.email == ''}  */}
            Register
          </button>
           

          <button
            className="form-cancel-btn"
            onClick={() => handleCancel()}
          >
            Reset
          </button> 

         </div>
         <div className="image-box">
        <img src="https://efacility.r.worldssl.net/wp-content/uploads/2020/05/Helpdesk.png" alt="login-image" className="loginimage" />
      </div>
      </div>
    </>
  );
};

export default AddEmployee;
