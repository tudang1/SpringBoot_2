import { createSlice } from '@reduxjs/toolkit'
import { categoryService } from '../services/categoryService';

const initialState = {
    categories : []
}

const categorySlice = createSlice({
  name: "categories",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addMatcher(categoryService.endpoints.getCategories.matchFulfilled, (state, action) => {
        state.categories = action.payload;
    })
    builder.addMatcher(categoryService.endpoints.createCategory.matchFulfilled,(state,action)=>{
        state.categories.push(action.payload);
    })
    builder.addMatcher(categoryService.endpoints.deleteCategory.matchFulfilled,(state,action)=>{
        let index = state.categories.findIndex(category => category.id === action.payload);
            state.categories.splice(index, 1);
    })
}
});

export const {} = categorySlice.actions

export default categorySlice.reducer