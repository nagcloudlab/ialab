import React from 'react';
import { useDispatch, useSelector } from 'react-redux';

function CartView({ }) {
    const cart = useSelector(state => state.cart);
    const dispatch = useDispatch()

    const handleCartQty = (item, qty) => {
        dispatch({
            type: 'ADD_TO_CART',
            payload: {
                item: item,
                qty: qty
            }
        })
    }

    const renderCartItems = () => {
        return Object.keys(cart).map((key, index) => {
            let itemLine = cart[key]
            let { item, quantity } = itemLine
            return (
                <tr key={index}>
                    <td>{item.name}</td>
                    <td>&#8377;{item.price}</td>
                    <td>
                        <div className='d-flex justify-content-around'>
                            <button onClick={e => handleCartQty(item, 1)}>
                                <i className='fa fa-plus'></i>
                            </button>
                            <span>{quantity}</span>
                            <button onClick={e => handleCartQty(item, -1)}>
                                <i className='fa fa-minus'></i>
                            </button>
                        </div>
                    </td>
                    <td>&#8377;{item.price * quantity}</td>
                </tr>
            )
        })
    }

    return (
        <div className='card'>
            <div className='card-header'>Item(s) in cart</div>
            <div className='card-body'>
                <table className='table table-bordered'>
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