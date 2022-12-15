import React from 'react';

function CartView({ value: cart }) {

    const renderCartItems = () => {
        return Object.keys(cart).map((key, index) => {
            let itemLine = cart[key]
            let { item, quantity } = itemLine
            return (
                <tr key={index}>
                    <td>{item.name}</td>
                    <td>&#8377;{item.price}</td>
                    <td>{quantity}</td>
                    <td>&#8377;{item.price * quantity}</td>
                </tr>
            )
        })
    }

    return (
        <div className='card'>
            <div className='card-header'>Item(s) in cart</div>
            <div className='card-body'>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Qty</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        {renderCartItems()}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default CartView;