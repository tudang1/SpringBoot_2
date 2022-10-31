import React from "react";
import { Link } from "react-router-dom";

function NotFound(){
    return(
        <div className="container">
            <div className="text-center my-5">
                <h2 className="mb-3">Page Not Found</h2>
                <Link to={"/users"} className="btn btn-primary">
                    Go Home
                </Link>
            </div>
        </div>
    )
}
export default NotFound;