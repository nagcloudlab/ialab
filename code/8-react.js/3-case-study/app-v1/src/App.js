import React, { useState } from 'react'
import classNames from 'classnames';


function App() {

  const [tab, setTab] = useState(1);


  const products = [
    {
      id: 1,
      name: "Product 1",
      price: 100,
      description: "Product Description",
      isAvailable: true,
      imageUrl: "images/Laptop.png"
    },
    {
      id: 2,
      name: "Product 2",
      price: 200,
      description: "Product Description",
      isAvailable: true,
      imageUrl: "images/Mobile.png"
    }
  ]

  const renderTabPane = (product) => {
    switch (tab) {
      case 1: return (<div>{product.description}</div>)
      case 2: return (<div>{"Not Yet"}</div>)
      case 3: return (<div>{"None Yet"}</div>)
    }
  }

  const renderProduct = product => {
    if (product.isAvailable) {
      return (
        <div key={product.id} className="list-group-item">
          <div className="row">
            <div className="col-sm-4 col-md-4">
              <img className="img-fluid" src={product.imageUrl} alt={product.name} />
            </div>
            <div className="col-sm-8 col-md-8">
              <div>{product.name}</div>
              <div>&#8377;{product.price}</div>
              <button className="btn btn-sm btn-dark">Buy</button>
              <br /><br />
              <ul className="nav nav-tabs">
                <li className="nav-item">
                  <a className={classNames({ 'nav-link': true, active: tab === 1 })} href="#" onClick={e => setTab(1)}>Description</a>
                </li>
                <li className="nav-item">
                  <a className={classNames({ 'nav-link': true, active: tab === 2 })} href="#" onClick={e => setTab(2)}>Specification</a>
                </li>
                <li className="nav-item">
                  <a className={classNames({ 'nav-link': true, active: tab === 3 })} href='#' onClick={e => setTab(3)}>Reviews</a>
                </li>
              </ul>
              <br />
              {renderTabPane(product)}
            </div>
          </div>
        </div>
      )
    }
  }

  return (
    <div className="">
      <div className="display-1">shopIT</div>
      <hr />
      <div className="container">
        <div className="list-group">
          {products.map(product => renderProduct(product))}
        </div>
      </div>
    </div>
  );
}

export default App;
