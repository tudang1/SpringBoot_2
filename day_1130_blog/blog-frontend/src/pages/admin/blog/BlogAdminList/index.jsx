import React from 'react'
import { Link } from 'react-router-dom'

function BlogAdminList() {
  return (
    <div className="course-list mt-4 mb-4">
        <div className="container">
            <div className="mb-4">
                <Link to={"/admin/blogs/create"} className="btn-custom btn-create-course">
                    <span><i className="fa-solid fa-plus"></i></span>
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
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <a href="./course-edit.html">SpringBoot - Web Back End</a>
                            </td>
                            <td>backend, cơ sở dữ liệu, lập trình web</td>
                            <td>Nháp</td>
                            <td>22/11/2022</td>
                        </tr>
                        <tr>
                            <td>
                                <a href="./course-edit.html">SpringBoot - Web Back End</a>
                            </td>
                            <td>backend, cơ sở dữ liệu, lập trình web</td>
                            <td>Nháp</td>
                            <td>22/11/2022</td>
                        </tr>
                        <tr>
                            <td>
                                <a href="./course-edit.html">SpringBoot - Web Back End</a>
                            </td>
                            <td>backend, cơ sở dữ liệu, lập trình web</td>
                            <td>Nháp</td>
                            <td>22/11/2022</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  )
}

export default BlogAdminList