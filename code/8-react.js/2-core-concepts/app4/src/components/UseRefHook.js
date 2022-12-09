import React, { useEffect, useRef, useState } from 'react';


// note : Ref hold current rendered values for Next re-render as well

function UseRefHook(props) {

    // const [count, setCount] = useState(0)
    const countRef = useRef(1)
    const nameRef = useRef()
    const inpFieldRef = useRef()
    const [name, setName] = useState("")


    useEffect(() => {
        countRef.current = countRef.current + 1
    },)

    useEffect(() => {
        nameRef.current = name
    }, [name])

    const handleFocus = e => {
        // console.log(inpFieldRef.current);
        inpFieldRef.current.focus()
    }

    return (
        <div>
            <div className='card'>
                <div className='card-header'>{"Use Ref"}</div>
                <div className='card-body'>
                    <hr />
                    <button onClick={handleFocus}>focus name field</button>
                    <hr />
                    <input ref={inpFieldRef} onChange={e => setName(e.target.value)} />
                    <hr />
                    Name : {name} , PrevName: {nameRef.current}
                    <hr />
                    <div>Rendered count : {countRef.current}</div>
                    <hr />
                </div>
            </div>
        </div>
    );
}

export default UseRefHook;