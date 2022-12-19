import React, { useState } from 'react';

import { useDispatch } from 'react-redux'
import { postFeedbacksAsync } from './feedbacksSlice'

function FeedbackForm(props) {
    const [feedback, setFeedback] = useState({ name: '', trainerName: '', feedback: '' })
    const dispatch = useDispatch()

    const handleSubmit = e => {
        e.preventDefault();
        dispatch(postFeedbacksAsync(feedback))
        setFeedback({ name: '', trainerName: '', feedback: '' })
    }
    return (
        <div>
            <form onSubmit={e => handleSubmit(e)}>
                <div className="form-group">
                    <label className="text-muted">Name</label>
                    <input value={feedback.name} onChange={e => setFeedback({ ...feedback, name: e.target.value })} type="text" className="form-control" name="name" />
                </div>
                <div className="form-group">
                    <label className="text-muted">TrainerName</label>
                    <input value={feedback.trainerName} onChange={e => setFeedback({ ...feedback, trainerName: e.target.value })} type="text" className="form-control" name="trainerName" />
                </div>
                <div className="form-group">
                    <label className="text-muted">Fedback</label>
                    <textarea value={feedback.feedback} onChange={e => setFeedback({ ...feedback, feedback: e.target.value })} type="text" className="form-control" name="feedback" />
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>

        </div>
    );
}

export default FeedbackForm;