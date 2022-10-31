import axiosClient from "./axiosClient";

const Api ={
    getUsers() {
        const url = "/users";
        return axiosClient.get(url);
    },
    deleteUser(id){
        const url = `users/${id}`;
        return axiosClient.delete(url);
    },
    createUser(newUser) {
        const url = "/users";
        return axiosClient.post(url, newUser);
    },
    getUserById(id){
        const url = `users/${id}`;
        return axiosClient.get(url);
    }
}
export default Api;