import React, { useState } from 'react';
import classNames from 'classnames';
import Review from './Review';


function Product({ value: product, onBuy }) {

    const [tab, setTab] = useState(1);


    const reviews = [
        {
            stars: 3,
            body: 'sample review-1 ',
            author: 'John Doe'
        },
        {
            stars: 4,
            body: 'sample review-2 ',
            author: 'John Doe'
        }
    ]

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
            case 3: return (<div>{renderReviews()}</div>)
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
                            <button onClick={e => onBuy(product)} className="btn btn-sm btn-dark">Buy</button>
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