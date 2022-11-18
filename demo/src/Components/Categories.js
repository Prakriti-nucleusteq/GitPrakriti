import axios from "axios";
import React from "react"
import { toast } from "react-toastify";
import { Button, Card, CardBody, CardSubtitle, CardText, Container, Toast } from "reactstrap";
import props from "react";

import { render } from "@testing-library/react";
import { useState, createContext, useContext } from "react";
import { BASE_URL } from "../Api/EndPoint/index.js";



const Categories = ({categories, subCategories ,update})=>{

    
    
   

    const deleteCategory=(categoryId)=>{
        axios.delete(BASE_URL+`/api/categories/${categoryId}`).then(
            (response)=>{
                //toast.success("Category Deleted Successfully")
                //alert("Category Deleted Successfully")
                update(categoryId);
            },
            (error)=>{
                alert("Server Error, Could not delete")
                //toast.error("Server Error, Could not delete")
                console.log(categoryId)
            }
        )
    }

    


    
    


    return(

       
        <>
        
        <Card className="text-center">
        <div class="newspaper">
        <table className="table d">
            
            <tr className="tr">
                
                <td>{categories.id}</td>
                <td>{categories.categoryName}</td>
                <td> <Card className="text-center">
                <CardBody>



                    <Container className="text-center">
                        <Button color="danger" onClick={() => {
                            deleteCategory(categories.id);
                        } }>Delete</Button>
                       

                    </Container>
                </CardBody>
            </Card></td>
                
                
                



            </tr>
        </table>
        </div>
        </Card>
       </>
    )
}

export default Categories;
