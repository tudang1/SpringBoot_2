import React from 'react'
import { Outlet } from 'react-router-dom'

import Header from '../Header'

function LayoutAnonymos() {
  return (
   <>
    <Header/>
    
    <Outlet/>
   </>
  )
}

export default LayoutAnonymos