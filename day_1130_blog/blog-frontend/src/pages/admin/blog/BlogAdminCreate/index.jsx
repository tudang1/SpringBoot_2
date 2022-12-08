import React from 'react'
import { useState } from 'react'
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom'
import Select from 'react-select'
import SimpleMdeReact from 'react-simplemde-editor';
import { useGetCategoriesQuery } from '../../../../app/services/categoryService';


function BlogAdminCreate() {
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");
    const [description, setDescription] = useState("");
    const [status, setStatus] = useState(false);
    const [categoryIds, setCategoryIds] = useState([]);

    const { categories } = useSelector((state) => state.categories);
    const { isLoading } = useGetCategoriesQuery();

    const options = categories.map((category) => {
        return {
            value: category.id,
            label: category.name,
        };
    });

    console.log(options);

    const handleChangeContent = (value) => {
        setContent(value);
    };

    const handleCreateBlog = () => {};

    if (isLoading) {
        return <h3>Loading ...</h3>;
    }

    return (
        <div className="course-list mt-4 mb-4">
            <div className="container">
                <div className="mb-4">
                    <button
                        className="btn-custom btn-create-course"
                        onClick={handleCreateBlog}
                    >
                        <span>
                            <i className="fa-solid fa-plus"></i>
                        </span>
                        Tạo
                    </button>
                    <Link
                        to={"/admin/blogs"}
                        className="btn-custom btn-refresh"
                    >
                        <span>
                            <i className="fa-solid fa-angle-left"></i>
                        </span>
                        Quay lại
                    </Link>
                </div>

                <div className="course-list-inner p-2">
                    <div className="row">
                        <div className="col-md-8">
                            <div className="mb-3">
                                <label
                                    htmlFor="course-name"
                                    className="form-label fw-bold"
                                >
                                    Tiêu đề
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="course-name"
                                    value={title}
                                    onChange={e => setTitle(e.target.value)}
                                />
                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="course-content"
                                    className="form-label fw-bold"
                                >
                                    Nội dung
                                </label>
                                <SimpleMdeReact
                                    value={content}
                                    onChange={handleChangeContent}
                                />
                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="course-description"
                                    className="form-label fw-bold"
                                >
                                    Mô tả
                                </label>
                                <textarea
                                    className="form-control"
                                    id="course-description"
                                    rows="5"
                                    value={description}
                                    onChange={e => setDescription(e.target.value)}
                                ></textarea>
                            </div>
                        </div>
                        <div className="col-md-4">
                            <div className="mb-3">
                                <label
                                    htmlFor="course-type"
                                    className="form-label fw-bold"
                                >
                                    Trạng thái
                                </label>
                                <select
                                    className="form-control"
                                    id="course-type"
                                    onChange={e => setStatus(e.target.value == "true" ? true : false)}
                                >
                                    <option value="false" selected={status === false}>Nháp</option>
                                    <option value="true" selected={status === true}>Công khai</option>
                                </select>
                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="course-topic"
                                    className="form-label fw-bold"
                                >
                                    Danh mục
                                </label>
                                <Select options={options} isMulti />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default BlogAdminCreate;