import React, { Component } from 'react';

class List extends Component {
    render() {
        let { value: items } = this.props;
        return (
            <ul className='list-group'>
                {
                    items.map((item, index) => {
                        return (<li key={index} className='list-group-item'>{item}</li>)
                    })
                }
            </ul>
        );
    }
}

export default List;