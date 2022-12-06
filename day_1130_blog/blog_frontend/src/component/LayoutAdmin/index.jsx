import React from 'react'
import { Outlet } from 'react-router-dom'
import Navidation from '../Navigation'
import SideBar from '../SideBar'

function LayoutAdmin() {
  return (
    <div className="d-flex" id="wrapper">
        <SideBar/>

        <div id="page-content-wrapper">
            <Navidation/>
            
            <div className='container-fluid mt-5'>
                <Outlet/>
            </div>
        </div>
    </div>
  )
}

export default LayoutAdmin