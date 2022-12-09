import React, { Component } from 'react';
import B from './B'

class A extends Component {
    render() {
        return (
            <div className='card card-body'>
                A component
                <B />
            </div>
        );
    }
}

export default A;