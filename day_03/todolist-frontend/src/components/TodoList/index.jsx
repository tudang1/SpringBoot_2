import React, { useEffect, useState } from "react";
import todoApi from "../../api/todoApi";
import TodoInput from "../TodoInput";
import TodoItem from "../TodoItem";

function TodoList() {
    const [todos, setTodos] = useState([]);

    // Xử lý các side effect
    useEffect(() => {
        // async function dùng để lập trình bất đồng bộ
        const fetchTodos = async () => {
            let res = await todoApi.getTodos();
            console.log(res);

            setTodos(res.data);
        };

        fetchTodos();
    }, []);

    // Xử lý xóa công việc
    const handleDelete = async (id) => {
        try {
            console.log("parent : ", id);

            // Gọi API xóa phía server
            await todoApi.deleteTodo(id);

            // Cập nhật trong state ban đầu
            const newTodos = todos.filter((todo) => todo.id !== id);
            setTodos(newTodos);
        } catch (e) {
            console.log(e);
        }
    };

    // Thêm công việc
    const handleAddTodo = async (title) => {
        try {
            console.log("parent : ", title);

            // Tạo object todo muốn tạo
            let newTodo = {
                title,
            };

            // Gọi API xóa phía server
            let res = await todoApi.createTodo(newTodo);
            console.log(res.data);

            // Cập nhật trong state ban đầu
            const newTodos = [...todos, res.data]; // Spread Operator (ES6)
            setTodos(newTodos);
        } catch (e) {
            alert(e.response.data.message);
        }
    };

    // Cập nhật tiêu đề công việc
    const handleUpdateTitleTodo = async (id) => {
        try {
            console.log("parent : ", id);

            // Tìm kiếm công việc dựa trên id
            let currentTodo = todos.find((todo) => todo.id === id);

            let newTitle = window.prompt(
                "Enter new title : ",
                currentTodo.title
            );

            if (newTitle === null) return;
            if (!newTitle) {
                alert("Tiêu đề không được để trống");
                return;
            }

            const updatedTodo = {
                title: newTitle,
                status: currentTodo.status,
            };

            // Gọi API cập nhật phía server
            let res = await todoApi.updateTodo(id, updatedTodo);
            console.log(res.data);  

            // Cập nhật trong state ban đầu
            // { id : 1, title : "Học bài", status : false, title : "Làm bài tập"}
            const newTodos = todos.map((todo) => {
                if (todo.id === id) {
                    return { ...todo, title: newTitle };
                }
                return todo;
            }); // Spread Operator (ES6)
            setTodos(newTodos);
        } catch (e) {
            console.log(e);
        }
    };

    // Thay đổi trạng thái công việc
    const handleToggleStatus = async (id) => {
        try {
            console.log("parent : ", id);

            // Tìm kiếm công việc dựa trên id
            let currentTodo = todos.find((todo) => todo.id === id);

            const updatedTodo = {
                title: currentTodo.title,
                status: !currentTodo.status,
            };

            // Gọi API cập nhật phía server
            let res = await todoApi.updateTodo(id, updatedTodo);
            console.log(res.data);

            // Cập nhật trong state ban đầu
            // { id : 1, title : "Học bài", status : false, title : "Làm bài tập"}
            const newTodos = todos.map((todo) => {
                if (todo.id === id) {
                    return { ...todo, status: !todo.status };
                }
                return todo;
            }); // Spread Operator (ES6)
            setTodos(newTodos);
        } catch (e) {
            console.log(e);
        }
    };

    return (
        <div>
            <h1>TodoList Application</h1>

            <TodoInput onAddTodo={handleAddTodo} />

            <ul>
                {todos.length === 0 && (
                    <li>Không có công việc nào trong danh sách</li>
                )}
                {todos.length > 0 &&
                    todos.map((todo) => (
                        <TodoItem
                            key={todo.id}
                            todo={todo}
                            onDelete={handleDelete}
                            onUpdateTitleTodo={handleUpdateTitleTodo}
                            onToggleStatus={handleToggleStatus}
                        />
                    ))}
            </ul>
        </div>
    );
}

export default TodoList;
