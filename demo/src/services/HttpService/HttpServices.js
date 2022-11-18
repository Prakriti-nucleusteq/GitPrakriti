const axios = required ('axios')

const updateTicket = (body) => {
    return axios.put('http://54.95.126.93:8080/ticket/update', body)
}
export default updateTicket;
