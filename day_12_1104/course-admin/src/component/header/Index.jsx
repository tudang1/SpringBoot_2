import React from 'react'
import { Link } from 'react-router-dom'

function Header() {
  return (
    <div className="header d-flex align-items-center">
    <div className="container-fluid">
      <div className="d-flex justify-content-start align-items-center">
        <div className="logo">
          <Link to={"/courses"}>
            <img
              src="https://techmaster.vn/resources/image/logo-techmaster/white/white_200x74.png"
              alt="logo"
            />
          </Link>
        </div>
        <div className="menu">
          <Link className="text-white ms-5"  to={"/courses"}>
            Danh sách khóa học
          </Link>
          <Link className="text-white ms-3"  to={"/courses/create"}>
            Tạo khóa học
          </Link>
        </div>
      </div>
    </div>
  </div>
  )
}

export default Header