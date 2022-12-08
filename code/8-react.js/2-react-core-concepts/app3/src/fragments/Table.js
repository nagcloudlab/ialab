import React, { Component } from 'react';
import Columns from './Columns';

class Table extends React.Component {
    render() {
        return (
            <table className='table'>
                <tbody>
                    <tr>
                        <Columns />
                    </tr>
                </tbody>
            </table>
        );
    }
}

export default Table;