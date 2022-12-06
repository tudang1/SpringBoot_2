import { configureStore } from "@reduxjs/toolkit";
import { authService } from "../services/authService";
import authReducer from "../slices/authSlice";

const store = configureStore({
    reducer: {
        [authService.reducerPath]: authService.reducer,
        auth: authReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(authService.middleware)
})

export default store;