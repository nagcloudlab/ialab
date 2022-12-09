import React, { useReducer } from 'react';

function reducer(state, action) {
    console.log("reducer()", state, action);
    let { type, payload } = action;
    switch (type) {
        case 'INCREMENT':
            return { ...state, count: state.count + payload };
            break;
        case 'DECREMENT':
            return { ...state, count: state.count - payload };
            break;
        default:
            return state;
    }
}

function UseReducerHook(props) {
    const [state, dispatch] = useReducer(reducer, { count: 200 });
    return (
        <div className='card card-body'>
            <div className='d-flex justify-content-between flex-wrap'>
                <button type='button' className='btn btn-dark' onClick={e => dispatch({ type: 'INCREMENT', payload: 1 })}>+1</button>
                <button type='button' className='btn btn-dark' onClick={e => dispatch({ type: 'DECREMENT', payload: 1 })}>-1</button>
                <button type='button' className='btn btn-dark' onClick={e => dispatch({ type: 'INCREMENT', payload: 10 })}>+10</button>
                <button type='button' className='btn btn-dark' onClick={e => dispatch({ type: 'INCREMENT', payload: 20 })}>+20</button>
                <button type='button' className='btn btn-dark' onClick={e => dispatch({ type: 'DECREMENT', payload: 50 })}>-50</button>
            </div>
            <hr />
            Total Count : <span className='display-6'>{state.count}</span>
            <hr />
        </div>
    );
}

export default UseReducerHook;