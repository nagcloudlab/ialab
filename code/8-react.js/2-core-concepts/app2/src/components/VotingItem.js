import React, { Component } from 'react';

class VotingItem extends Component {

    state = {
        vote: {
            likes: 0,
            dislikes: 0
        }
    }

    handleLikeEvent(event) {
        this.setState({
            vote: {
                ...this.state.vote,
                likes: this.state.vote.likes + 1,
            }
        }, () => {
            let { onKick, value: item } = this.props;
            let { likes, dislikes } = this.state.vote
            onKick({ item, likes, dislikes });
        });
    }

    handleDislikeEvent(event) {
        this.setState({
            vote: {
                ...this.state.vote,
                dislikes: this.state.vote.dislikes + 1,
            }
        }, () => {
            let { onKick, value: item } = this.props;
            let { likes, dislikes } = this.state.vote
            onKick({ item, likes, dislikes });
        });
    }

    render() {
        let { value } = this.props;
        let { likes, dislikes } = this.state.vote;
        return (
            <div style={{ width: '200px' }} className="m-2">
                <div className={`card card-body ${likes < dislikes ? 'bg-danger' : ''}`}>

                    <div className='d-flex'>
                        <div style={{ fontSize: '2em' }}>{value || 'Unknown'}</div>
                        <span style={
                            {
                                borderRadius: '50%',
                                width: '25px',
                                height: '25px',
                                textAlign: 'center', color: '#FFF'
                            }}
                            className='bg-danger'>{likes - dislikes}</span>
                    </div>
                    <hr />
                    <div className='d-flex justify-content-around'>
                        <button className='btn' onClick={e => this.handleLikeEvent(e)}>
                            <i className='fa fa-thumbs-up'></i>
                        </button>
                        <button className='btn' onClick={e => this.handleDislikeEvent(e)} >
                            <i className='fa fa-thumbs-down' style={{ color: '' }}></i>
                        </button>
                    </div>

                </div>
            </div >
        );
    }
}

export default VotingItem;