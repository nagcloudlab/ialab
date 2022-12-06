import React from 'react'

class Message extends React.PureComponent {

    constructor(props) {
        super(props);
        console.log("Message :: constructor");
    }

    render() {
        console.log("Message :: render");
        let { value } = this.props
        return (
            <div className='card'>
                <div className='card-header bg-info'>Message</div>
                <div className='card-body'>
                    {value}
                    <hr />
                    <span className='badge bg-danger'>
                        {new Date().toLocaleTimeString('en-US', { timeZone: 'Asia/Kolkata' })}
                    </span>
                </div>
            </div>
        )
    }

    componentDidMount() {
        console.log("Message :: componentDidMount");
        this._interval = setInterval(() => {
            console.log("tick");
            this.forceUpdate()
        }, 1000);
    }

    // shouldComponentUpdate(nextProps, nextState) {
    //     console.log("Message :: shouldComponentUpdate");
    //     return this.props.value !== nextProps.value;
    // }

    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log("Message :: componentDidUpdate");
    }

    componentWillUnmount() {
        clearInterval(this._interval)
        console.log("Message :: componentWillUnmount");
    }

}

export default Message;