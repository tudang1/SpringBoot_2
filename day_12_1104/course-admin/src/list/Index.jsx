import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import style from "./style.css";
import Api from "../api/Api";
import Header from "../component/header/Index";
import CourseItem from "../courseItem/Index";
import { Link } from "react-router-dom";

function CourseList() {
  const [courses,setCourses] = useState([]);

  useEffect(()=>{
    const fetchCourses = async() =>{
      try{
        let res = await Api.getCourses();
        setCourses(res.data);
      
      }catch (e){
        console.log(e);
      }
    };
    fetchCourses();
  },[]);

  return (
    <>
      <div class="course-list mt-4 mb-4">
        <div class="container">
          <div class="mb-4">
            <Link to={"/courses/create"} class="btn-custom btn-create-course">
              <span>
                <i class="fa-solid fa-plus"></i>
              </span>
              Tạo khóa học
            </Link>
            <a href="./course-list.html" class="btn-custom btn-refresh">
              <span>
                <i class="fa-solid fa-arrow-rotate-right"></i>
              </span>
              Refresh
            </a>
          </div>

          <div class="course-list-inner p-2">
            <table class="table course-table">
              <thead>
                <tr>
                  <th>STT</th>
                  <th>Tên khóa học</th>
                  <th>Hình thức</th>
                  <th>Chủ đề</th>
                </tr>
              </thead>
              <tbody>
                {courses.map((course)=>(
                  <CourseItem
                    key={course.id}
                    id= {course.id}
                    name ={course.name}
                    type ={course.type}
                    description ={course.description}
                    
                  />
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
}

export default CourseList;
