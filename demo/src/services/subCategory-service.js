import axios from "axios";
// import Axios from "axios";
import { BASE_URL } from "../Api/EndPoint/Index.js";

export const loadAllSubCategories=()=>{
    return axios.get(BASE_URL+'/api/categories/subcategories').then(response=>{return response.data})
}

export const loadAllSubCategoriesByCategory=(categoryId)=>{
    return axios.get(BASE_URL+`/api/categories/subcategories/${categoryId}`).then(response=>{return response.data})
}


export const loadCategoryId=(categoryTitle)=>{
    return axios.get(BASE_URL+`/api/categories/${categoryTitle}`).then(response=>{return response.data})
}
