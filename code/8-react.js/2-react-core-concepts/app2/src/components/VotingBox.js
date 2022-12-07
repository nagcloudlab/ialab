import React, { Component } from 'react';
import VotingItem from './VotingItem';
import VotingTable from './VotingTable';

class VotingBox extends Component {

    state = {
        votes: {}
    }

    handleVoteEvent(e) {
        let { item, likes, dislikes } = e;
        let votes = this.state.votes;
        let votingLine = votes[item];
        if (votingLine) {
            votingLine.likes = likes;
            votingLine.dislikes = dislikes;
        } else {
            votingLine = { likes, dislikes }
        }
        votes[item] = votingLine;
        this.setState({ votes });
    }

    render() {
        let { votes } = this.state;
        let { items } = this.props
        return (
            <div className='card card-body'>
                <div className='d-flex flex-wrap justify-content-around'>
                    {
                        items.map((item, idx) => <VotingItem key={item} value={item} onKick={e => this.handleVoteEvent(e)} />)
                    }
                </div>
                <VotingTable value={votes} />
            </div>
        );
    }
}

export default VotingBox;