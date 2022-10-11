import config from "../config.js";
import axios from "axios";

const request = axios.create({
    // baseURL: config.BACKEND
})

request.interceptors.response.use(res => {
    console.log(res);
    return res
})

export default request