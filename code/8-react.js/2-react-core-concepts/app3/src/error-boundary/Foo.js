import React, { Component } from 'react';

class Foo extends Component {
    render() {
        return (
            <div className='card card-body'>
                Foo
                {
                    this.props.title.toUpperCase()
                }
            </div>
        );
    }
}

export default Foo;    