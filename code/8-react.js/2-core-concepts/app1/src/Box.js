import React, { Component } from 'react';
import Veg from './Veg';

class Box extends Component {
    render() {
        return (
            <div className='card card-body bg-secondary'>
                <ul className='list-group'>
                    {
                        this.props.children.map((child, index) => {
                            return (
                                <li className='list-group-item' key={index}>{child}</li>
                            )
                        })
                    }
                </ul>
            </div>
        );
    }
}

export default Box;