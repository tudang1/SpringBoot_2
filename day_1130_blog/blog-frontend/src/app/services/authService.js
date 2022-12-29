import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

export const authService = createApi({
    reducerPath: 'authService',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/api/auth' }),
    endpoints: (builder) => ({
        login: builder.mutation({
            query: (data) => ({
                url: "/handle-login",
                method: "POST",
                body: data
            })
        })
    })
})

export const { useLoginMutation, useLogoutMutation } = authService