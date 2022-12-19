import React, { useEffect } from 'react';

import { useSelector, useDispatch } from 'react-redux'
import { fetchFeedbacksAsync } from '../feedbacks/feedbacksSlice'

function Feebacks(props) {

    const feebacks = useSelector(state => state.feedbacks.value || [])
    const dispatch = useDispatch()

    useEffect(() => {
        console.log("useEffect")
        dispatch(fetchFeedbacksAsync())
    }, [])

    const renderFeedbacks = () => {
        return feebacks.map((feeback, index) => {
            return (
                <div key={index}>
                    <div className='alert alert-info'>
                        {feeback.name} | {feeback.trainerName}
                        <br />
                        {feeback.feedback}
                    </div>
                </div>
            )
        })
    }

    return (
        <div className='display-3'>
            {renderFeedbacks()}
        </div>
    );
}

export default Feebacks;