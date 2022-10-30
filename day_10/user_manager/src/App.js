import logo from './logo.svg';
import './App.css';
import UserIndex from './features/user/UserIndex';
import UserCreate from './features/user/UserCreate';
function App() {
  return (
    <div className="App">
      {/* <UserIndex/> */}
      <UserCreate />
    </div>
  );
}

export default App;
