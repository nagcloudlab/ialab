import React from 'react';

function TodoItem({ todo, onDelete, onComplete }) {
    return (
        <>
            <div className='d-flex justify-content-around'>
                <input
                    onChange={e => onComplete(todo.id)}
                    type='checkbox'
                    checked={todo.completed}
                    className='mr-2' />
                <div>{todo.title}</div>
                <div>{todo.completed ? 'completed' : 'pending'}</div>
                <button
                    className='btn btn-sm btn-danger'
                    onClick={e => onDelete(todo.id)}
                >
                    delete
                </button>
            </div>
        </>
    );
}

export default TodoItem;