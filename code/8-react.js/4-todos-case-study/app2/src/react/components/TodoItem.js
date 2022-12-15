import React from 'react';

import { useDispatch } from 'react-redux'

function TodoItem({ todo }) {

    const dispatch = useDispatch();

    return (
        <>
            <div className='d-flex justify-content-around'>
                <input
                    onChange={e => { }}
                    type='checkbox'
                    checked={todo.completed}
                    className='mr-2' />
                <div>{todo.title}</div>
                <div>{todo.completed ? 'completed' : 'pending'}</div>
                <button
                    className='btn btn-sm btn-danger'
                    onClick={e => dispatch({ type: 'DELETE_TODO', payload: { id: todo.id } })}>
                    delete
                </button>
            </div>
        </>
    );
}

export default TodoItem;