import axios from "axios";
import Api from "./Api";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function Detail() {
  const { userId } = useParams();
  const [provinces, setProvinces] = useState([]);
  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        // let res = await axios.get(
        //     `http://localhost:8080/api/v1/users/${userId}`
        // );
        //Gọi API
        let res = await Api.getUserById(userId);
        setUser(res.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchUser();
  }, []);

  useEffect(() => {
    const fetchProvinces = async () => {
      try {
        let res = await axios.get("https://provinces.open-api.vn/api/p/");
        setProvinces(res.data);
      } catch (error) {
        console.log(error);
      }
    };

    fetchProvinces();
  }, []);

  const updateInfo = ()=>{
    
  }
  return (
    <div className="container mt-5 mb-5">
      <h2 className="text-center text-uppercase mb-3">Thông tin user</h2>

      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="bg-light p-4">
            <div className="mb-3">
              <label className="col-form-label">Name</label>
              <input
                type="text"
                id="name"
                className="form-control"
                value={user?.name}
                onChange={(e) => setUser({ ...user, name: e.target.value })}
              />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Email</label>
              <input
                type="text"
                id="email"
                className="form-control"
                disabled
                defaultValue={user?.email}
              />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Phone</label>
              <input
                type="text"
                id="phone"
                className="form-control"
                value={user?.phone}
                onChange={(e) => setUser({ ...user, phone: e.target.value })}
              />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Address</label>
              <select
                className="form-select"
                id="address"
                value={user?.address}
                onChange={(e) => setUser(e.target.value)}
              >
                <option hidden>Chọn Tỉnh/Thành Phố</option>
                {provinces.map((p) => (
                  <option value={p.name} key={p.code}>
                    {p.name}
                  </option>
                ))}
              </select>
            </div>
            <div className="mb-3">
              <label className="form-label">Avatar</label>
              <div className="avatar-preview mb-3 rounded">
                <img
                  src={user?.avatar ?? "https://via.placeholder.com/150"}
                  alt="avatar"
                  id="avatar-preview"
                  className="rounded"
                />
              </div>

              <label for="avatar" classNameName="btn btn-warning">
                Đổi avatar
              </label>
              <input type="file" id="avatar" className="d-none" />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Password</label>
              <div className="">
                <button
                  type="button"
                  className="btn btn-primary"
                  data-bs-toggle="modal"
                  data-bs-target="#modal-change-password"
                >
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
            <button className="btn btn-success" id="btn-save" onClick={()=>updateInfo()}>
              Cập nhật
            </button>
          </div>
        </div>
      </div>

      {/* <!-- Modal đổi mật khẩu--> */}
      <div
        className="modal fade"
        id="modal-change-password"
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabindex="-1"
        aria-labelledby="staticBackdropLabel"
        aria-hidden="true"
      >
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="staticBackdropLabel">
                Đổi mật khẩu
              </h5>
              <button
                type="button"
                className="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
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
              <button
                type="button"
                className="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Đóng
              </button>
              <button
                type="button"
                className="btn btn-primary"
                id="btn-change-password"
              >
                Xác nhận
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Detail;
