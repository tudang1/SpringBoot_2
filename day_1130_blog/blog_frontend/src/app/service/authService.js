import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

// Define a service using a base URL and expected endpoints
export const authService = createApi({
    reducerPath: 'authService',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/api/auth' }),
    endpoints: (builder) => ({
        // chỉ cần lấy dữ liệu từ phía backend : builder.query
        // tương tác (sửa đổi, xóa,...) : builder.mutation  
        
        login: builder.mutation({
            query: (data) => ({
                url: "/handle-login",
                method: "POST",
                body: data
            })
        }),
        logout: builder.mutation({
            query : () =>"/handle-logout"
        })
    }),
})

export const {
    useLoginMutation,
    useLogoutMutation
} = authService

