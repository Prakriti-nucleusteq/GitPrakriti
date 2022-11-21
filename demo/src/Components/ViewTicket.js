import { useState } from "react";
import React, { useEffect } from "react";
import AddEmployee from "./AddEmployee";
import axios from "axios";
import Employees from "./Employees";
import { toast } from "react-toastify";
import Categories from "./Categories";
import Tickets from "./Tickets";
import "./ViewTicket.css";
import { BASE_URL } from "../Api/EndPoint/Index.js";

import { Card, CardBody, CardSubtitle, CardText, Col, Container, Row, Toast, Input, Label } from "reactstrap";
import { type } from "@testing-library/user-event/dist/type";

import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { MenuItem, Select } from '@mui/material';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

const ViewTicket = () => {
    useEffect(() => {
        document.title = "View Tickets";
    }, []);
    const [Ticket, setTicket] = useState([]);
    const [filterBy, setFilterBy] = useState('');

    const updateTicket = (Id) => {
        setTicket(Ticket.filter((c) => c.ticketId != Id));
    }

    const getAllTickets = () => {
        axios.get(BASE_URL+'/api/tickets/').then(
            (response) => {
                console.log(response.data);
                // toast.success("Tickets have been loaded");
                setTicket(response.data);
            },
            (error) => {
                console.log(error);
                // toast.error("Something went wrong")
            }
        );
    };

    useEffect(() => {
        getAllTickets();

    }, []);

    

    const handleChange = event => {
        console.log(event.target.value);
        const v = event.target.value
        console.log(v);
        if (v === '"Status - Open"') {


            axios.get(`http://54.95.126.93:9090/api/tickets/status/open`).then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        } else if (v == '"Status - Close"') {

            axios.get(`http://54.95.126.93:9090/api/tickets/status/close`).then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        }
        else if (v == '"Status - inProgress"') {

            axios.get(`http://54.95.126.93:9090/api/tickets/status/inprogress`).then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        }
        else if (v === '"Priority - Low"') {

            axios.get(BASE_URL+`/api/tickets/priority/low`).then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        }
        else if (v === '"Priority - Moderate"') {

            axios.get(BASE_URL+`/api/tickets/priority/moderate`).then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        }
        else if (v === '"Priority - High"') {

            axios.get(BASE_URL+`/api/tickets/priority/high`).then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        }
        
       
       
        else if (v === "All") {


            axios.get(BASE_URL+'/api/tickets/').then(
                (response) => {
                    console.log(response.data);
                    // toast.success("Tickets have been loaded");
                    setTicket(response.data);
                },
                (error) => {
                    console.log(error);
                    // toast.error("Something went wrong")
                }
            );
        };


    }

    const [showUpdateTicketModal, setUpdateTicketModal] = useState(false)


    const [priority, setPriority] = useState('')
    const [status, setStatus] = useState('')
    const [assignTo, setAssignTo] = useState('')
    const [ticketId, setTicketId] = useState('')

    const onUpdate = (id) => {
        const ticket = Ticket.find(t=>t.ticketId)
        setPriority(ticket.priority)
        setStatus(ticket.status)
        setAssignTo(ticket.assign)
        setTicketId(id)

        setUpdateTicketModal(true)
    }

    const handleUpdateTicket = () => {
        axios.put(BASE_URL+'/api/ticket/update', {
            ticketId,
            assigned: assignTo,
            status,
            priority
        }).then(
            (response) => {
                // console.log(response.data);
                // toast.success("Tickets have been loaded");
                // setTicket(response.data);
                getAllTickets()
                setUpdateTicketModal(false)
            },
            (error) => {
                console.log(error);
                // toast.error("Something went wrong")
            }
        );
    };

    return (

        <>
        <div className="my-3">
            <Label for="Category">Category</Label>
            <Input
                type="select"
                id="filterBy"
                placeholder="Enter here"
                //value={filterBy}
                name="filterBy"
                className="rounded-0"
                required
                onChange={handleChange}

                defaultValue={0}
            >
                <option disabled value={0}>
                    --Filter By--
                </option>

                <option>
                    All
                </option>
                <option>
                    "Status - Open"
                </option>
                <option>
                    "Status - Close"
                </option>
                <option>
                    "Status - inProgress"
                </option>
                <option>
                    "Priority - Low"
                </option>
                <option>
                    "Priority - Moderate"
                </option>
                <option>
                    "Priority - High"
                </option>
                
            </Input>
        </div><div>

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


                {Ticket.length > 0
                     ? Ticket
                     //filter(filterBy ? filterMap[filterBy] : () => true)
                        .map((item) => <Tickets key={item.ticketId} tickets={item} update={updateTicket} onUpdate={onUpdate} />)
                    : "No employee"}
            </div>

            <Modal
                open={showUpdateTicketModal}
                onClose={() => setUpdateTicketModal(false)}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                        Edit Ticket
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        <span>Priority</span>
                        <Select
                            labelId="demo-simple-select-standard-label"
                            id="demo-simple-select-standard"
                            value={priority}
                            onChange={e => setPriority(e.target.value)}
                            label="Status"
                        >
                            <MenuItem value={'LOW'}>Low</MenuItem>
                            <MenuItem value={'MODERATE'}>Moderate</MenuItem>
                            <MenuItem value={'HIGH'}>High</MenuItem>
                            <MenuItem value={'VERY_HIGH'}>Very High</MenuItem>
                        </Select>
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        <span>Status</span>
                        <Select
                            labelId="demo-simple-select-standard-label"
                            id="demo-simple-select-standard"
                            value={status}
                            onChange={e => setStatus(e.target.value)}
                            label="Status"
                        >
                            <MenuItem value={'OPEN'}>Open</MenuItem>
                            <MenuItem value={'INPROGRESS'}>In-Progress</MenuItem>
                            <MenuItem value={'CLOSED'}>Closed</MenuItem>
                        </Select>
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        <span>Assign To</span>
                        <Select
                            labelId="demo-simple-select-standard-label"
                            id="demo-simple-select-standard"
                            value={assignTo}
                            onChange={e => setAssignTo(e.target.value)}
                            label="Assign To"
                        >
                            <MenuItem value={'Shreya'}>Shreya</MenuItem>
                            <MenuItem value={'Jay'}>Jay</MenuItem>
                            <MenuItem value={'Sakshi'}>Sakshi</MenuItem>
                        </Select>
                    </Typography>
                    <Typography id="modal-modal-description" sx={{ mt: 2 }}>
                        <Button onClick={handleUpdateTicket}>Update</Button>
                    </Typography>
                </Box>
            </Modal>

        </>
    )
}
export default ViewTicket;
