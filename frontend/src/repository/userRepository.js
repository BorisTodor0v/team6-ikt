import axios from "../custom-axios/axios";

const UserService = {

    fetchAllUsers: () => {
        return axios.get("/users")
    },

    fetchByUsername: (username) => {
        return axios.get(`/users/${username}`)
    },

    editUser: (username, role, name, surname, email, address) => {
        return axios.put(`/users/${username}/edit`, {
            "role": role,
            "name": name,
            "surname": surname,
            "email": email,
            "address": address
        })
    },

    deleteUser: (username) => {
        return axios.delete(`/users/${username}/delete`)
    }

}

export default UserService;