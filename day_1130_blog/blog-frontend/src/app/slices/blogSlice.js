import { createSlice } from '@reduxjs/toolkit'
import { blogService } from '../services/blogService';

const initialState = {
    blogs : []
}

const blogSlice = createSlice({
  name: "blog",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addMatcher(blogService.endpoints.getBlogs.matchFulfilled, (state, action) => {
        state.blogs = action.payload;
    })
    builder.addMatcher(blogService.endpoints.createBlog.matchFulfilled,(state,action) => {
        state.blogs.push(action.payload);
    })
    builder.addMatcher(blogService.endpoints.updateBlog.matchFulfilled,(state,action) => {
        let index = state.blogs.findIndex(blog => blog.id === action.payload);
        state.blogs[index] = action.payload;
    })
    builder.addMatcher(blogService.endpoints.deleteBlog.matchFulfilled,(state,action)=>{
        let index = state.blogs.findIndex(blog => blog.id === action.payload);
            state.blogs.splice(index, 1);
    })
}
});

export const {} = blogSlice.actions

export default blogSlice.reducer