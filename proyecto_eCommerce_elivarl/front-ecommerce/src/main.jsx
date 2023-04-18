import React from 'react'
import ReactDOM from 'react-dom/client'

import 'bootstrap/dist/css/bootstrap.min.css'

import App from './App'

// Acceso general
import DetalleOrden from './pages/administrador/DetalleOrden'
import Home from './pages/administrador/Home'
import Ordenes from './pages/administrador/Ordenes'
import Usuarios from './pages/administrador/Usuarios'

// Solo acceso al usuario ADMIN
import Create from './pages/productos/Create'
import Edit from './pages/productos/Edit'
import Show from './pages/productos/Show'

// Acceso a usuarios registrados
import Carrito from './pages/usuario/Carrito'
import Compras from './pages/usuario/Compras'
import DetalleCompra from './pages/usuario/DetalleCompra'
import HomeUsuario from './pages/usuario/HomeUsuario'
import Login from './pages/usuario/Login'
import ProductoHome from './pages/usuario/ProductoHome'
import Registro from './pages/usuario/Registro'
import ResumenOrden from './pages/usuario/ResumenOrden'


import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";


const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/detalleOrden",
    element: <DetalleOrden />,
  },
  {
    path: "/ordenes",
    element: <Ordenes />,
  },
  {
    path: "/usuarios",
    element: <Usuarios />,
  },
  {
    path: "/create",
    element: <Create />,
  },
  {
    path: "/edit",
    element: <Edit />,
  },
  {
    path: "/show",
    element: <Show />,
  },

  {
    path: "/carrito",
    element: <Carrito />,
  },
  {
    path: "/compras",
    element: <Compras />,
  },
  {
    path: "/detalleCompra",
    element: <DetalleCompra />,
  },
  {
    path: "/usuario",
    element: <HomeUsuario />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/producto",
    element: <ProductoHome />,
  },
  {
    path: "/registro",
    element: <Registro />,
  },
  {
    path: "/resumenOrden",
    element: <ResumenOrden />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <RouterProvider router={router} />
  </React.StrictMode>,
)
