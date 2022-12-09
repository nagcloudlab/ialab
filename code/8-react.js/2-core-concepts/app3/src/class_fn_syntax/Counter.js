import React, { Component } from 'react';

class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        }
    }
    handleEvent(v) {
        const { count } = this.state;
        this.setState({ count: count + v });
    }
    componentDidMount() {
        console.log("Counter:: componentDidMount");
        let { count } = this.state
        document.title = `the current count : ${count}`
    }
    componentDidUpdate() {
        let { count } = this.state
        document.title = `the current count : ${count}`
    }
    render() {
        const { count } = this.state
        return (
            <div className='card card-body'>
                <div className='d-flex justify-content-around'>
                    <button onClick={e => this.handleEvent(1)} className='btn btn-lg btn-dark'>+1</button>
                    <span className='display-2'>{count}</span>
                    <button onClick={e => this.handleEvent(-1)} className='btn btn-lg btn-dark'>-1</button>
                </div>
            </div>
        );
    }
}

export default Counter;