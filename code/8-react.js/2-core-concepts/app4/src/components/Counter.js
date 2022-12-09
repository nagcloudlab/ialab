import React, { Component } from 'react';

class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 100
        }
        // this.handlePlusOne = this.handlePlusOne.bind(this)
        // this.handleMinusOne = this.handleMinusOne.bind(this)
    }
    componentDidMount() {
        document.title = `count=${this.state.count}`
    }
    componentDidUpdate() {
        document.title = `count=${this.state.count}`
    }
    handlePlusOne() {
        this.setState({ count: this.state.count + 1 })
    }
    handleMinusOne() {
        this.setState({ count: this.state.count - 1 })
    }
    render() {
        let { count } = this.state
        return (
            <div className='card card-body'>
                <div className='d-flex justify-content-around'>
                    <button onClick={e => this.handlePlusOne()} className='btn btn-lg btn-dark'>+1</button>
                    <div className='display-2'>{count}</div>
                    <button onClick={e => this.handleMinusOne()} className='btn btn-lg btn-dark'>-1</button>
                </div>
            </div>
        );
    }
}

export default Counter;