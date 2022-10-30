import React from "react";
import "./Loading.css";

function Loading() {
    return (
        <div className="loading-container">
            <div className="spinner-border text-primary" role="status">
                <span className="visually-hidden">Loading...</span>
            </div>
        </div>
    );
}

export default Loading;
