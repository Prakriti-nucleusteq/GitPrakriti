import { useState } from "react";
import { useEffect } from "react";
import EmployeeNavbar from "./EmployeeNavbar";
import {
  Card,
  CardBody,
  Form,
  Input,
  Label,
  Button,
  Container,
} from "reactstrap";
import { loadAllCategories } from "../services/category-service";
import {
  loadAllSubCategories,
  loadAllSubCategoriesByCategory,
} from "../services/subCategory-service";
import { createTicket as doCreateTicket } from "../services/ticket-service";
import "../assets/css/style.css";
import { loadCategoryId } from "../services/subCategory-service";
import {useNavigate} from "react-router-dom";



const AddTicket = () => {

  const navigate = useNavigate();
  const [categories, setCategories] = useState([]);

  const [subCategories, setSubCategories] = useState([]);

  const [ticket, setTicket] = useState({
    eid: "",
    categoryName: "",
    subcategoryName: "",
    description: "",
    id: "",
    name: "",
    email:"",
    lastName:""
  });
  useEffect(() => {
    loadAllCategories()
      .then((data) => {
        console.log(data);
        setCategories(data);
     
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    loadAllSubCategories()
      .then((data) => {
        console.log(data);
        setSubCategories(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const fieldChanged = (event) => {
    setTicket({ ...ticket, [event.target.name]: event.target.value });
  };

  const handleCategory = (event) => {
    const catId = event.target.value;
    const categoryName = categories.find(
      (category) => category.id.toString() === catId.toString()
    ).categoryName;
    console.log(categoryName);
    setTicket({ ...ticket, categoryName });

    loadAllSubCategoriesByCategory(catId)
      .then((data) => {
        console.log(data);
        setSubCategories(data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const eidvalue =localStorage.getItem('eid');
  const fullname = localStorage.getItem('first')+" "+localStorage.getItem('last');
  const createTicket = (event) => {
    event.preventDefault();

    // if (ticket.eid.trim() === "") {
    //  //alert("Employee Id is Required !!");
    //  eidvalue =localStorage.getItem('eid');
    //  console.log(eidvalue);
    //   return;
    // }
    if (ticket.categoryName.trim() === "") {
      alert("Category is Required !!");
      return;
    }
    // if (ticket.description.trim() === "") {
    //   alert("description is Required !!");
    //   return;
    // }

    doCreateTicket({
       eid: eidvalue,

      category: ticket.categoryName,
      subCategory: ticket.subcategoryName,
      description: ticket.description,
      name: fullname,
    })
      .then((data) => {
        alert("Ticket Created ");
        console.log(ticket);
      })
      .catch((error) => {
        alert("error");
        console.log(error);
      });
  };

  return (
    <><EmployeeNavbar />
    <div className="wrapper bgimage">
      <Card className="shadow-sm mt-2 mx-auto" style={{ maxWidth: "600px" }}>
        <CardBody>
          <Form onSubmit={createTicket}>
            <div className="my-3 input-container">
              <Label for="eid">Employee Id</Label>
              <input
                type="text"
                id="eid"
                placeholder="Enter here"
                className="rounded-0"
                name="eid"
                value={JSON.parse(localStorage.getItem('users')).employeeId}
                onChange={fieldChanged} />
            </div>

            <div className="my-3 input-container">
              <label for="name" className="label">Name</label>
              <input id="name"
                type="text"
                className="input"
                name="name"
                value={JSON.parse(localStorage.getItem('users')).firstName + " " + JSON.parse(localStorage.getItem('users')).lastName}
                onChange={fieldChanged}
                disabled={"true"}></input>
            </div>

            <div className="my-3 input-container">
              <Label for="email">Email</Label>
              <input
                type="text"
                id="email"
                placeholder=" "
                className="rounded-0"
                name="email"
                value={JSON.parse(localStorage.getItem('users')).email}
                onChange={fieldChanged} />
            </div>


            <div className="my-3">
              <Label for="Category">Category</Label>
              <Input
                type="select"
                id="categoryName"
                placeholder="Enter here"
                name="categoryName"
                className="rounded-0"
                required
                onChange={handleCategory}
                defaultValue={0}
              >
                <option disabled value={0}>
                  --Select Category--
                </option>
                {categories.map((category) => (
                  <option
                    value={category.id}
                    key={category.categoryName}
                  >
                    {category.categoryName}
                  </option>
                ))}
              </Input>
            </div>
            <div className="my-3">
              <Label for="SubCategory">Sub Category</Label>
              <Input
                type="select"
                id="subcategoryName"
                name="subcategoryName"
                placeholder="Enter here"
                className="rounded-0"
                required
                onChange={fieldChanged}
                defaultValue={0}
              >
                <option disabled value={0}>
                  --Select SubCategory--
                </option>
                {subCategories.map((subCategory) => (
                  <option
                    value={subCategory.subcategoryName}
                    key={subCategory.subcategoryName}
                  >
                    {subCategory.subcategoryName}
                  </option>
                ))}
              </Input>
            </div>
            <div className="my-3 input-container">
              <Label for="description">Description</Label>
              <input
                type="textarea"
                id="description"
                name="description"
                placeholder="Enter here"
                className="rounded-0"
                required
                onChange={fieldChanged}
                style={{ height: "100px" }} />
            </div>

            <Container className="text-center">
              <Button className="rounded-0" color="primary">
                Create
              </Button>

              <button
                className="form-cancel-btn"
                onClick={() => navigate('/home-employee')}
              >
                Back
              </button>
            </Container>
          </Form>
        </CardBody>
      </Card>
    </div></>
  );
};

export default AddTicket;
