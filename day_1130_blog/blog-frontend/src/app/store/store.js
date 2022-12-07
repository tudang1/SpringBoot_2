import { configureStore } from "@reduxjs/toolkit";
import { authService } from "../services/authService";
import { blogService } from "../services/blogService";
import authReducer from "../slices/authSlice";
import blogReducer from "../slices/blogSlice";

const store = configureStore({
    reducer: {
        [authService.reducerPath]: authService.reducer,
        [blogService.reducerPath]: blogService.reducer,
        auth: authReducer,
        blogs: blogReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(authService.middleware, blogService.middleware)
})

export default store;