import { createSlice } from '@reduxjs/toolkit';

const initialState = [
    { id: 1, title: "Làm bài tập" },
    { id: 2, title: "Đi chơi" },
    { id: 3, title: "Nấu ăn" },
];

const todoListSlice = createSlice({
    name: "todoList",
    initialState,
    reducers: {
        addTodo(state, action) {
            // action.payload là object new todo
            // Chỉ cần push vào trong state
            state.push(action.payload);
        },
        deleteTodo(state, action) {
            // Id của cv cần xóa = action.payload
            // Tìm index của object cần xóa trong array => sử dụng splice để xóa
            let index = state.findIndex(todo => todo.id === action.payload);

            state.splice(index, 1);
        },
        updateTodo(state, action) {
            const { id, title } = action.payload
            // Tìm kiếm công việc cần cập nhật
            let index = state.findIndex(todo => todo.id === id);

            // Cập nhật tiêu đề
            state[index].title = title
        }
    }
});

export const { addTodo, deleteTodo, updateTodo } = todoListSlice.actions

export default todoListSlice.reducer