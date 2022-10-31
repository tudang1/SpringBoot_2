import logo from './logo.svg';
import './App.css';
import UserIndex from './features/user/UserIndex';
import UserCreate from './features/user/UserCreate';
import Detail from './features/user/Detail';
import { Route, Router, Routes } from 'react-router-dom';
import Header from './components/Header/Index';
import NotFound from './components/notFound/Index';
import Footer from './components/Footer/Index';
function App() {
  return (
    <>
      
      <Header/>
      <Routes>
      <Route path='/users'>
        <Route index element = {<UserIndex/>} />
        <Route path='create' element ={<UserCreate />} />
        <Route path=':userId' element = {<Detail />} />
      </Route>
      <Route path='*' element={<NotFound />} />
      </Routes>
      <Footer/>
    </>
  );
}

export default App;
