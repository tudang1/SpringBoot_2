import { createSlice } from '@reduxjs/toolkit';

const initialState = 0

/*
// name + function name trong reducers => action type
// counter + increment => "counter/increment"
// increment : action creator trả action

const increment = () => {
    return {
        type : counter/increment
    }
}

Thư viện cập nhật state sử dụng : ImmerJS
*/

const counterSlice = createSlice({
    name: 'counter',
    initialState,
    reducers: {
        increment(state, action) {
            console.log(state, action);
            return state + 1;
        },
        decrement(state, action) {
            console.log(state, action);
            return state - 1;
        }
    },
})

export const { increment, decrement } = counterSlice.actions
export default counterSlice.reducer