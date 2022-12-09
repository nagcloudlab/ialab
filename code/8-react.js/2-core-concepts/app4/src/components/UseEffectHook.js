import React, { useEffect, useState } from 'react';

function UseEffectHook(props) {
    const [data, setData] = useState([]);
    const [resourceType, setResourceType] = useState(null)

    useEffect(() => {
        console.log("useEffect-1");
        if (resourceType)
            fetch(`https://jsonplaceholder.typicode.com/${resourceType}`)
                .then(res => res.json())
                .then(data => setData(data))
                .catch(err => console.log(err))
    }, [resourceType])

    useEffect(() => {
        console.log("useEffect-2");
    }, [])

    useEffect(() => {
        console.log("useEffect-3");
        document.title = `resource - ${resourceType}`
    })

    return (
        <div className='card'>
            <div className='card-body'>
                <div className='d-flex justify-content-around'>
                    <hr />
                    <button onClick={e => setResourceType('users')} className='btn btn-lg btn-dark'>Users</button>
                    <button onClick={e => setResourceType('todos')} className='btn btn-lg btn-dark'>Todos</button>
                    <button onClick={e => setResourceType('photos')} className='btn btn-lg btn-dark'>Photos</button>
                </div>
                <hr />
                {resourceType}
                <hr />
                <pre>
                    {JSON.stringify(data, null, 2)}
                </pre>
                <hr />
            </div>
        </div>
    );
}

export default UseEffectHook;