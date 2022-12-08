


import React from 'react';


function Bar() {
    return (
        <div className='card card-body'>
            im Bar
        </div>
    )
}

function Foo(props) {
    //return React.createElement('div', { className: "card card-body" }, "im Foo")
    return (
        <div className='card card-body'>
            im Foo
            {null}
            <Bar />
        </div>
    )
}


export default Foo;