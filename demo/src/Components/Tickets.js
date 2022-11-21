import axios from "axios";
import React from "react"
import { toast } from "react-toastify";
import { Button, Card, CardBody, CardSubtitle, CardText, Col, Container, Row, Toast } from "reactstrap";
import props from "react";
import { BASE_URL } from "../Api/EndPoint/Index.js";

import { render } from "@testing-library/react";
import { useState, createContext, useContext } from "react";
import "./Tickets.css";



const Tickets = ({ tickets, update, onUpdate }) => {


    const deleteTicket = (ticketId) => {
        axios.delete(BASE_URL+`/api/ticket/${ticketId}`).then(
            (response) => {
                //toast.success("Ticket Deleted Successfully")
                alert("Ticket Deleted Successfully")
                update(ticketId);
            },
            (error) => {
                //alert("Server Error, Could not delete")
                toast.error("Server Error, Could not delete")
                console.log(ticketId)
            }
        )
    }






    localStorage.setItem("Tid", tickets.ticketId)

    return (

        <>

            <Card className="text-center">
                <div class="newspaper">
                    <table className="table d">

                        <tr className="tr">

                            <td>{tickets.ticketId}</td>

                            <td>{tickets.name}</td>
                            <td>{tickets.category}</td>
                            <td>{tickets.subCategory}</td>
                            <td>{tickets.priority}</td>
                            <td>{tickets.status}</td>
                            <td>{tickets.description}</td>
                            <td>{tickets.assigned}</td>





                        </tr>
                    </table>
                    {console.log(tickets)}
                </div>
            </Card>
            <Card className="text-center">
                <CardBody>



                    <Container className="text-center">
                        <Button color="danger" onClick={() => {
                            deleteTicket(tickets.ticketId)

                        }}>Delete</Button>
                     <Button color="warning mi-3" onClick={() => onUpdate(tickets.ticketId)}
                        >Update</Button> 
                         




                    </Container>
                </CardBody>
            </Card></>

    )
}

export default Tickets;
