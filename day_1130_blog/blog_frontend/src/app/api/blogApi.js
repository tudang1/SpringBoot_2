import axiosClient from "./axiosClient";

const blogApi = {
    getBlog(query){
        const url = `/blogs?${query}`;
        return axiosClient.get(url);
    },
    getBlogById(id,slug){
        const url = `/blogs/${id}/${slug}`;
        return axiosClient.get(url);
    }
}

export default blogApi