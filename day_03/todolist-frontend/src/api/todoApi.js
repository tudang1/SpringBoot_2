import axiosClient from "./axiosClient";

const todoApi = {
    getTodos() {
        const url = "/todos";
        return axiosClient.get(url);
    },
    createTodo(newTodo) {
        const url = "/todos";
        return axiosClient.post(url, newTodo);
    },
    updateTodo(id, updatedTodo) {
        const url = `todos/${id}`;
        return axiosClient.put(url, updatedTodo);
    },
    deleteTodo(id) {
        const url = `todos/${id}`;
        return axiosClient.delete(url);
    }
}

export default todoApi;