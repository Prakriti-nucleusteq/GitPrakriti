import React from 'react'


function Base({title = "welcome to website",children}) {
  return (
    <div className ="container-fluid  p-0 m-0">
   
        {children}
    </div>
  )
}

export default Base;