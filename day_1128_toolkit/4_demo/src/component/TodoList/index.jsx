import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { addTodo, deleteTodo, updateTodo } from "../../app/slices/todoListSlice";

// Random id
const randomId = () => {
    return Math.floor(Math.random() * 1000);
};

function TodoList() {
    // Lấy ra dữ liệu từ state
    const todos = useSelector((state) => state.todos);

    const [title, setTitle] = useState("");
    const dispatch = useDispatch();

    // Xử lý thêm công việc
    const handleAddTodo = () => {
        // Tiêu đề không được để trống mới được thêm (alert)
        if (title == "") {
            alert("Tiêu đề không được để trống");
            return;
        }

        // Tạo new todo
        let newTodo = {
            id: randomId(),
            title: title,
        };

        // Dispatch event để tạo todo
        dispatch(addTodo(newTodo));
        setTitle("");
        // {
        //     type : "todo/addTodo",
        //     payload : title
        // }
    };

    // Xử lý xóa công việc
    const handleDeleteTodo = (id) => {
        // Cần confirm trước khi xóa (window.confirm)
        const isDelete = window.confirm("Bạn có muốn xóa không?");
        if (isDelete) {
            dispatch(deleteTodo(id));
        }
    };

    // Demo thay đổi title
    const handleUpdate = () => {
        let todo = {
            id: 1,
            title: "Title update",
        };
        dispatch(updateTodo(todo));
    };

    return (
        <>
            <h2>TodoList</h2>

            <input
                type="text"
                placeholder="Enter todo ..."
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />
            <button onClick={handleAddTodo}>Add</button>

            <ul>
                {todos.length > 0 &&
                    todos.map((todo) => (
                        <li key={todo.id}>
                            <span>{todo.title}</span>
                            <button onClick={() => handleDeleteTodo(todo.id)}>
                                Delete
                            </button>
                        </li>
                    ))}

                {todos.length === 0 && (
                    <li>Không có công việc nào trong danh sách</li>
                )}
            </ul>

            <button onClick={handleUpdate}>Update</button>
        </>
    );
}

export default TodoList;
