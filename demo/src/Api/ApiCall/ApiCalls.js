import axios from "axios";
import { BASE_URL } from "../EndPoint";
// export const postRequest = (api, payload, callback) => {
//   axios
//     .post(BASE_URL + api, payload)
//     .then((res) => {
//       if (res?.status === 200) {
//         callback(res);
//       }
//     })
//     .catch((error) => {
//       callback(error.response);
//       console.log(error.response);
//     });
// };
export const getRequest = (api, callback) => {
  axios
    .get(BASE_URL + api)
    .then((res) => {
      if (res?.status === 200) {
        callback(res);
      }
    })
    .catch((error) => {
      callback(error.response);
      console.log(error.response);
    });
};