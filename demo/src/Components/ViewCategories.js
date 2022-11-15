import { useState } from "react";
import React, { useEffect } from "react";
import AddEmployee from "./AddEmployee";
import { Button } from "reactstrap";
import axios from "axios";
import Employees from "./Employees";
import { toast } from "react-toastify";
import Categories from "./Categories";
import "./ViewTicket.css";
import {useNavigate} from "react-router-dom";
import Navbar from "./Navbar";

const ViewCategories = () => {

  const navigate = useNavigate();
  useEffect(() => {
    document.title = "View Categories";
  }, []);
  const [Category, setCategory] = useState([]);
  const [subCategory, setsubCategory] = useState([]);

  const updateCategory = (catId) => {
    //update the list of categories which is update by delete 
    setCategory(Category.filter((c) => c.Id != catId));
  };

  const getAllCategories = () => {
    axios.get("http://localhost:9090/api/categories/").then(
      (response) => {
        console.log(response.data);
        //toast.success("Categories have been loaded");
        setCategory(response.data);
      },
      (error) => {
        console.log(error);
        //toast.error("Something went wrong");
      }
    );
  };

  

  useEffect(() => {
    getAllCategories();
  }, []);

  return (
    <><Navbar /><div>
      <h3> list of Categories </h3>
      <table className="table d">
        <thead>
          <tr className="tr">

            <th> Id</th>
            <th>Category Title</th>
            <th>Action</th>

          </tr>
        </thead>
      </table>



      {Category.length > 0
        ? Category.map((item) => (
          <Categories
            key={item.categoryId}
            categories={item} />
        ))
        : "No employee"}
      <button
        className="form-cancel-btn"
        onClick={() => navigate('/home')}
      >
        Back
      </button>
      {/* {subCategory.length > 0
      ? subCategory.map((item) => (
          <subCategories
            key={item.categoryId}
            subCategories={item}
            update={updateCategory}
          />
        ))
      : "No employee"} */}
    </div></>
  );
};
export default ViewCategories;