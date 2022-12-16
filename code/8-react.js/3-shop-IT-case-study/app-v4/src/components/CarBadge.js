import React from 'react';

import { useSelector } from 'react-redux';

function CarBadge({ }) {
    const cart = useSelector(state => state.cart)
    return (
        <div>
            <i className='fa fa-shopping-cart'></i>
            <span className='badge bg-danger'>{Object.keys(cart).length}</span>
            item(s) in cart
            <hr />
        </div>
    );
}

export default CarBadge;