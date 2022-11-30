import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "../slices/counterSlice";
import todoListReducer from "../slices/todoListSlice"

const store = configureStore({
    reducer : {
        counter : counterReducer,
        todos : todoListReducer
    }
})

export default store;