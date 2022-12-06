import { Route, Routes } from 'react-router-dom';
import './App.css';
import LayoutAdmin from './components/LayoutAdmin';
import LayoutAnonymous from './components/LayoutAnonymous';
import NotFound from './components/NotFound';
import PrivateRoutes from './components/PrivateRoutes';
import BlogAdminCreate from './pages/admin/blog/BlogAdminCreate';
import BlogAdminDetail from './pages/admin/blog/BlogAdminDetail';
import BlogAdminList from './pages/admin/blog/BlogAdminList';
import CategoryAdminList from './pages/admin/category/CategoryAdminList';
import Login from './pages/admin/Login';
import UserAdminCreate from './pages/admin/user/UserAdminCreate';
import UserAdminDetail from './pages/admin/user/UserAdminDetail';
import UserAdminList from './pages/admin/user/UserAdminList';
import BlogDetail from './pages/anonymous/BlogDetail';
import BlogList from './pages/anonymous/BlogList';

function App() {
  return (
    <>
      <Routes>
        {/* Anonymous */}
        <Route path='/' element={<LayoutAnonymous />}>
          <Route index element={<BlogList />} />
          <Route path='blogs/:blogId/:slug' element={<BlogDetail />} />
        </Route>

        {/* Admin */}
        <Route path="/admin" element={<LayoutAdmin />}>
          <Route element={<PrivateRoutes />}>
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
              <Route path=':userId' element={<UserAdminDetail />} />
              <Route path='create' element={<UserAdminCreate />} />
            </Route>
          </Route>
        </Route>


        <Route path='/admin/login' element={<Login />} />
        <Route path='/not-found' element={<NotFound />} />
      </Routes>
    </>
  );
}

export default App;
