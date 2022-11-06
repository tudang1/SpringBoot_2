import axiosClient from "./axiosClient";

const Api ={
    getCourses() {
        const url = "/courses";
        return axiosClient.get(url);
    },
    getCourseById(id){
        const url = `courses/${id}`;
        return axiosClient.get(url);
    },
    getUsers() {
        const url = "/users";
        return axiosClient.get(url);
    },
    getUserById(id){
        const url = `users/${id}`;
        return axiosClient.get(url);
    },

    // deleteUser(id){
    //     const url = `users/${id}`;
    //     return axiosClient.delete(url);
    // },
    // createUser(newUser) {
    //     const url = "/users";
    //     return axiosClient.post(url, newUser);
    // },
    
    // updateUser(id, updatedUser) {
    //     const url = `users/${id}`;
    //     return axiosClient.put(url, updatedUser);
    // },
    // updatePassword(id,password){
    //     const url = `users/${id}/update-password`;
    //     return axiosClient.put(url,password);
    // }
}
export default Api;