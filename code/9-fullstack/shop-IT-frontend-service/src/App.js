import React, { useState } from 'react'
import CarBadge from './components/CarBadge';
import CartView from './components/CartView';
import Header from './components/Header';
import ProductList from './components/ProductList';

import {
  BrowserRouter as Router,
  Route,
  Switch,
  Link,
} from "react-router-dom";
import Home from './components/Home';



function App() {
  return (
    <div className="container">

      <Header title={"shopIT"} />
      <CarBadge />
      <Router>
        <div>
          <ul className="nav nav-pills">
            <li className="nav-item">
              <Link
                className="nav-link" to="/">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link
                className="nav-link" to="/products">
                Products
              </Link>
            </li>
            <li className="nav-item">
              <Link
                className="nav-link" to="/cart">
                Cart
              </Link>
            </li>
          </ul>
          <hr />
          <Switch>
            <Route path="/" exact={true} component={Home} />
            <Route path="/products" render={props => <ProductList />} />
            <Route path="/cart" render={props => <CartView />} />
          </Switch>
        </div>
      </Router>

    </div>
  );
}

export default App;
