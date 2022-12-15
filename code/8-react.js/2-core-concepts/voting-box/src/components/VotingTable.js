import React from 'react';

function VotingTable({ value, onVote }) {
    return (
        <div className='card card-body'>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Likes</th>
                        <th>Dislikes</th>
                    </tr>
                </thead>
                <tbody>
                    {Object.keys(value).map((item, index) => {
                        let votingLine = value[item];
                        let { likes, dislikes } = votingLine;
                        return (
                            <tr key={index}>
                                <td>{item}</td>
                                <td>{likes} <button onClick={e => onVote({ item, action: 'likes' })} className='btn btn-sm btn-success'>+</button></td>
                                <td>{dislikes} <button onClick={e => onVote({ item, action: 'dislikes' })} className='btn btn-sm btn-danger'>-</button></td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </div >
    );
}

export default VotingTable;