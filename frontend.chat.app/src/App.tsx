import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { LoginPage } from './pages/login/LoginPage'; // Asumiendo que tienes un componente para el login
import { HomePage } from './pages/home/Home'; // El componente que quieres proteger
import { ProtectedRoute } from './routes/Route'; // El componente ProtectedRoute
import { useSelector } from 'react-redux';


function App() {
  
  const isUserAuth: boolean = useSelector((state:any) => state.authCorrect.auth)

  return (
    <BrowserRouter>
      <Routes>
        {/* Public */}
        <Route path="/login" element={<LoginPage />} />

        {/* Private */}
        <Route path="/home" element={
          <ProtectedRoute isAuthenticated={isUserAuth} redirectPath="/login">
            <HomePage />
          </ProtectedRoute>
        } />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
