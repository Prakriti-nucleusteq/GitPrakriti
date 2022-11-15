import axios from "axios";
//import Axios from "axios";

export const loadAllCategories=()=>{
    return axios.get('http://localhost:9090/api/categories/').then(response=>{return response.data})
}