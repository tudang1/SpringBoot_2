import { createSlice } from '@reduxjs/toolkit'

const initialState = [
    {id:1,title:"Lam bai tap"},
    {id:2,title:"report"},
    {id:3,title:"Lam teijun"}
]

const todoListSlice = createSlice({
  name: "todoList",
  initialState,
  reducers: {
    addTodo(state,action){
        state.push(action.payload);
    },
    deleteTodo(state,action){
        let index = state.findIndex(todo => todo.id = action.payload);
        state.splice(index,1);
    },
    updateTodo(state, action) {
        const { id, title } = action.payload
        // Tìm kiếm công việc cần cập nhật
        let index = state.findIndex(todo => todo.id === id);

        // Cập nhật tiêu đề
        state[index].title = title
    }
  }
});

export const {addTodo, deleteTodo,updateTodo} = todoListSlice.actions

export default todoListSlice.reducer