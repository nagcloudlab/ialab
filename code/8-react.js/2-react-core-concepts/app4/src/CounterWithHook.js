import React, { useState, useEffect } from 'react';


function CounterWithHook(props) {
    const [count, setCount] = useState(100)
    useEffect(() => {
        document.title = `count=${count}`
    }, [count])
    return (
        <div className='card card-body'>
            <div className='d-flex justify-content-around'>
                <button onClick={e => setCount(count + 1)} className='btn btn-lg btn-danger'>+1</button>
                <div className='display-2'>{count}</div>
                <button onClick={e => setCount(count - 1)} className='btn btn-lg btn-danger'>-1</button>
            </div>
        </div>
    )
}

export default CounterWithHook;