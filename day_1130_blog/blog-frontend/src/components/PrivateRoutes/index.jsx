import React from "react";
import { useSelector } from "react-redux";
import { Navigate, Outlet } from "react-router-dom";

function PrivateRoutes() {
    // auth = state.auth.auth
    // isAuthenticated = state.auth.isAuthenticated
    const { auth, isAuthenticated } = useSelector((state) => state.auth);

    // Nếu chưa đăng nhập => quay về trang login
    if (!isAuthenticated) {
        return <Navigate to={"/admin/login"} />;
    }

    // Nếu đã đăng nhập, mà không có quyền => 404 notfound, 403 fobidden
    if(!auth.roles.includes("ADMIN")) {
        return <Navigate to={"/not-found"} />;
    }


    return <Outlet />;
}

export default PrivateRoutes;
