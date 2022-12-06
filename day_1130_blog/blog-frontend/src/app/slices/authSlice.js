import { createSlice } from '@reduxjs/toolkit';
import { authService } from '../services/authService';

const initialState = {
    auth: null,
    isAuthenticated: false
}

const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addMatcher(authService.endpoints.login.matchFulfilled, (state, action) => {
            state.auth = action.payload;
            state.isAuthenticated = true;
        })
        builder.addMatcher(authService.endpoints.logout.matchFulfilled, (state, action) => {
            state = initialState
        })
    }
});

export const { } = authSlice.actions

export default authSlice.reducer