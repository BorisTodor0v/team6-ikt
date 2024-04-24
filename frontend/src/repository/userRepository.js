import axios from "../custom-axios/axios";

const UserService = {

    login: (username, password) => {
        return axios.post("/login", {
            "username": username,
            "password": password
        });
    }

}

export default UserService;