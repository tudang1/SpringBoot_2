import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

// Define a service using a base URL and expected endpoints
export const todoListApi = createApi({
    reducerPath: 'todoListApi',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/api/v1' }),
    endpoints: (builder) => ({
        // chỉ cần lấy dữ liệu từ phía backend : builder.query
        // tương tác (sửa đổi, xóa,...) : builder.mutation  
        getTodos: builder.query({
            query: () => "/todos"
        }),
        createTodo: builder.mutation({
            query: (data) => ({
                url: "/todos",
                method: "POST",
                body: data
            })
        }),
        updateTodo: builder.mutation({
            query: ({ id, ...data }) => ({
                url: `/todos/${id}`,
                method: "PUT",
                body: data
            })
        }),
        deleteTodo: builder.mutation({
            query: (id) => ({
                url: `/todos/${id}`,
                method: "DELETE"
            }),
            transformResponse: (response, meta, arg) => {
                return arg
            }
        }),
    })
})

export const {
    useGetTodosQuery,
    useCreateTodoMutation,
    useUpdateTodoMutation,
    useDeleteTodoMutation
} = todoListApi

/*
{
    id : 1, 
    title : "abc", 
    status : false
}
id : 1
data : {
    title : "abc", 
    status : false
}
*/