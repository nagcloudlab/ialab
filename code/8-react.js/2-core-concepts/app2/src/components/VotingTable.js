import React, { Component } from 'react';

class VotingTable extends Component {
    render() {
        let { value: votes } = this.props;
        return (
            <div className='card card-body'>
                <table className='table table-bordered table-sm'>
                    <thead>
                        <tr>
                            <th>Item</th>
                            <th>Likes</th>
                            <th>Dislikes</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            Object.keys(votes).map((key, index) => {
                                let votingLine = votes[key]
                                let { likes, dislikes } = votingLine
                                return (
                                    <tr key={key} className={likes < dislikes ? 'bg-warning' : ''}>
                                        <td>{key}</td>
                                        <td>{likes}</td>
                                        <td>{dislikes}</td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default VotingTable;