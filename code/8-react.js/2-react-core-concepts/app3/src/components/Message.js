import React, { Component } from 'react';

// class Message extends Component {
//     render() {
//         let { value } = this.props
//         return (
//             <div className='alert alert-info'>
//                 {value}
//             </div>
//         );
//     }
// }

// or

function Message(props) {
    return (
        <div className='alert alert-info'>
            {props.value}
        </div>
    );
}

export default Message;


