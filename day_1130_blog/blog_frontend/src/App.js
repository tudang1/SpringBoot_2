import { Route, Routes } from 'react-router-dom';
import './App.css';
import LayoutAdmin from './component/LayoutAdmin';
import LayoutAnonymos from './component/LayoutAnonymos';
import NotFound from './component/NotFound';
import PrivateRoutes from './component/PrivateRoutes/inde';
import BlogAdminCreate from './pages/admin/blog/BlogAdminCreate';
import BlogAdminDetail from './pages/admin/blog/BlogAdminDetail';
import BlogAdminList from './pages/admin/blog/BlogAdminList';
import CategoryAdminList from './pages/admin/category/CategoryList';
import Login from './pages/admin/login';
import UserAdminCreate from './pages/admin/user/UserAdminCreate';
import UserAdminDetail from './pages/admin/user/UserAdminDetail';
import UserAdminList from './pages/admin/user/UserAdminList';
import BlogDetail from './pages/anonymos/BlogDetail';
import BlogList from './pages/anonymos/BlogList';

function App() {
  return (
    <>
      <Routes>
        {/* Anonymous */}
        <Route path='/' element={<LayoutAnonymos />}>
          <Route index element={<BlogList />} />
          <Route path='blogs/:blogId/:slug' element={<BlogDetail />} />
        </Route>

        {/* Admin */}
        <Route path="/admin" element={<LayoutAdmin />}>
          <Route element={<PrivateRoutes/>}>
            {/* Blog */}
            <Route path="blogs">

              <Route index element={<BlogAdminList />} />
              <Route path=':blogId' element={<BlogAdminDetail />} />
              <Route path='create' element={<BlogAdminCreate />} />

            </Route>

            {/* Category */}
            <Route path='categories' element={<CategoryAdminList />} />

            {/* User */}
            <Route path="users">
              <Route index element={<UserAdminList />} />
              <Route path=':userId' element={<UserAdminDetail/>} />
              <Route path='create' element={<UserAdminCreate />} />
            </Route>
          </Route>
        </Route>


        <Route path='/admin/login' element={<Login />} />
        <Route path='/not-found' element={<NotFound/>} />
      </Routes>
      </>
  );
}

export default App;
