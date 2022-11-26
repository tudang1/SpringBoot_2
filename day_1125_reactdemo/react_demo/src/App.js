import './App.css';
import Counter from './components/Counter/Counter';
import ShoppingCart from './components/ShoppingCart';
import TodoList from './components/TodoList';

function App() {
  return (
    <>
      <Counter/>

      <TodoList />
      
      <ShoppingCart/>
    </>
  );
}

export default App;
