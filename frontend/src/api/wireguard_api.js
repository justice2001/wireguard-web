import config from "../config.js";
import axios from "axios";

const request = axios.create({
    baseURL: config.BACKEND
})

request.interceptors.response.use(res => {
    console.log(res);
    return res
})

const getInterfaceInfo = ifn => {
    return request.get("/info/" + ifn)
}

const getInterfaceList = () => {
    return request.get("/info/all")
}

export default {
    getInterfaceInfo,
    getInterfaceList
}