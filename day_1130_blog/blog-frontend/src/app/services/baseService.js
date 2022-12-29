import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

const baseApi = createApi({
    reducerPath: 'baseApi',
    baseQuery: fetchBaseQuery({
        baseUrl: 'http://localhost:8080/api/admin',
        prepareHeaders: (headers, { getState }) => {
            const token = getState().auth.token
            if (token) {
                headers.set('authorization', `Bearer ${token}`)
            }

            return headers
        },
    }),
    endpoints: () => ({})
})

export default baseApi;
