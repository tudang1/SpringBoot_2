import React from 'react'
import { Link } from 'react-router-dom'

function NotFound() {
  return (
    <>
        <h2 className='text-center'>Page Not Found</h2>
        <Link to={"/"} className="btn btn-success">Quay lại trang chủ</Link>
    </>
  )
}

export default NotFound