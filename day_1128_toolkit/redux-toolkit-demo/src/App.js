import './App.css';
import Counter from './components/Counter';
import TodoList from './components/TodoList';
import TodoListApi from './components/TodoListApi';

function App() {
  return (
    <div>
      <Counter />

      <TodoList />

      <TodoListApi/>
    </div>
  );
}

export default App;
