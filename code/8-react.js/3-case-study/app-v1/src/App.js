


function App() {

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
              <div>{product.description}</div>
              <button className="btn btn-sm btn-dark">Buy</button>
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
