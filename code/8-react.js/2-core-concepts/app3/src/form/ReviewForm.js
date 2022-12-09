import React, { Component } from 'react';

class ReviewForm extends Component {

    constructor(props) {
        super(props);
        // // this.handleSubmit = this.handleSubmit.bind(this);
        // this.name = React.createRef();
        // this.stars = React.createRef();
        // this.body = React.createRef();
        this.state = {
            name: '',
            stars: '5',
            body: ''
        };
    }

    handleEvent(e) {
        e.preventDefault();
        // let newReview = {
        //     name: this.name.current.value,
        //     stars: this.stars.current.value,
        //     body: this.body.current.value
        // }
        let newReview = {
            name: this.state.name,
            stars: this.state.stars,
            body: this.state.body
        }
        console.log(newReview);
    }

    handleChange(e) {
        let { target } = e
        let { name, value } = target
        this.setState({
            [name]: value
        })
    }

    render() {
        let { name, stars, body } = this.state
        return (
            <div className='row'>
                <div className='col-6'>
                    <form onSubmit={e => this.handleEvent(e)}>
                        <div className='card'>
                            <div className='card-header'>
                                Review Form
                            </div>
                            <div className='card-body'>
                                <div className='form-group'>
                                    <label>Email/Name</label>
                                    <input
                                        type='text'
                                        className='form-control' /*ref={this.name}*/ value={name} name="name" onChange={e => this.handleChange(e)} />
                                </div>
                                <div className='form-group'>
                                    <label>Stars</label>
                                    <select className='form-control' /*ref={this.stars}*/ value={stars} name="stars" onChange={e => this.handleChange(e)}>
                                        {[1, 2, 3, 4, 5].map(n => <option key={n}>{n}</option>)}
                                    </select>
                                </div>
                                <div className='form-group'>
                                    <label>Body</label>
                                    <textarea className='form-control' /*ref={this.body}*/ value={body} name="body" onChange={e => this.handleChange(e)}></textarea>
                                </div>
                                <button disabled={stars < 3} className='mt-2 btn btn-dark'>Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default ReviewForm;