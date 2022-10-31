import { useEffect,useState } from "react";
import React from "react";
import axios from "axios";
import Api from "./Api";
import UserCreate from "./UserCreate";
import { Link } from "react-router-dom";

function UserIndex(){
    const [users, setUsers] = useState([]);
    const [term, setTerm] = useState("");

    const [renderedUser, setRenderedUser] = useState(users);

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                let res = await Api.getUsers();
                setUsers(res.data);
                setRenderedUser(res.data);
                
            } catch (error) {
                console.log(error);
            }
        };

        fetchUsers();
    }, []);

     // Xử lý search user
     const handleSearch = () => {
        // Nếu không nhập gì cả => get all (Hiển thị tất cả)
        if (!term) {
            setRenderedUser(users);
            return;
        }

        // Ngược lại, lọc user có username chứa term (không phân biệt hoa thường)
        const newRenderedUser = users.filter((user) =>
            user.name.toLowerCase().includes(term.toLowerCase())
        );
        setRenderedUser(newRenderedUser);
    };

    // Xử lý xóa công việc
    const handleDelete = async (id) => {
        try {
            
            // Gọi API xóa phía server
             await Api.deleteUser(id);
            
            // Cập nhật trong state ban đầu
            const newUser = users.filter((user) => user.id !== id);
            setUsers(newUser);
            setRenderedUser(newUser);
        } catch (e) {
            console.log(e);
        }
    };


    return(
        <div className="container mt-5 mb-5">
        <h2 className="text-center text-uppercase">Danh sách user</h2>

        <div className="row justify-content-center">
            <div className="col-md-10">

                <div className="d-flex justify-content-between align-items-center mt-5 mb-4">
                    <Link href="./create.html" className="btn btn-warning" to={"/users/create"}>Tạo user</Link>
                    <input type="text" id="search" className="form-control w-50" placeholder="Tìm kiếm user" 
                    value={term}
                    onChange={(e) => setTerm(e.target.value)}
                     />
                     <button
                                className="btn btn-info rounded-0 seach-form-button"
                                onClick={handleSearch}>    Search
                     </button>
                </div>

                <div className="bg-light p-4">
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            {renderedUser.map((user) => (
                                    <tr key={user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.name}</td>
                                        <td>{user.email}</td>
                                        <td>{user.phone}</td>
                                        <td>{user.address}</td>
                                        <td>
                                            <Link className="btn btn-success" to={"/user/"}>Xem chi tiết</Link>
                                            <button className="btn btn-danger" onClick={()=>handleDelete(user.id)}>Xóa</button>
                                        </td>
                                    </tr>
                            ))}
                            
                        </tbody>
                    </table>

                    <p className="message d-none"></p>
                </div>
            </div>
        </div>
    </div>
    )
}

export default UserIndex;