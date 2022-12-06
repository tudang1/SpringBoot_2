import React from 'react'

function Navidation() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div className="container-fluid taskbar">
        <button className=" btn-toggle" id="sidebarToggle"><i className="fa-solid fa-bars" style={{color: "#fff"}}></i></button>
       
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav ms-auto mt-2 mt-lg-0">
                
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="https://scontent.fhan15-2.fna.fbcdn.net/v/t1.18169-9/24852589_365622133863182_7606245839217546982_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=d51anmSwG88AX-zCXGU&_nc_ht=scontent.fhan15-2.fna&oh=00_AfAa2QZoh7N_NnDQbZijAoj1evb_2I8F1Xgq--Qrgpzq7Q&oe=63B5064E" className="rounded-circle" style={{width: "40px"}}
                alt="Avatar" />

                    </a>
                    <div className="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    
                        <div className="dropdown-divider"></div>
                        <a className="dropdown-item" href="./login.html">Đăng xuất</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
  )
}

export default Navidation