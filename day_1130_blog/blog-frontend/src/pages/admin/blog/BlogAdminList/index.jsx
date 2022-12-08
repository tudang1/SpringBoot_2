import React from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import {
    useDeleteBlogMutation,
    useGetBlogsQuery,
} from "../../../../app/services/blogService";
import { convertDate } from "../../../../utils/utils";

function BlogAdminList() {
    const { blogs } = useSelector((state) => state.blogs);
    const { isLoading } = useGetBlogsQuery();
    const [deleteBlog] = useDeleteBlogMutation();

    const handleDeleteBlog = (id) => {
        const isConfirm = window.confirm("Bạn có muốn xóa không?");
        if (isConfirm) {
            deleteBlog(id)
                .unwrap()
                .then(() => alert("Xóa thành công"))
                .catch((err) => console.log(err));
        }
    };

    if (isLoading) {
        return <h3>Loading ...</h3>;
    }

    return (
        <div className="course-list mt-4 mb-4">
            <div className="container">
                <div className="mb-4">
                    <Link
                        to={"/admin/blogs/create"}
                        className="btn-custom btn-create-course"
                    >
                        <span>
                            <i className="fa-solid fa-plus"></i>
                        </span>
                        Tạo bài viết
                    </Link>
                </div>

                <div className="course-list-inner p-2">
                    <table className="table course-table">
                        <thead>
                            <tr>
                                <th>Tiêu đề</th>
                                <th>Danh mục</th>
                                <th>Trạng thái</th>
                                <th>Ngày tạo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {blogs.map((blog) => (
                                <tr key={blog.id}>
                                    <td>
                                        <Link to={`/admin/blogs/${blog.id}`}>
                                            {blog.title}
                                        </Link>
                                    </td>
                                    <td>
                                        {blog.categories
                                            .map((c) => c.name)
                                            .join(", ")}
                                    </td>
                                    <td>
                                        {blog.status ? "Công khai" : "Nháp"}
                                    </td>
                                    <td>{convertDate(blog.createdAt)}</td>
                                    <td>
                                        <button
                                            className="btn btn-danger"
                                            onClick={() =>
                                                handleDeleteBlog(blog.id)
                                            }
                                        >
                                            Xóa
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default BlogAdminList;