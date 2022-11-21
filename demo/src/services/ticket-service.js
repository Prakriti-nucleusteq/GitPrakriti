import axios from "axios"
import { BASE_URL } from "../Api/EndPoint/Index.js";
export const createTicket=(ticketData)=>{
    return axios.post(BASE_URL+'/api/ticket',ticketData).then(response=>response.data)
}

