import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
    useCreateTodoMutation,
    useDeleteTodoMutation,
    useGetTodosQuery,
    useUpdateTodoMutation,
} from "../../app/service/todoListApiService";

function TodoListApi() {
    // Lấy ra dữ liệu từ state
    const todos = useSelector((state) => state.todoList.todos);

    const { isLoading } = useGetTodosQuery();
    const [createTodo] = useCreateTodoMutation();
    const [updateTodo] = useUpdateTodoMutation();
    const [deleteTodo] = useDeleteTodoMutation();

    const [title, setTitle] = useState("");

    // Xử lý thêm công việc
    const handleAddTodo = () => {
        // Tiêu đề không được để trống mới được thêm (alert)
        if (title == "") {
            alert("Tiêu đề không được để trống");
            return;
        }

        let newTodo = {
            title : title,
            status : false
        }

        createTodo(newTodo)
        setTitle("");
    };

    // Xử lý xóa công việc
    const handleDeleteTodo = (id) => {
        // Cần confirm trước khi xóa (window.confirm)
        const isDelete = window.confirm("Bạn có muốn xóa không?");
        if (isDelete) {
            deleteTodo(id)
        }
    };

    if (isLoading) {
        return <h3>Loading ...</h3>;
    }

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
        </>
    );
}

export default TodoListApi;