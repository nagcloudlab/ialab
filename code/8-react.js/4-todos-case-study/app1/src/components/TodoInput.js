import React from 'react';

function TodoInput({ onNewTodo }) {
    const handleKeyUp = e => {
        let { keyCode, target: { value } } = e;
        if (keyCode !== 13)
            return
        if (value) {
            onNewTodo(value);
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