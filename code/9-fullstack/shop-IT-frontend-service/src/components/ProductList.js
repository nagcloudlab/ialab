import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import Product from './Product';

import { loadProducts } from '../actions/products'

function ProductList({ }) {

    const products = useSelector(state => state.products || [])
    const dispatch = useDispatch()

    useEffect(() => {
        dispatch(loadProducts())
    }, [])

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