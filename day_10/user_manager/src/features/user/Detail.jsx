import React from "react";

function Detail(){
    return(
        <div className="container mt-5 mb-5">
        <h2 className="text-center text-uppercase mb-3">Thông tin user</h2>

        <div className="row justify-content-center">
            <div className="col-md-6">
                <div className="bg-light p-4">
                    <div className="mb-3">
                        <label className="col-form-label">Name</label>
                        <input type="text" id="name" className="form-control" />
                    </div>
                    <div className="mb-3">
                        <label className="col-form-label">Email</label>
                        <input type="text" id="email" className="form-control" />
                    </div>
                    <div className="mb-3">
                        <label className="col-form-label">Phone</label>
                        <input type="text" id="phone" className="form-control" />
                    </div>
                    <div className="mb-3">
                        <label className="col-form-label">Address</label>
                        <select className="form-select" id="address">
                            
                        </select>
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Avatar</label>
                        <div className="avatar-preview mb-3 rounded">
                            <img src="" alt="avatar" id="avatar-preview" className="rounded"/>
                        </div>

                        <label for="avatar" classNameName="btn btn-warning">Đổi avatar</label>
                        <input type="file" id="avatar" className="d-none"/>
                      </div>
                    <div className="mb-3">
                        <label className="col-form-label">Password</label>
                        <div className="">
                            <button type="button" className="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#modal-change-password">
                                Đổi mật khẩu
                            </button>
                            <button className="btn btn-warning" id="btn-forgot-password">
                                Quên mật khẩu
                            </button>
                        </div>
                    </div>
                </div>
                <div className="text-center mt-3">
                    <button className="btn btn-secondary btn-back">Quay lại</button>
                    <button className="btn btn-success" id="btn-save">Cập nhật</button>
                </div>
            </div>
        </div>

        {/* <!-- Modal đổi mật khẩu--> */}
        <div className="modal fade" id="modal-change-password" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
            aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="staticBackdropLabel">Đổi mật khẩu</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <div className="mb-3">
                            <label className="col-form-label">Mật khẩu cũ</label>
                            <input type="text" id="old-password" className="form-control" />
                        </div>
                        <div className="mb-3">
                            <label className="col-form-label">Mật khẩu mới</label>
                            <input type="text" id="new-password" className="form-control" />
                        </div>
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                        <button type="button" className="btn btn-primary" id="btn-change-password">Xác nhận</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    )
}
export default Detail;