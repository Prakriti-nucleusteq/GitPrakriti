import React, { useEffect, useState } from "react";
import Navbar from "./Navbar";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./AddCategory.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";


const AddCategory = () => {
  const navigate = useNavigate();
  let isValid = false;
  const firstValues = {
    category: "",
    subcategory: "",
  };
  const [formValues, setFormValues] = useState(firstValues);
  const [formErrors, setFormErrors] = useState({});
  const [subcategoriesItem, setSubCategoriesItem] = useState([]);
  const [subCategoriesList, setSubCategoriesList] = useState([
    { subcategoryName: "" },
  ]);
  const handleChange = (eve) => {
    const { name, value } = eve.target;
    setFormValues({ ...formValues, [name]: value });
    setFormErrors(validate(formValues));
  };
  const handleCancel = () => {
    setFormValues(firstValues);
  };
  const handleServiceChange = (e, index) => {
    const { name, value } = e.target;
    const list = [...subCategoriesList];
    list[index][name] = value;
    setSubCategoriesList(list);
  };
  const handleServiceRemove = (index) => {
    const list = [...subCategoriesList];
    list.splice(index, 1);
    setSubCategoriesList(list);
  };
  const handleServiceAdd = () => {
    setSubCategoriesList([...subCategoriesList, { subcategoryName: "" }]);
  };
  useEffect(() => {}, []);
  const handleSubmit = (e) => {
    console.log("array fata in handle submit", subCategoriesList,formValues.category,Object.keys(formErrors).length === 0);
    // if (Object.keys(formErrors).length === 0) {
    //   isValid = true;
    //   const payload = {
    //     categoryName: formValues.category,
    //     subcategories: subCategoriesList,
    //   };
    //   axios
    //     });
    // }
    const payload = {
      categoryName: formValues.category,
      subcategories: subCategoriesList,
    };
    axios
      .post("http://54.95.126.93:9090/api/categories/create", payload)
      .then((data) => {
        console.log("response data", data);
        toast.success(" Category/Subcategory added!", {
          position: toast.POSITION.TOP_RIGHT,
        });
        setFormValues(firstValues);
      })
      .catch((err) => {
        console.log("err", err);
        toast.error("Addition failed", {
          draggable: true,
          position: toast.POSITION.TOP_CENTER,
        });
      });
  };
  const pushfunction = () => {
    console.log("array values>>>>>", subcategoriesItem);
    // subcategoriesItem.push({
    //   ["subcategoryName"]: formValues.subcategory,
    // });
    setSubCategoriesItem((prevState) => [
      ...prevState,
      { subcategoryName: formValues.subcategory },
    ]);
  };
  const buttonHandler = () => {};
  const popfunction = (index, item) => {
    console.log("array values>>>>>", index, item);
    let data = subcategoriesItem.splice(index, 1);
    console.log("what data after pop>>>", data);
    
  };
  const validate = (values) => {
    const errors = {};
    //Category
    if (!values.category.trim()) {
      errors.category = "Category Required";
    }
    //Subcategory
    if (!values.subcategory.trim()) {
      errors.subcategory = "Subcategory Required";
    } else {
      isValid = true;
    }
    return errors;
  };
  return (
    <>
      <Navbar />
      <div className="main-div">
        <ToastContainer />
        <div className="category-form">
          <h1 className="heading-1">Add Category</h1>
          <hr className="hori-rule"></hr>
          <div className="grid-containers">
            <div className="form-inputs">
              <label for="category" className="form_label">
                Enter Category:{" "}
              </label>
              <input
                type="text"
                id="category"
                name="category"
                value={formValues.category}
                onChange={handleChange}
                className="form_input"
                placeholder="Enter category here"
                multiple
              />
              <span className="valid-registration-msg">
                {formErrors.category}
              </span>
            </div>
            {/* <div>
              <div className="form-inputs" id="subc-input">
                <label for="subcategory" className="form_label">
                  Sub-Category:{" "}
                  {subcategoriesItem.length > 0 && (
                    <button
                      className="add-fields"
                      id="plus-btn"
                      onClick={pushfunction}
                 
            </div> */}
            {subCategoriesList.map((singleService, index) => (
              <div key={index} className="services">
                <div className="first-division">
                  <input
                    name="subcategoryName"
                    type="text"
                    className="form_input"
                    defaultValue={singleService.subcategoryName}
                    onChange={(e) => handleServiceChange(e, index)}
                    required
                  />
                  {subCategoriesList.length - 1 === index &&
                    subCategoriesList.length < 4 && (
                      <button
                        type="button"
                        onClick={handleServiceAdd}
                        className="add-btn"
                      >
                        <span>Add a sub-category</span>
                      </button>
                    )}
                </div>
                <div className="second-division">
                  {subCategoriesList.length !== 1 && (
                    <button
                      type="button"
                      onClick={() => handleServiceRemove(index)}
                      className="remove-btn"
                    >
                      <span>Remove</span>
                    </button>
                  )}
                </div>
              </div>
            ))}
          </div>
          <button
            className="category-submit"
            // disabled={formValues.subcategory == ""}
            onClick={handleSubmit}
          >
            create Category
          </button>
          <button className="category-cancel" onClick={handleCancel}>
            Reset
          </button>
          <button
            className="category-back"
            onClick={() => navigate("/home")}
          >
            Back
          </button>
        </div>
        <div className="category-image">
          
           <img src="https://efacility.r.worldssl.net/wp-content/uploads/2020/05/Helpdesk.png" alt="login-image" className="loginimage" />
          
        </div>
      </div>
    </>
  );
};
export default AddCategory;
