import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

export const categoryService = createApi({
    reducerPath: 'categoryService',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/api/admin' }),
    endpoints: (builder) => ({
        getCategories: builder.query({
            query: () => "/categories"
        }),
        deleteCategory: builder.mutation({
            query: (id) => ({
                url: `/categories/${id}`,
                method: "DELETE"
            }),
            transformResponse: (response, meta, arg) => {
                return arg
            }
        }),
    })
})

export const {
    useGetCategoriesQuery,
    useDeleteCategoryMutation
} = categoryService