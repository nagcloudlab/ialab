import React from 'react';

import 'bootstrap/dist/css/bootstrap.css';

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Login from './features/user/Login';
import Todos from './features/todos/Todos';

const router = createBrowserRouter([
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/todos",
    element: <Todos />,
  },
]);

function App() {
  return (
    <div className="container">
      <div className='display-1'>todos</div>
      <hr />
      <RouterProvider router={router} />
    </div>
  );
}

export default App;
