import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

import Header from './component/Header'
import Footer from './component/Footer'

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
    path: "/login",
    element: <Login />,
  },
  {
    path: "/registro",
    element: <Registro />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <Header />
      <RouterProvider router={router} />
      <Footer />
  </React.StrictMode>,
)
