import { createSlice } from '@reduxjs/toolkit'

const initialState = 0;


// name + function name trong reducers => action type
//counter + increment => "counter/increment"
//increment : action creator
const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    increment(state) {
      return state + 1;
    },
    decrement(state) {
      return state -1;
    }
  },
})

export const { increment, decrement } = counterSlice.actions
export default counterSlice.reducer