import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

export const blogService = createApi({
    reducerPath: 'blogService',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/api/admin' }),
    endpoints: (builder) => ({
        getBlogs: builder.query({
            query: () => "/blogs"
        }),
        createBlog: builder.mutation({
            query: (data) => ({
                url: `/blogs`,
                method: "POST",
                body: JSON.stringify(data)
            })
        }),
        updateBlog: builder.mutation({
            query: ({ id, ...data }) => ({
                url: `/blogs/${id}`,
                method: "PUT",
                body: data
            })
        }),
        deleteBlog: builder.mutation({
            query: (id) => ({
                url: `/blogs/${id}`,
                method: "DELETE"
            }),
            transformResponse: (response, meta, arg) => {
                return arg
            }
        }),
    })
})

export const {
    useGetBlogsQuery,
    useCreateBlogMutation,
    useUpdateBlogMutation,
    useDeleteBlogMutation 
} = blogService