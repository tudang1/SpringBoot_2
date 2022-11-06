import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import Api from '../api/Api';

function CourseEdit() {
    const {courseId} = useParams();
    const [course,setCourse] = useState([]);
    const [users,setUsers] = useState([]);

    useEffect(()=>{
        const fetchUsers = async() =>{
            try{
                let res = await Api.getUsers();
                // console.log(res)
                setUsers(res.data);
            }catch(error){
                console.log(error);
            }
        };
        fetchUsers();
    },[]);

    useEffect(()=>{
        const fetchCourse = async() =>{
            try{
                let res = await Api.getCourseById(courseId);
                setCourse(res.data);
                
            }catch(error){
                console.log(error);
            }
        };
        fetchCourse();
    },[]);

    
  return (
    console.log(course)
//     <>
//     <div className="course-list mt-4 mb-4">
//         <div className="container">
//             <div className="mb-4 d-flex justify-content-between">
//                 <div>
//                     <button className="btn-custom btn-update-course">
//                         <span><i className="fa-solid fa-plus"></i></span>
//                         Cập nhật
//                     </button>
//                     <a href="./course-list.html" className="btn-custom btn-refresh">
//                         <span><i className="fa-solid fa-angle-left"></i></span>
//                         Quay lại
//                     </a>
//                 </div>
//                 <div>
//                     <button className="btn-custom btn-delete-course bg-danger">
//                         <span><i className="fa-solid fa-trash-can"></i></span>
//                         Xóa
//                     </button>
//                 </div>
//             </div>

//             <div className="course-list-inner p-2">
//                 <div className="row">
//                     <div className="col-md-8">
//                         <div className="mb-3">
//                             <label for="course-name" className="form-label fw-bold">Tên khóa học</label>
//                             <input 
//                                 type="text" 
//                                 className="form-control" 
//                                 value={course?.name}
//                                 onChange={(e) =>({...course,name: e.target.value})}
//                             />
//                         </div>
//                         <div className="mb-3">
//                             <label for="course-description" className="form-label fw-bold">Mô tả</label>
//                             <textarea className="form-control" id="course-description" rows="10"
//                                 value={course?.description}
//                                 onChange={(e) =>({...course,description: e.target.value})}
//                             ></textarea>
//                         </div>
//                     </div>
//                     <div className="col-md-4">
//                         <div className="mb-3">
//                             <label for="course-type" className="form-label fw-bold">Hình thức học</label>
//                             <select className="form-control" id="course-type"
//                                 value={course?.type}
//                                 onChange={(e) =>({...course,type: e.target.value})}
//                             >
//                                 <option hidden>- Chọn hình thức học</option>
//                                 <option value="online">Online</option>
//                                 <option value="onlab">Onlab</option>
//                             </select>
//                         </div>
//                         <div className="mb-3">
//                             Chủ đề
//                         </div>
//                         <div className="mb-3">
//                             <label className="form-label fw-bold">Tư vấn viên</label>
//                             <select className="form-control" 
                                
//                             >
//                                 <option hidden>- Chọn tư vấn viên</option>
//                                 {users.map((u)=>(
//                                     <option value={u.name} key={u.id}>{u.name}</option>
//                                 ))}
//                             </select>
//                         </div>

//                         <div className="mb-3">
//                             <label className="form-label fw-bold">Thumnail</label>
//                             <div className="course-logo-preview mb-3 rounded">
//                                 <img 
//                                     id="course-logo-preview" 
//                                     className="rounded"
//                                     src={course?.thumbnail ?? "https://via.placeholder.com/150"}
//                                 />
//                             </div>

//                             <label for="course-logo-input" className="btn btn-warning"/>Đổi ảnh
//                                 <input type="file" id="course-logo-input" className="d-none"/>
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     </div>
//   </>
  )
}

export default CourseEdit;