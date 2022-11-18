import axios from "axios";
// import Axios from "axios";

export const loadAllSubCategories=()=>{
    return axios.get('http://54.95.126.93:9090/api/categories/subcategories').then(response=>{return response.data})
}

export const loadAllSubCategoriesByCategory=(categoryId)=>{
    return axios.get(`http://54.95.126.93:9090/api/categories/subcategories/${categoryId}`).then(response=>{return response.data})
}


export const loadCategoryId=(categoryTitle)=>{
    return axios.get(`http://54.95.126.93:9090/api/categories/${categoryTitle}`).then(response=>{return response.data})
}
