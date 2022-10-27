import logo from './logo.svg';
import './App.css';
import Parent from "./props/Parent";
import Counter from './hook_ustState/Counter';
import List from './hook_ustState/List';
import Content from './hook_useEffect/Content';
import Api from './hook_useEffect/Api';

function App() {
  return (
    <div className="App">
      {/* <Counter /> */}
      {/* <List /> */}
      {/* <Content /> */}
      {/* <Parent/> */}
      <Api/>
    </div>
  );
}

export default App;
