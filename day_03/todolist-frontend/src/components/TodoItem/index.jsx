import React from "react";

function TodoItem({ todo, onDelete, onUpdateTitleTodo, onToggleStatus }) {
    const handleDelete = (id) => {
        onDelete(id);
    };

    const handleUpdateTitle = (id) => {
        onUpdateTitleTodo(id);
    };

    const handleToggleStatus = (id) => {
        onToggleStatus(id);
    };

    return (
        <li>
            <input
                type="checkbox"
                checked={todo.status}
                onChange={() => handleToggleStatus(todo.id)}
            />
            <span style={{ color: todo.status ? "red" : "black" }}>
                {todo.title}
            </span>
            <button onClick={() => handleUpdateTitle(todo.id)}>Edit</button>
            <button onClick={() => handleDelete(todo.id)}>Delete</button>
        </li>
    );
}

export default TodoItem;
