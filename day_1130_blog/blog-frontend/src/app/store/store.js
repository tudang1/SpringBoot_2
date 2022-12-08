import { configureStore } from "@reduxjs/toolkit";
import { authService } from "../services/authService";
import { blogService } from "../services/blogService";
import { categoryService } from "../services/categoryService";
import authReducer from "../slices/authSlice";
import blogReducer from "../slices/blogSlice";
import categoryReducer from "../slices/categorySlice";

const store = configureStore({
    reducer: {
        [authService.reducerPath]: authService.reducer,
        [blogService.reducerPath]: blogService.reducer,
        [categoryService.reducerPath] : categoryService.reducer,
        auth: authReducer,
        blogs: blogReducer,
        categories : categoryReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(authService.middleware, blogService.middleware,categoryService.middleware)
})

export default store;