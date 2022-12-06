import React from "react";
import { Link } from "react-router-dom";

function Sidebar() {
    return (
        <div className="border-end" id="sidebar-wrapper">
            <div
                className="sidebar-heading border-bottom d-flex justify-content-between align-items-center"
                style={{ backgroundColor: "#30598c" }}
            >
                <div className="logo">
                    <img
                        src="https://techmaster.vn/resources/image/logo-techmaster/white/white_200x74.png"
                        alt="logo"
                    />
                </div>
            </div>
            <div
                className="list-group list-group-flush "
                style={{
                    backgroundColor: "#363636",
                    height: "590px",
                    color: "#fff",
                }}
            >
                <div className="accordion" id="accordionExample">
                    <div className="accordion-item">
                        <h2 className="accordion-header" id="headingOne">
                            <button
                                className="accordion-button"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#collapseOne"
                                aria-expanded="true"
                                aria-controls="collapseOne"
                            >
                                Quản lý bài viết
                            </button>
                        </h2>
                        <div
                            id="collapseOne"
                            className="accordion-collapse collapse show"
                            aria-labelledby="headingOne"
                            data-bs-parent="#accordionExample"
                        >
                            <div className="accordion-body">
                                <ul className="p-0">
                                    <li className="my-2">
                                        <Link to={"/admin/blogs"}>
                                            Danh sách bài viết
                                        </Link>
                                    </li>
                                    <li className="my-2">
                                        <Link to={"/admin/blogs/create"}>
                                            Tạo bài viết
                                        </Link>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div className="accordion-item">
                        <h2 className="accordion-header" id="headingTwo">
                            <button
                                className="accordion-button collapsed"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#collapseTwo"
                                aria-expanded="false"
                                aria-controls="collapseTwo"
                            >
                                Quản lý category
                            </button>
                        </h2>
                        <div
                            id="collapseTwo"
                            className="accordion-collapse collapse"
                            aria-labelledby="headingTwo"
                            data-bs-parent="#accordionExample"
                        >
                            <div className="accordion-body">
                                <ul className="p-0">
                                    <li className="my-2">
                                        <Link to={"/admin/categories"}>
                                            Danh sách category
                                        </Link>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div className="accordion-item">
                        <h2 className="accordion-header" id="headingThree">
                            <button
                                className="accordion-button collapsed"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#collapseThree"
                                aria-expanded="false"
                                aria-controls="collapseThree"
                            >
                                Quản lý user
                            </button>
                        </h2>
                        <div
                            id="collapseThree"
                            className="accordion-collapse collapse"
                            aria-labelledby="headingThree"
                            data-bs-parent="#accordionExample"
                        >
                            <div className="accordion-body">
                                <ul className="p-0">
                                    <li className="my-2">
                                        <Link to={"/admin/users"}>
                                            Danh sách user
                                        </Link>
                                    </li>
                                    <li className="my-2">
                                        <Link to={"/admin/users/create"}>
                                            Tạo user
                                        </Link>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Sidebar;
