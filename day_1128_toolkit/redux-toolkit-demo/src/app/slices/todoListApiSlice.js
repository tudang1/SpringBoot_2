import { createSlice } from '@reduxjs/toolkit';
import { todoListApi } from '../service/todoListApiService';

const initialState = {
    todos: []
}

const todoListApiSlice = createSlice({
    name: "todoListApi",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addMatcher(todoListApi.endpoints.getTodos.matchFulfilled, (state, action) => {
            state.todos = action.payload
        })
        builder.addMatcher(todoListApi.endpoints.createTodo.matchFulfilled, (state, action) => {
            state.todos.push(action.payload)
        })
        builder.addMatcher(todoListApi.endpoints.updateTodo.matchFulfilled, (state, action) => {
            let index = state.todos.findIndex(todo => todo.id === action.payload.id);
            state.todos[index] = action.payload
        })
        builder.addMatcher(todoListApi.endpoints.deleteTodo.matchFulfilled, (state, action) => {
            let index = state.todos.findIndex(todo => todo.id === action.payload);
            state.todos.splice(index, 1);
        })
    }
});

export const { } = todoListApiSlice.actions

export default todoListApiSlice.reducer