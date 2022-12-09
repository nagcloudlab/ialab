import React, { Component } from 'react';
import ErrorBoundary from './ErrorBoundary';
import Foo from './Foo';

class Box extends Component {
    render() {
        return (
            <div className='card card-body'>
                <ErrorBoundary>
                    <Foo title="react" />
                </ErrorBoundary>
            </div>
        );
    }
}

export default Box;