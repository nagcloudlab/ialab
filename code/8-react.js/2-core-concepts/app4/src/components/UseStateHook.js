import React, { useState } from 'react';



function UseStateHook(props) {
    console.log("UseStateHook :: render()");

    // const [c, setC] = useState(100)
    const [c, setC] = useState(() => {
        console.log("computing intial count...");
        return 100 + 100.00
    })


    const handleCount = i => setC(c + i)
    const handleCountFiveTimes = e => {
        for (let i = 1; i <= 5; i++) {
            setC(prevState => prevState + i);
        }
    }

    const [user, setUser] = useState({ name: "Nag", age: 39 })


    return (
        <div className='card'>
            <div className='card-body'>
                <div className='d-flex justify-content-around'>
                    <button onClick={e => handleCount(1)} className='btn btn-lg btn-primary'>+1</button>
                    <button onClick={e => handleCountFiveTimes()} className='btn btn-lg btn-primary'>increment 5 times</button>
                    <div className='display-1'>{c}</div>
                    <button onClick={e => handleCount(-1)} className='btn btn-lg btn-primary'>-1</button>
                </div>
                <hr />
                <button className='btn btn-lg btn-warning' onClick={e => setUser({ ...user, age: user.age + 1 })}>Increment Age by +1</button>
                <hr />
                Name : {user.name} , age : {user.age}
            </div>
        </div >
    );
}

export default UseStateHook;