import React from 'react';

function List({ value = [] }) {

    const renderItems = () => {
        return value.map((item, index) => {
            return <li className='list-group-item' key={index}>{item}</li>
        })
    }

    return (
        <div className='card card-body'>
            <ul className='list-group'>
                {renderItems()}
            </ul>
        </div>
    );
}

export default List;