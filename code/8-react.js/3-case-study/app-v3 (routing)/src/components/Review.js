import React from 'react';

const renderStarFont = (n) => {
    let stars = []
    for (let i = 0; i < n; i++) {
        stars.push(<i style={{ color: 'red', fontSize: '25px' }} key={i} className="fa fa-star" />)
    }
    return stars;
}

const Review = ({ value: review }) => {
    return (
        <div className="alert alert-danger">
            <span>{renderStarFont(review.stars)}</span> &mdash; <span>{review.author}</span>
            <hr />
            <div>{review.body}</div>
        </div>
    );
};

export default Review; 