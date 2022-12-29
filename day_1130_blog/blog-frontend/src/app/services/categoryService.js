import baseApi from './baseService'

export const categoryService = baseApi.injectEndpoints({
    endpoints: (builder) => ({
        getCategories: builder.query({
            query: () => "/categories"
        }),
        createCategory: builder.mutation({
            query: (data) => ({
                url: "/categories",
                method: "POST",
                body: data
            })
        })
    })
})

export const { useGetCategoriesQuery, useCreateCategoryMutation } = categoryService
