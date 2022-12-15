import React from 'react';

import { useDispatch } from 'react-redux'


function TodoInput({ }) {

    const dispatch = useDispatch();

    const handleKeyUp = e => {
        let { keyCode, target: { value } } = e;
        if (keyCode !== 13) return;
        if (value) {
            let action = { type: 'ADD_TODO', payload: { title: value } }
            dispatch(action);
            e.target.value = "";
        }
    }
    return (
        <div className='card card-body'>
            <div className="input-group input-group-lg">
                <input
                    autoFocus
                    onKeyUp={e => handleKeyUp(e)}
                    type="text"
                    className="form-control" />
            </div>
        </div>
    );
}

export default TodoInput;