import axios from "axios";
//import Axios from "axios";
import { BASE_URL } from "../Api/EndPoint/Index.js";

export const loadAllCategories=()=>{
    return axios.get(BASE_URL+'/api/categories/').then(response=>{return response.data})
}
