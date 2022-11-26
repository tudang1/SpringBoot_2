const initialState = [
    { id: 1, title: "Làm bài tập" },
    { id: 2, title: "Đi chơi" },
    { id: 3, title: "Nấu ăn" },
];

const randomId = ()=>{
    return Math.floor(Math.random()*1000);
}

const todoReducer = (state = initialState, action) => {
    // console.log(action);

    switch (action.type) {
        case "todo/addTodo": {
            // Cập nhật và return state mới vào đây
            const newTodo = {
                id: randomId(),
                title: action.payload
                
            }
            const newState = [...state,newTodo];
            return newState;

        }
        case "todo/deleteTodo": {
            // Cập nhật và return state mới vào đây
            const newState = state.filter(todo => todo.id !== action.payload);
            return newState;

        }
        default: {
            return state;
        }
    }
}

export default todoReducer;