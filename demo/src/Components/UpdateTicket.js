import React, { Component, useEffect, useState } from 'react'

import '../assets/css/bootstrap.css';
import '../assets/css/style.css';
import '../assets/css/media.css';
import Base from './Base';
import { Card, CardHeader, Container, FormGroup, Label } from 'reactstrap';
import { CardBody, Form, Input } from 'reactstrap';
import axios from 'axios';
import { BASE_URL } from "../Api/EndPoint/Index.js";

class UpdateTicket extends Component {
    
       

    state = {
        
        status: '',
        priority: '',
        assigned:'',

    }
    onSubmit = async () => {
        // alert("hi");
        // axios.post('http://localhost:9090/api/users/post', {
        //     firstname: this.state.firstname,
        //     lastname: this.state.lastname,
        //     email: this.state.email,
        //     mobno: this.state.mobno,
        //     dob: this.state.dob,
        //     gender: this.state.gender,
        //     password: this.state.password,
        //     password2: this.state.password2
        // })
        //     .then((response) => {
        //         // handle success
        //         console.log("registration success full", response);
        //     })
                        
                        if (this.state.status.trim() === "") {
                            alert("Status is Required !!");
                            return;
                        }if (this.state.priority.trim() === "") {
                            alert("Priority is Required !!");
                            return;
                        }if (this.state.assigned.trim() === "") {
                            alert("Priority is Required !!");
                            return;
                        }
                        
                        const Tid = localStorage.getItem("Tid")
                        let res = await fetch(BASE_URL+`/api/ticket/${Tid}`, {
                        method: "PUT",
                        headers: {
                            'Content-type': "application/json"
                        },
                        body: JSON.stringify({
                            
                            
                            status: this.state.status,
                            priority:this.state.priority,
                            assigned:this.state.assigned
                        })
                    })
                    if(res.ok){
                        alert("Ticket updated Successfully");
                        console.log("Res>>>", res);
                    }else{
                        alert("error");
                        console.log(Tid);
                    }
                   
        }



    render() {


        return (
            <body>

                <main className="cd-main">
                    <section className="cd-section index4 visible">
                        <div className="cd-content style4">

                            {/* <!-- login slide start --> */}

                            {/* <!-- login slide end -->
                    <!-- signup slide start --> */}
                            <div className="login-box">
                                <div className="signup-slide slide">
                                    <div className="row no-gutters height-100-percentage">
                                        <div className="col-md-12 col-sm-12 style4-left">
                                            <div className="d-flex height-100-percentage padding-40px">
                                                <div className="align-self-center width-100-percentage">
                                                    <h2>Update Ticket</h2>
                                                    
                                                        <div className="row">
                                                        
                                                        <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">status</label>
                                                                    <select type="text" class="form-control" name=" lname" placeholder="status to be updated" onChange={(e) => this.setState({ status: e.target.value })} required defaultValue={0}>
                                                                    <option disabled value={0}>
                                                                             --Select--
                                                                        </option>
                
                                                                        <option>
                                                                        Open
                                                                    </option>
                                                                    <option>
                                                                        Close
                                                                    </option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label" >priority</label>
                                                                    <select type="text"
                                                                        className="form-control"
                                                                        name=" fname"
                                                                        placeholder="priority"
                                                                        id="priority"
                                                                        // onChange={(e)=>handleChange(e)}
                                                                        onChange={(e) => this.setState({ priority: e.target.value })}
                                                                        required
                                                                        defaultValue={0}
                                                                    >
                                                                         <option disabled value={0}>
                                                                             --Select--
                                                                        </option>
                
                                                                        <option>
                                                                        Low
                                                                    </option>
                                                                    <option>
                                                                        Moderate
                                                                    </option>
                                                                    <option>
                                                                        High
                                                                    </option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label" >Assigned To</label>
                                                                    <select type="text"
                                                                        className="form-control"
                                                                        name=" fname"
                                                                        placeholder="Assigned To "
                                                                        id="Assigned"
                                                                        // onChange={(e)=>handleChange(e)}
                                                                        onChange={(e) => this.setState({ assigned: e.target.value })}
                                                                        required
                                                                        defaultValue={0}
                                                                    >
                                                                        
                                                                        <option disabled value={0}>
                                                                             --Select--
                                                                        </option>
                
                                                                        <option>
                                                                        Jay Shah
                                                                    </option>
                                                                    <option>
                                                                        Shreya
                                                                    </option>
                                                                    <option>
                                                                        Kunal
                                                                    </option>
                                                                    </select>

                                                                    
                                                                </div>
                                                            </div>
                                                            
                                                        </div>
                                                        <div className="form-group">
                                                            <input type="submit" class="submit" value="Update"
                                                                onClick={this.onSubmit}>
                                                                

                                                                </input>
                                                        </div>
                                                        {/* <div>
                                                                <input type="submit" class="submit" value="Back"
                                                                // onClick={this.onSubmit}>
                                                                     onClick={() => navigate('/')}>
                                                                

                                                                </input>
                                                        </div> */}
                                                        
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            {/* <!-- signup slide end -->*/}

                        </div>
                    </section>
                </main>

                <div id="cd-loading-bar" data-scale="1" class="index"></div>

            </body>

        )

        //    <Container>

        //  <card>
        //   <CardHeader>

        //  <h3 >fill information to registor  !</h3>
        //   </CardHeader>
        //   <CardBody>
        //     <Form>
        //        <FormGroup>
        
       


    }
}

export default UpdateTicket;
