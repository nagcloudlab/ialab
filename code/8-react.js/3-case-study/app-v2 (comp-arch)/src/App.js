import React, { useState } from 'react'
import CarBadge from './components/CarBadge';
import Header from './components/Header';
import ProductList from './components/ProductList';


function App() {
  const [cart, setCart] = useState([])
  return (
    <div className="">
      <Header title={"shopIT"} />
      <CarBadge value={cart.length} />
      <div className="container">
        <ProductList onBuy={product => setCart([product, ...cart])} />
      </div>
    </div>
  );
}

export default App;
