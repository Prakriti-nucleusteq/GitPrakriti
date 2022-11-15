import React, { Component, useEffect, useState } from 'react'

import '../assets/css/bootstrap.css';
import '../assets/css/style.css';
import '../assets/css/media.css';
import Base from './Base';
import { Card, CardHeader, Container, FormGroup, Label } from 'reactstrap';
import { CardBody, Form, Input } from 'reactstrap';
import axios from 'axios';
class Registration extends Component {

    state = {
        firstname: '',
        lastname: '',
        employeeId:'',
        email: '',
        mobno: '',
        dob: '',
        gender: '',
        password: '',
        password2: '',
        contact: '',
        email: '',

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
        var mailformat = /^\w+([\.-]?\w+)@nucleusteq.com/;
            if(this.state.email.match(mailformat))
            {
                if(this.state.password==this.state.password2)
                {
                    let res = await fetch("http://localhost:9090/api/users/post", {
                        method: "POST",
                        headers: {
                            'Content-type': "application/json"
                        },
                        body: JSON.stringify({
                            firstName: this.state.firstName,
                            lastName: this.state.lastName,
                            employeeId:this.state.employeeId,
                            email: this.state.email,
                            contact: this.state.contact,
                            dob: this.state.dob,
                            gender: this.state.gender,
                            password: this.state.password
                        })
                    })
                    console.log("Res>>>", res);
                }
                else{
                    alert("passwords does not match");
                    return false;
                }
                

        
            }
            else
            {
                alert("You have entered an invalid email address!");
                
                return false;
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
                                                    <h2>Create An Account</h2>
                                                    
                                                        <div className="row">
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">First Name</label>
                                                                    <input type="text"
                                                                        className="form-control"
                                                                        name=" fname"
                                                                        placeholder="Enter first name "
                                                                        id="firstname"
                                                                        // onChange={(e)=>handleChange(e)}
                                                                        onChange={(e) => this.setState({ firstName: e.target.value })}
                                                                    ></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Last  Name</label>
                                                                    <input type="text" class="form-control" name=" lname" placeholder="Enter last name " onChange={(e) => this.setState({ lastName: e.target.value })}></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Employee Id</label>
                                                                    <input type="text"
                                                                        className="form-control"
                                                                        name=" eid"
                                                                        placeholder="Enter Employee id"
                                                                        id="firstname"
                                                                        // onChange={(e)=>handleChange(e)}
                                                                        onChange={(e) => this.setState({ employeeId: e.target.value })}
                                                                    ></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Email </label>
                                                                    <input type="text" class="form-control" name=" email" placeholder="Enter email "
                                                                        onChange={(e) => this.setState({ email: e.target.value })} ></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Mobile Number</label>
                                                                    <input type="number" class="form-control" name=" email" placeholder="Enter mobile no."
                                                                        onChange={(e) => this.setState({ contact: e.target.value })} ></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">DOB</label>
                                                                    <input type="number" class="form-control" name=" dob" placeholder="DD/MM/YYYY"
                                                                        onChange={(e) => this.setState({ dob: e.target.value })}></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Gender</label>
                                                                    <input type="number" class="form-control" name=" gender" placeholder="Enter gender"
                                                                        onChange={(e) => {
                                                                            console.log("value");
                                                                            this.setState({ gender: e.target.value })
                                                                        }}></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Password</label>
                                                                    <input type="password" class="form-control" name=" password" placeholder="Enter password"
                                                                        onChange={(e) => this.setState({ password: e.target.value })}></input>
                                                                </div>
                                                            </div>
                                                            <div className="col-xd-6 col-md-6 col-sm-6">
                                                                <div className="form-group">
                                                                    <label className="label">Confirm Password</label>
                                                                    <input type="password" class="form-control" name=" password2" placeholder=" Re-enter password"
                                                                        onChange={(e) => this.setState({ password2: e.target.value })}></input>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div className="form-group">
                                                            <input type="submit" class="submit" value="Register"
                                                                onClick={this.onSubmit}>
                                                                

                                                                </input>
                                                        </div>
                                                        <div className="sign-up-txt">
                                                            if you have an account? <a class="login-click">login</a>
                                                        </div>
                                                    
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
        //         <Label for ="name">
        //           enter name
        //         </Label>
        //         <Input 
        //         type ="text"
        //         placeholder="enter here"
        //         id ="name"
        //         />
        //        </FormGroup>

        //        <FormGroup>
        //         <Label for ="email">
        //           enter Email
        //         </Label>
        //         <Input 
        //         type ="email"
        //         placeholder="enter mail here"
        //         id="email"
        //         />
        //        </FormGroup>

        //        <FormGroup>
        //         <Label for ="password">
        //           enter Password
        //         </Label>
        //         <Input 
        //         type ="password"
        //         placeholder="enter password here"
        //         id="password"
        //         />
        //        </FormGroup>

        //     </Form>

        //   </CardBody>
        //  </card>


        //    </Container>


    }
}

export default Registration;