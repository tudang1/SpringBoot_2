import React from "react";
import { useState } from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import {
  useCreateCategoryMutation,
  useGetCategoriesQuery,
} from "../../../../app/services/categoryService";

function CategoryAdminList() {
  const { categories } = useSelector((state) => state.categories);
  const { isLoading } = useGetCategoriesQuery();
  const [createCategory] = useCreateCategoryMutation();

  const handleCreateCategory = () => {
    const name = window.prompt("Enter Category..");

    if (name == null) {
      return;
    }
    if (name == "") {
      alert("Name k đc để trống");
      return;
    }
    console.log("goi aPI");
    createCategory({name})
      .unwrap()
      .then(() => {
        alert("Tạo thành công");
      })
      .catch((e) =>alert(e));
  };

  if (isLoading) {
    return <h3>Loading ...</h3>;
  }
  return (
    <div className="course-list mt-4 mb-4">
      <div className="container">
        <div className="mb-4">
          <button
            className="btn-custom btn-create-course"
            onClick={handleCreateCategory}
          >
            <span>
              <i className="fa-solid fa-plus"></i>
            </span>
            Tạo Category
          </button>
        </div>

        <div className="course-list-inner p-2">
          <table className="table course-table">
            <thead>
              <tr>
                <th>STT</th>
                <th>Category</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {categories.map((category, index) => (
                <tr key={category.id}>
                  <td>{index + 1}</td>
                  <td>{category.name}</td>
                  <td>
                    <button className="btn btn-info">Edit</button>
                    <button className="btn btn-danger">Delete</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default CategoryAdminList;
