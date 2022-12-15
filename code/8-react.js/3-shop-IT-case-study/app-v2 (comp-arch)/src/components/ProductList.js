import React, { useState } from 'react';
import CarBadge from './CarBadge';
import Product from './Product';

function ProductList({ onBuy }) {

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


    return (
        <div>
            <div className="list-group">
                {products.map(product => (
                    <Product
                        key={product.id}
                        value={product}
                        onBuy={onBuy} />)
                )}
            </div>
        </div>
    );
}

export default ProductList;