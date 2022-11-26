export const addTodo = (title) => {
    return {
        type: "todo/addTodo",
        payload: title
    }
}

export const deleteTodo = (id) => {
    return {
        type: "todo/deleteTodo",
       
    }
}