import React from 'react'

function CourseCreate() {
  return (
    <>
        {/* <!--HEADER--> */}

    {/* <!-- BODY --> */}
    <div className="course-list mt-4 mb-4">
        <div className="container">
            <div className="mb-4">
                <button className="btn-custom btn-create-course">
                    <span><i className="fa-solid fa-plus"></i></span>
                    Tạo
                </button>
                <a href="./course-list.html" className="btn-custom btn-refresh">
                    <span><i className="fa-solid fa-angle-left"></i></span>
                    Quay lại
                </a>
            </div>

            <div className="course-list-inner p-2">
                <div className="row">
                    <div className="col-md-8">
                        <div className="mb-3">
                            <label for="course-name" className="form-label fw-bold">Tên khóa học</label>
                            <input type="text" className="form-control" id="course-name"/>
                        </div>
                        <div className="mb-3">
                            <label for="course-description" className="form-label fw-bold">Mô tả</label>
                            <textarea className="form-control" id="course-description" rows="10"></textarea>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div className="mb-3">
                            <label for="course-type" className="form-label fw-bold">Hình thức học</label>
                            <select className="form-control" id="course-type">
                                <option hidden>- Chọn hình thức học</option>
                                <option value="online">Online</option>
                                <option value="onlab">Onlab</option>
                            </select>
                        </div>
                        <div className="mb-3">
                            <label for="course-topic" className="form-label fw-bold">Chủ đề</label>
                            <select className="form-control" id="course-topic" multiple="multiple">
                                <option value="1">Backend</option>
                                <option value="2">Frontend</option>
                                <option value="3">Mobile</option>
                                <option value="4">Lập trình web</option>
                                <option value="5">Database</option>
                                <option value="6">Devops</option>
                            </select>
                        </div>
                        <div className="mb-3">
                            <label for="course-supporter" className="form-label fw-bold">Tư vấn viên</label>
                            <select className="form-control" id="course-supporter">
                                <option hidden>- Chọn tư vấn viên</option>
                                <option value="1">Nguyễn Văn A</option>
                                <option value="2">Trần Văn B</option>
                                <option value="3">Ngô Thị C</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </>
  )
}

export default CourseCreate