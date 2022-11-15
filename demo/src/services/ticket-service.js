import axios from "axios"
export const createTicket=(ticketData)=>{
    return axios.post('http://localhost:9090/api/ticket',ticketData).then(response=>response.data)
}

