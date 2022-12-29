import { createSlice } from '@reduxjs/toolkit';
import { getDataFromLocalStorage, saveDataToLocalStorage } from '../../utils/localStorageUntils';
import { authService } from '../services/authService';

const authLocalStorage = getDataFromLocalStorage("auth");
const authDefault = {
    auth: null,
    token: null,
    isAuthenticated: false
}

const initialState = authLocalStorage ? authLocalStorage : authDefault;

const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        logout: () => {
            // Set lại dữ liệu vào trong localStorage
            saveDataToLocalStorage("auth", authDefault);

            return authDefault;
        },
    },
    extraReducers: (builder) => {
        builder.addMatcher(authService.endpoints.login.matchFulfilled, (state, action) => {
            const { user, token, isAuthenticated } = action.payload
            state.auth = user;
            state.isAuthenticated = isAuthenticated;
            state.token = token

            // Lưu dữ liệu vào trong localStorage
            saveDataToLocalStorage("auth", state);
        })
    }
});

export const { logout } = authSlice.actions

export default authSlice.reducer