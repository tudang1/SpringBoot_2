import axios from "axios";
import React, { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import Api from "./Api";
import "react-toastify/dist/ReactToastify.css";
import { toast, ToastContainer } from "react-toastify";
import { useNavigate } from "react-router-dom";

function UserCreate() {
  const [provinces, setProvinces] = useState([]);
  const [userName, setUserName] = useState("");
  const [userEmail, setUserEmail] = useState("");
  const [userPhone, setUserPhone] = useState("");
  const [userPassword, setUserPassword] = useState("");
  const [tinh, setTinh] = useState("");
  const [users, setUsers] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchProvinces = async () => {
      try {
        let res = await axios.get("https://provinces.open-api.vn/api/p/");
        setProvinces(res.data);
      } catch (error) {
        console.log(error);
      }
    };
    const fetchUsers = async () => {
      try {
        let res = await Api.getUsers();
        setUsers(res.data);
        // setRenderedUser(res.data);
      } catch (error) {
        console.log(error);
      }
    };

    fetchUsers();
    fetchProvinces();
  }, []);

  const handleAdd = async (
    userName,
    userEmail,
    userPhone,
    tinh,
    userPassword
  ) => {
    try {
      if (!userName) {
        alert("Tiêu đề không được để trống");
        return;
      }
      //tao user moi
      let newUser = {
        name: userName,
        email: userEmail,
        phone: userPhone,
        address: tinh,
        password: userPassword,
      };
      // Gọi API xóa phía server
      let res = await Api.createUser(newUser);

      // Cập nhật trong state ban đầu
      const newUsers = [...users, res.data];
      setUsers(newUsers);
      //sau khi tạo User thành cong
      alert("Tạo User Thành Công");
      setTimeout(() => {
        navigate("/users");
      }, 1500);
    } catch (e) {
      alert(e.response.data.message);
    }
  };

  return (
    <div className="container mt-5 mb-5">
      <h2 className="text-center text-uppercase mb-3">Tạo user</h2>

      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="bg-light p-4">
            <div className="mb-3">
              <label className="col-form-label">Name</label>
              <input
                type="text"
                id="name"
                className="form-control"
                value={userName}
                onChange={(e) => setUserName(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Email</label>
              <input
                type="text"
                id="email"
                className="form-control"
                value={userEmail}
                onChange={(e) => setUserEmail(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Phone</label>
              <input
                type="text"
                id="phone"
                className="form-control"
                value={userPhone}
                onChange={(e) => setUserPhone(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label className="col-form-label">Address</label>
              <select
                className="form-select"
                id="address"
                value={tinh}
                onChange={(e) => setTinh(e.target.value)}
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
              <label className="col-form-label">Password</label>
              <input
                type="text"
                id="password"
                className="form-control"
                value={userPassword}
                onChange={(e) => setUserPassword(e.target.value)}
              />
            </div>
          </div>
          <div className="text-center mt-3">
            <button className="btn btn-secondary btn-back">Quay lại</button>
            <button
              className="btn btn-success"
              id="btn-save"
              onClick={() =>
                handleAdd(userName, userEmail, userPhone, tinh, userPassword)
              }
            >
              Tạo User
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
export default UserCreate;
