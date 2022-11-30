import { configureStore } from "@reduxjs/toolkit";
import { todoListApi } from "../service/todoListApiService";
import counterReducer from "../slices/counterSlice";
import todoListReducer from "../slices/todoListSlice";
import todoListApiReducer from "../slices/todoListApiSlice";

const store = configureStore({
    reducer: {
        [todoListApi.reducerPath]: todoListApi.reducer,
        counter: counterReducer,
        todos : todoListReducer,
        todoList: todoListApiReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(todoListApi.middleware)
})

export default store;