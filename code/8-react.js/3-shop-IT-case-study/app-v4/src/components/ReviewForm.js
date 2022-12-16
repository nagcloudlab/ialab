import React, { useState } from 'react';

function ReviewForm({ onNewReview }) {
    const [open, setOpen] = useState(false)
    const [review, setReview] = useState({
        stars: 1,
        body: '',
        author: ''
    })

    const handleSubmit = (e) => {
        e.preventDefault();
        onNewReview(review)
        setReview({
            stars: 1,
            body: '',
            author: ''
        })
        setOpen(false)
    }


    if (open)
        return (
            <div className='card'>
                <div className='card-header'>ReviewForm</div>
                <div className='card-body'>
                    <form onSubmit={e => handleSubmit(e)}>
                        <div className='form-group'>
                            <label>author</label>
                            <input className='form-control'
                                value={review.author}
                                onChange={e => setReview({ ...review, author: e.target.value })} />
                        </div>
                        <div className='form-group'>
                            <label>stars</label>
                            <select className='form-control'
                                value={review.stars}
                                onChange={e => setReview({ ...review, stars: e.target.value })}>
                                {[1, 2, 3, 4, 5].map(i => <option key={i} value={i}>{i}</option>)}
                            </select>
                        </div>
                        <div className='form-group'>
                            <label>body</label>
                            <textarea className='form-control'
                                value={review.body}
                                onChange={e => setReview({ ...review, body: e.target.value })}></textarea>
                        </div>
                        <br />
                        <div className='d-flex'>
                            <button type='button' onClick={e => setOpen(false)} className='btn btn-danger'>cancel</button>
                            <button className='btn btn-primary'>submit</button>
                        </div>
                    </form>
                </div>
            </div>
        );
    else
        return <button onClick={e => setOpen(true)} className='btn btn-sm btn-dark'><i className='fa fa-plus'></i></button>
}

export default ReviewForm;