const axios = required ('axios')

const updateTicket = (body) => {
    return axios.put('http://localhost:8080/ticket/update', body)
}
export default updateTicket;