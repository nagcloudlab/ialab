import React, { useState, useReducer } from 'react';

function VotingItem({ value, votingLine, onVote }) {

    const handleLikeEvent = e => {
        // console.log(e);
        onVote({ item: value, action: 'likes' })
    }
    const handleDislikeEvent = e => {
        // console.log(e);
        onVote({ item: value, action: 'dislikes' })
    }

    return (
        <div className='card card-body m-2'>
            <div className='d-flex justify-content-around'>
                <div className='display-3'>{value}</div>
                <span className='display-3 text-primary'>{ }</span>
            </div>
            <hr />
            <div className='d-flex justify-content-around'>
                <span>{votingLine.likes} likes</span>
                <span>{votingLine.dislikes} dislikes</span>
            </div>
            <hr />
            <div className='d-flex'>
                <button
                    className='btn btn-success'
                    onClick={e => handleLikeEvent(e)}
                >
                    Like
                </button>
                <button
                    className='btn btn-danger'
                    onClick={e => handleDislikeEvent(e)}
                >
                    Disike
                </button>
            </div>
        </div >
    );
}

export default VotingItem;