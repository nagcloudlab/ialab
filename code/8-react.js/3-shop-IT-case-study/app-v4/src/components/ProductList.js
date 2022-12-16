import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import Product from './Product';

function ProductList({ }) {

    const products = useSelector(state => state.products || [])

    return (
        <div>
            <div className="list-group">
                {products.map(product => (
                    <Product
                        key={product.id}
                        value={product}
                    />)
                )}
            </div>
        </div>
    );
}

export default ProductList;