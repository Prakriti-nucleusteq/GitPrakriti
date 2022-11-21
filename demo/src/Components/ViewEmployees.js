import { useState } from "react";
import React,{ useEffect } from "react";
import AddEmployee from "./AddEmployee";
import { Button } from "reactstrap";
import axios from "axios";
import Employees from "./Employees";
import { toast } from "react-toastify";
import "./ViewTicket.css";
import {useNavigate} from "react-router-dom";
import Navbar from "./Navbar";
import { BASE_URL } from "../Api/EndPoint/Index.js";

const ViewEmployees = () =>
{
    const navigate = useNavigate();
    useEffect(() => {
        document.title = "View employee";
    }, []);
    const [Employee,setEmployee]=useState([]);

    const updateEmployee=(id)=>{
        setEmployee(Employee.filter((c)=> c.id != id));
    }

    const getAllEmployees = () => {
        axios.get(BASE_URL+'/api/users/all').then(
            (response) => {
                console.log(response.data);
                //toast.success("Employees have been loaded");
                setEmployee(response.data);
            },
            (error) => {
                console.log(error);
                toast.error("Something went wrong")
            }
        );
    };

    useEffect(() =>{
        getAllEmployees();
    }, []);
    


    return(
        <><Navbar /><div>

            <h3> list of employees </h3>
            <table className="table d">
                <thead>
                    <tr className="tr">
                        <th> Id</th>
                        <th>Employee Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email id</th>
                        <th>Contact</th>

                    </tr>
                </thead>
            </table>


            {/* map is data collection where data is store in the form of pairs which contain unique key .the value stored in the map must be map in the
    key. */}
            {Employee.length > 0
                ? Employee.map((item) => <Employees key={item.id} employees={item} update={updateEmployee} />)
                : "No employee"}
            <button
                className="form-cancel-btn"
                onClick={() => navigate('/home')}
            >
                Back
            </button>
        </div></>
    )
}
export default ViewEmployees;
