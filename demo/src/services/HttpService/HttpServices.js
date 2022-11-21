import { BASE_URL } from "../Api/EndPoint/Index.js";
const axios = required ('axios')


const updateTicket = (body) => {
    return axios.put(BASE_URL+'/ticket/update', body)
}
export default updateTicket;
