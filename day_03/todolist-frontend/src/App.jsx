import { useEffect } from "react";
import todoApi from "./api/todoApi";
import "./App.css";
import TodoList from "./components/TodoList";
import Counter from "./Counter";

// cv1, cv2, cv3 : 2s
// 6s

// 2s

function App() {
    return (
        <div style={{ padding: 50 }}>
            {/* <TodoList /> */}
            <Counter />
        </div>
    );
}

export default App;
