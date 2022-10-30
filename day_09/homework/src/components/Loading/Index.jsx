import React from "react";
import "./Loading.css"

function Loading(){
    return (
        <div className="spinner-border text-secondary" role="status">
    <span className="visually-hidden">Loading...</span>
    </div>
    );
}

export default Loading;