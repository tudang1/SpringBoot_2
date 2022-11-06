import React from 'react'
import { Link } from 'react-router-dom';

function CourseItem(props) {
  const {id,name,type,description} = props;


  return (
    <tr>
    <td>{id}</td>
    <td>
      <Link to={`/courses/${id}`}>{name}</Link>
    </td>
    <td class="text-info">{type}</td>
    <td >{description.substring(0, 20)}</td>
  </tr>
  )
}

export default CourseItem