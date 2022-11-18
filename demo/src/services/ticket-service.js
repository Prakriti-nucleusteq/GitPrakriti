import axios from "axios"
export const createTicket=(ticketData)=>{
    return axios.post('http://54.95.126.93:9090/api/ticket',ticketData).then(response=>response.data)
}

