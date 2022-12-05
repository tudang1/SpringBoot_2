import { Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './component/Header';
import LayoutAnonymos from './component/LayoutAnonymos';
import AdminPage from './pages/admin/Adminpage';
import Login from './pages/admin/login';
import BlogDetail from './pages/anonymos/BlogDetail';
import BlogList from './pages/anonymos/BlogList';

function App() {
  return (
    // <>
    //   <Routes>
    //     <Route path='/' element={<LayoutAnonymos/>}>
    //       <Route index element={<BlogList/>}/>
    //       <Route path='blogs/:blogId/:slug' element={<BlogDetail/>}/>
    //     </Route>
    //   </Routes>
    // </>
    <Login/>
  );
}

export default App;
