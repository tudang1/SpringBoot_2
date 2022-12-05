import React from 'react'

function Login() {
  return (
    <div className="login-container">
    <form className="formLogin px-5 py-5 mt-3">
        <h2 >Login</h2>
      <div className="mb-3 ">
        <label for="exampleDropdownFormEmail1" className="form-label">Email address</label>
        <input type="email" className="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com"/>
      </div>
      <div className="mb-3">
        <label for="exampleDropdownFormPassword1" className="form-label">Password</label>
        <input type="password" className="form-control" id="exampleDropdownFormPassword1" placeholder="Password"/>
      </div>
      <div className="mb-3">
        <div className="form-check">
          <input type="checkbox" className="form-check-input" id="dropdownCheck"/>
          <label className="form-check-label" for="dropdownCheck">
            Remember me
          </label>
        </div>
      </div>
      <button type="submit" className="btn btn-primary">Sign in</button>
      <div className="dropdown-divider"></div>
    <a className="dropdown-item" href="#">New around here? Sign up</a>
    <a className="dropdown-item" href="#">Forgot password?</a>
    </form>
    
  </div>
  )
}

export default Login