import React from 'react';

function CarBadge({ value }) {
    return (
        <div>
            <i className='fa fa-shopping-cart'></i>
            <span className='badge bg-danger'>{value}</span>
            item(s) in cart
            <hr />
        </div>
    );
}

export default CarBadge;