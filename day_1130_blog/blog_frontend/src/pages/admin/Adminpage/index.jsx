import React from "react";
import { Link } from "react-router-dom";

function AdminPage() {
  return (
    <>
      <div className="header d-flex align-items-center">
        <div className="container-fluid">
          <div className="d-flex justify-content-start align-items-center">
            <div className="logo">
              <Link to={"/"}>
                <img
                  src="https://techmaster.vn/resources/image/logo-techmaster/white/white_200x74.png"
                  alt="logo"
                />
              </Link>
            </div>
          </div>
        </div>
      </div>

      <div className="course-container">
        <aside className="aside-wrapper">
          <nav
            id="navbar-example3"
            className="navbar navbar-light bg-light flex-column align-items-stretch p-3"
          >
            <nav className="nav nav-pills flex-column">
              <a className="nav-link" href="#item-1">
                Item 1
              </a>
              <nav className="nav nav-pills flex-column">
                <a className="nav-link ms-3 my-1" href="#item-1-1">
                  Item 1-1
                </a>
                <a className="nav-link ms-3 my-1" href="#item-1-2">
                  Item 1-2
                </a>
              </nav>
            </nav>
          </nav>
        </aside>
      </div>
    </>
  );
}

export default AdminPage;
