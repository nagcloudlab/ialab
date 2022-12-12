import React, { useState } from 'react'
import CarBadge from './components/CarBadge';
import CartView from './components/CartView';
import Header from './components/Header';
import ProductList from './components/ProductList';


function App() {
  const [isCartOpen, setCartOpen] = useState(false)
  const [cart, setCart] = useState({})
  const addToCart = item => {
    let { id } = item
    let itemLine = cart[id]
    if (itemLine) {
      itemLine.quantity += 1
    }
    else {
      itemLine = {
        item, quantity: 1
      }
    }
    setCart(cart => ({ ...cart, [id]: itemLine }))
  }
  return (
    <div className="container">
      <Header title={"shopIT"} />
      <ul class="nav nav-pills">
        <li class="nav-item">
          <a
            onClick={e => setCartOpen(!isCartOpen)}
            class="nav-link" href="#">
            {isCartOpen ? 'Products' : 'Cart'}
          </a>
        </li>
      </ul>
      <hr />
      <CarBadge value={Object.keys(cart).length} />
      {isCartOpen ? <CartView value={cart} /> : null}
      {isCartOpen ? null : <ProductList onBuy={product => addToCart(product)} />}
    </div>
  );
}

export default App;
