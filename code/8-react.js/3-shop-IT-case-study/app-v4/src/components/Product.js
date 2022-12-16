import React, { useState } from 'react';
import classNames from 'classnames';
import Review from './Review';
import ReviewForm from './ReviewForm';

import { useDispatch, useSelector } from 'react-redux'


function Product({ value: product }) {

    const dispatch = useDispatch();
    const [cart, reviews = []] = useSelector(state => [state.cart, state.reviews[product.id]])

    const [tab, setTab] = useState(1);


    const handleNewReview = rev => {
        let action = { type: 'ADD_TO_REVIEWS', payload: { review: rev, itemId: product.id } }
        dispatch(action);
    }

    const handleBuy = () => {
        let action = { type: "ADD_TO_CART", payload: { item: product } }
        dispatch(action);
    }

    const renderReviews = () => {
        return reviews.map((review, index) => {
            return (
                <Review value={review} key={index} />
            )
        })
    }
    const renderTabPane = (product) => {
        switch (tab) {
            case 1: return (<div>{product.description}</div>)
            case 2: return (<div>{"Not Yet"}</div>)
            case 3: return (<div>{renderReviews()}<ReviewForm onNewReview={review => handleNewReview(review)} /></div>)
        }
    }

    const renderProduct = product => {
        if (product.isAvailable) {
            const cartLine = cart[product.id] || {}
            let { quantity = 0 } = cartLine
            return (
                <div key={product.id} className="list-group-item">
                    <div className="row">
                        <div className="col-sm-4 col-md-4">
                            <img className="img-fluid" src={product.imageUrl} alt={product.name} />
                        </div>
                        <div className="col-sm-8 col-md-8">
                            <div className='d-flex justify-content-around'>
                                <div>
                                    <div>{product.name}</div>
                                    <div>&#8377;{product.price}</div>
                                    <button onClick={handleBuy} className="btn btn-sm btn-dark">Buy</button>
                                </div>
                                <div>
                                    {quantity} quantity cart
                                </div>
                            </div>
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
        <div>
            {renderProduct(product)}
        </div>
    );
}

export default Product;