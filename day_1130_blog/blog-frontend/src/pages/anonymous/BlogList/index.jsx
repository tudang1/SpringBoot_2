import queryString from "query-string";
import React, { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import blogApi from "../../../app/api/blogApi";
import categoryApi from "../../../app/api/categoryApi";
import { convertDate } from "../../../utils/utils";

function BlogList() {
    const location = useLocation();
    const navigate = useNavigate();

    const [blogs, setBlogs] = useState([]);
    const [categories, setCategories] = useState([]);

    // Khởi tạo state ban đầu dựa trên url hiện tại
    const [filter, setFilter] = useState(() => {
        const params = queryString.parse(location.search);
        return {
            search: params.search || "",
            category: params.category || "",
        };
    });

    // Khi url thay đổi => parse lại url => lưu vào state
    useEffect(() => {
        const params = queryString.parse(location.search);
        setFilter({
            search: params.search || "",
            category: params.category || "",
        });
    }, [location.search]);

    // Lấy danh sách bài viết
    useEffect(() => {
        const fetchBlogs = async () => {
            try {
                const query = queryString.stringify(filter, {
                    skipEmptyString: true,
                }); // category=sylas&name=abc
                const res = await blogApi.getBlogs(query);
                setBlogs(res.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchBlogs();
    }, [location.search]);

    // Lấy danh sách category
    useEffect(() => {
        const fetchCategoies = async () => {
            try {
                let res = await categoryApi.getCategories();
                console.log(res);
                setCategories(res.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchCategoies();
    }, []);

    // Lọc theo category
    const filterByCategory = (name) => {
        const params = { ...filter, category: name };

        navigate({
            pathname: location.pathname, // http://localhost:3000
            search: queryString.stringify(params, { // category=sylas&name=abc
                skipEmptyString: true,
            }),
        });
    };

    return (
        <div className="course-container mt-5">
            <div className="container">
                <div className="row">
                    <div className="col-md-12">
                        <div className="row">
                            <div className="col-md-6">
                                <div className="seach-form d-flex align-items-center rounded shadow-sm mb-4 pe-3">
                                    <input
                                        type="text"
                                        placeholder="Tìm kiếm bài viết"
                                        className="form-control border-0 seach-form-input"
                                    />
                                    <span className="text-black-50 seach-form-button">
                                        <i className="fa-solid fa-magnifying-glass"></i>
                                    </span>
                                </div>

                                <div className="mb-4">
                                    {categories.length > 0 &&
                                        categories.map((category) => (
                                            <button
                                                key={category.id}
                                                className="btn btn btn-outline-success"
                                                onClick={() =>
                                                    filterByCategory(
                                                        category.name
                                                    )
                                                }
                                            >
                                                {category.name}
                                            </button>
                                        ))}
                                </div>
                            </div>
                        </div>
                        <div className="course-list row">
                            {blogs.length > 0 &&
                                blogs.map((blog) => (
                                    <div key={blog.id} className="col-md-3">
                                        <Link
                                            to={`/blogs/${blog.id}/${blog.slug}`}
                                        >
                                            <div className="course-item shadow-sm rounded mb-4">
                                                <div className="course-item-image">
                                                    <img
                                                        src="https://media.techmaster.vn/api/static/36/uhWHezPC"
                                                        alt={blog.title}
                                                    />
                                                </div>
                                                <div className="course-item-info p-3">
                                                    <h2 className="fs-5 mb-3 text-dark">
                                                        {blog.title}
                                                    </h2>
                                                    <p className="text-black-50">
                                                        {blog.description}
                                                    </p>
                                                    <p className="type fw-light text-black-50">
                                                        {convertDate(
                                                            blog.publishedAt
                                                        )}
                                                    </p>
                                                </div>
                                            </div>
                                        </Link>
                                    </div>
                                ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default BlogList;
