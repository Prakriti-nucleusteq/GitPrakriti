import axios from "axios";
//import Axios from "axios";

export const loadAllCategories=()=>{
    return axios.get('http://54.95.126.93:9090/api/categories/').then(response=>{return response.data})
}
