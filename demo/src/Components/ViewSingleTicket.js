import { useState } from "react";
import React,{ useEffect } from "react";
import AddEmployee from "./AddEmployee";
import { Button } from "reactstrap";
import axios from "axios";
import Employees from "./Employees";
import { toast } from "react-toastify";
import Categories from "./Categories";
import SingleTicket from "./SingleTicket";
import Login from "./Login";
import { BASE_URL } from "../Api/EndPoint/index.js";

const ViewSingleTicket = () =>
{
    useEffect(() => {
        document.title = "View Tickets";
    }, []);
    const [Ticket,setTicket]=useState([]);

    const updateTicket=(Id)=>{
        setTicket(Ticket.filter((c)=> c.ticketId != Id));
    }

    const getAllTickets = () => {
        const eid = localStorage.getItem("eid")
        axios.get(BASE_URL+`/api/tickets/${eid}`).then(
            (response) => {
                console.log(response.data);
               
                
               // toast.success("Tickets have been loaded");
                setTicket(response.data);
                
                
                
                
                
            },
            (error) => {
                console.log(error);
              //  toast.error("Something went wrong")
            }
        );
    };
    console.log()
    useEffect(() =>{
        getAllTickets();
    }, []);
    


    return(

        
        <div>
    
          <h3> list of Tickets </h3>

          <table className="table d">
                    <thead>
                        <tr className="tr">
                            <th>Ticket Id</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Sub Category</th>
                            <th>Priority</th>
                            <th>Status</th>
                            <th>description</th>
                            <th>Assigned to</th>
                        </tr>
                    </thead>
                </table>

          {
          Ticket.length > 0
          ? Ticket.map((item) => <SingleTicket key={item.ticketId} tickets ={item} update={updateTicket} />)
        : "No employee"
        }
        </div>
    )
}
export default ViewSingleTicket;
