import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { addTodo, deleteTodo } from "../../redux/action/todoAction";


function TodoList() {
     // Lấy ra dữ liệu từ state
     const todos = useSelector((state) => state.todos);
    //  console.log(todos);
 
     const [title, setTitle] = useState("");
    
     const dispatch = useDispatch();

     // Xử lý thêm công việc
     const handleAddTodo = () => {
         // Tiêu đề không được để trống mới được thêm (alert)
         if(title === ""){
            alert("tiêu dề k đc để trống")
            return;
         }
        //dispatch 1 event Tạo Todo
         dispatch(addTodo(title));
         setTitle("");
     };
 
     // Xử lý xóa công việc
     const handleDeleteTodo = (id) => {
         // Cần confirm trước khi xóa (window.confirm)
         const inDelete = window.confirm("Có muốn xóa k?");

         if(inDelete){
            dispatch(deleteTodo(id));
         }
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
                 {todos.length >0 && todos.map((todo) => (
                     <li key={todo.id}>
                         <span>{todo.title}</span>
                         <button onClick={() => handleDeleteTodo(todo.id)}>
                             Delete
                         </button>
                     </li>
                 ))}
                    {todos.length ===0 && <li>Không có công việc nào trong ds</li>}
             </ul>
         </>
     );
}

export default TodoList