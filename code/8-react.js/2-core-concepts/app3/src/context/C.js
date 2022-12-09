import React, { Component } from 'react';
import UserContext from './UserContext';

class C extends Component {
    render() {
        return (
            <div className='card card-body'>
                C component,
                <hr />
                <span>Hello :
                    <UserContext.Consumer>
                        {
                            (value) => {
                                return value
                            }
                        }
                    </UserContext.Consumer>
                </span>
            </div>
        );
    }
}

export default C;