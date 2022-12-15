import React, { useState } from 'react';
import VotingItem from './VotingItem';
import VotingTable from './VotingTable';

function VotingBox(props) {

    const [votes, setVotes] = useState({});

    const handleVoteEvent = e => {

        let { item, action } = e
        if (action === 'likes') {
            let votingLine = votes[item] || {}
            votingLine = { ...votingLine, likes: (votingLine.likes || 0) + 1 }
            setVotes({ ...votes, [item]: votingLine })
        }
        if (action === 'dislikes') {
            let votingLine = votes[item] || {}
            votingLine = { ...votingLine, dislikes: (votingLine.dislikes || 0) + 1 }
            setVotes({ ...votes, [item]: votingLine })
        }

    }

    return (
        <div className='card card-body'>
            <div className='d-flex'>
                <VotingItem
                    value="foo"
                    votingLine={votes['foo'] || {}}
                    onVote={e => handleVoteEvent(e)} />
                <VotingItem
                    value="bar"
                    votingLine={votes['bar'] || {}}
                    onVote={e => handleVoteEvent(e)} />
            </div>
            <VotingTable
                value={votes}
                onVote={e => handleVoteEvent(e)} />
        </div >
    );
}

export default VotingBox;