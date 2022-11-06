import logo from './logo.svg';
import './App.css';
import CourseList from './list/Index';
import CourseEdit from './edit/Index';
import CourseCreate from './create/Index';
import Header from './component/header/Index';
import {Route, Routes} from 'react-router-dom';
import NotFound from './component/notFound/Index';

function App() {
  return (
    <>
    <Header/>
    <Routes>
    <Route path = '/courses'>
      <Route index element = {<CourseList/>}/>
      <Route path='create' element={<CourseCreate/>}/>
      <Route path=':courseId' element = {<CourseEdit/>}/>
    </Route>
    <Route path='*' element = {<NotFound/>}/>
    </Routes>
    
    </>
  );
}

export default App;
