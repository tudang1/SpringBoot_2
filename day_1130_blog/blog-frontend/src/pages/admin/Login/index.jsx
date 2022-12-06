import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useLoginMutation } from "../../../app/services/authService";

function Login() {
    const navigate = useNavigate();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [login] = useLoginMutation();

    // Xử lý login
    const handleLogin = (e) => {
        e.preventDefault();

        const loginRequest = {
            email,
            password,
        };

        login(loginRequest)
            .unwrap()
            .then(() => {
                alert("Login thành công");
                navigate("/admin/blogs")
            })
            .catch((error) => {
                console.log(error);
                alert("Login thất bại");
            });
    };

    return (
        <div id="login">
            <h3 className="text-center text-white pt-5">Login form</h3>
            <div className="container">
                <div
                    id="login-row"
                    className="row justify-content-center align-items-center"
                >
                    <div id="login-column" className="col-md-6">
                        <div id="login-box" className="col-md-12">
                            <form
                                id="login-form"
                                className="form p-4 shadow-lg"
                                onSubmit={(e) => handleLogin(e)}
                            >
                                <h3 className="text-center">Login</h3>
                                <div className="form-group mb-3">
                                    <label htmlFor="username" className="mb-2">
                                        Email:
                                    </label>
                                    <input
                                        type="text"
                                        name="username"
                                        id="username"
                                        className="form-control"
                                        value={email}
                                        onChange={(e) =>
                                            setEmail(e.target.value)
                                        }
                                    />
                                </div>
                                <div className="form-group mb-3">
                                    <label htmlFor="password" className="mb-2">
                                        Password:
                                    </label>
                                    <input
                                        type="text"
                                        name="password"
                                        id="password"
                                        className="form-control"
                                        value={password}
                                        onChange={(e) =>
                                            setPassword(e.target.value)
                                        }
                                    />
                                </div>
                                <div className="form-group text-center">
                                    <button
                                        type="submit"
                                        className="btn btn-success px-5"
                                    >
                                        Login
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
