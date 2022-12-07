import { createSlice } from '@reduxjs/toolkit';
import { getDataFromLocalStorage, saveDataToLocalStorage } from '../../utils/localStorageUntils';
import { authService } from '../services/authService';

const authLocalStorage = getDataFromLocalStorage("auth");
const authDefault = {
    auth: null,
    isAuthenticated: false
}

const initialState = authLocalStorage ? authLocalStorage : authDefault;

const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addMatcher(authService.endpoints.login.matchFulfilled, (state, action) => {
            state.auth = action.payload;
            state.isAuthenticated = true;

            // Lưu dữ liệu vào trong localStorage
            saveDataToLocalStorage("auth", state);
        })
        builder.addMatcher(authService.endpoints.logout.matchFulfilled, (state, action) => {
            // state.auth = authDefault.auth;
            // state.isAuthenticated = authDefault.isAuthenticated;

            // Xóa dữ liệu vào trong localStorage
            saveDataToLocalStorage("auth", authDefault);

            return authDefault;
        })
    }
});

export const { } = authSlice.actions

export default authSlice.reducer