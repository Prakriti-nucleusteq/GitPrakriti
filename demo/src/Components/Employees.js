import axios from "axios";
import React from "react"
import { toast } from "react-toastify";

import { Button, Card, CardBody, CardSubtitle, CardText, Container, Toast } from "reactstrap";
const Employees = ({employees, update})=>{

    const deleteEmployee=(id)=>{
        axios.delete(`http://localhost:9090/api/users/${id}`).then(
            (response)=>{
              //  toast.success("Employee Deleted Successfully")
                //alert("Employee Deleted Successfully")
                update(id);
            },
            (error)=>{
                alert("Server Error, Could not delete")
               // toast.error("Server Error, Could not delete")
            }
        )
    }

    localStorage.setItem("Eid",employees.id)


    return(
        <>
    
        <Card className="text-center">
        <div class="newspaper">
        <table className="table d">
            
            <tr className="tr">
                
                <td>{employees.id}</td>
                <td>{employees.employeeId}</td>
                <td>{employees.firstName}</td>
                <td>{employees.lastName}</td>
                <td>{employees.email}</td>
                <td>{employees.contact}</td>
         

            </tr>
        </table>
        </div>
        </Card>
        <Card className="text-center">
                <CardBody>



                    <Container className="text-center">
                        <Button color="danger" onClick={() => {
                            deleteEmployee(employees.id);
                        } }>Delete</Button>
                        
                        
                    </Container>
                </CardBody>
            </Card></>
    )
}

export default Employees;