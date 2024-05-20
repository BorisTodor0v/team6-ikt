import axios from "../custom-axios/axios";

const UserService = {

    fetchAllUsers: () => {
        return axios.get("/users")
    },

    fetchByUsername: (username) => {
        return axios.get(`/users/${username}`)
    },

    fetchById: (id) => {
        return axios.get(`/users/id/${id}`)
    },

    editUserByUsername: (username, role, name, surname, email, address) => {
        return axios.put(`/users/${username}/edit`, {
            "role": role,
            "username": username,
            "name": name,
            "surname": surname,
            "email": email,
            "address": address
        })
    },

    editUserById: (id, username, role, name, surname, email, address) => {
        return axios.put(`/users/id/${id}/edit`, {
            "role": role,
            "username": username,
            "name": name,
            "surname": surname,
            "email": email,
            "address": address
        })
    },

    deleteUserByUsername: (username) => {
        return axios.delete(`/users/${username}/delete`)
    },

    deleteUserById: (id) => {
        return axios.delete(`/users/id/${id}/delete`)
    },

    findAllChildCare: () => {
        return axios.get(`/users/filter/child-care`)
    },

    findAllElderCare: () => {
        return axios.get(`/users/filter/elder-care`)
    },

    findAllPetCare: () => {
        return axios.get(`/users/filter/pet-care`)
    },

}

export default UserService;