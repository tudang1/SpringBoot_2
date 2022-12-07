import React from "react";
import { useSelector } from "react-redux";
import { useLogoutMutation } from "../../app/services/authService";

function Navigation() {
    const { auth } = useSelector((state) => state.auth);
    const [logout] = useLogoutMutation();

    const handleLogout = () => {
        logout();
    };
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <div className="container-fluid taskbar">
                <button className=" btn-toggle" id="sidebarToggle">
                    <i
                        className="fa-solid fa-bars"
                        style={{ color: " #fff" }}
                    ></i>
                </button>

                <div
                    className="collapse navbar-collapse"
                    id="navbarSupportedContent"
                >
                    <ul className="navbar-nav ms-auto mt-2 mt-lg-0">
                        <li className="nav-item dropdown">
                            <a
                                className="nav-link dropdown-toggle"
                                id="navbarDropdown"
                                href="#"
                                role="button"
                                data-bs-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                            >
                                <img
                                    src={auth?.avatar ? auth?.avatar : "https://via.placeholder.com/150"}
                                    className="rounded-circle"
                                    style={{ width: "40px" }}
                                    alt={auth?.name}
                                />
                            </a>
                            <div
                                className="dropdown-menu dropdown-menu-end"
                                aria-labelledby="navbarDropdown"
                            >
                                <div className="dropdown-divider"></div>
                                <button
                                    className="dropdown-item"
                                    onClick={handleLogout}
                                >
                                    Đăng xuất
                                </button>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}

export default Navigation;