import { ReactNode } from 'react';
import { Navigate } from 'react-router-dom';

interface IProtectedRouteProps {
    isAuthenticated: boolean; 
    redirectPath: string;
    children?: ReactNode;
}

export const ProtectedRoute: React.FC<IProtectedRouteProps> = ({ isAuthenticated, redirectPath, children  }) => {
    return (!isAuthenticated) ? <Navigate to={redirectPath} replace /> : children 
};
