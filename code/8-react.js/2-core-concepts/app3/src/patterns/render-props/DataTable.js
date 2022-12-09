
import React from 'react';

function DataTable(props) {
    return (
        <div className='card'>
            <div className='card-header'>Data Table</div>
            <div className='card-body'>
                <table className='table'>
                    <thead>
                        <tr>
                            {props.columns.map((column, i) => {
                                return (
                                    <th key={i}>{column}</th>
                                )
                            })}
                        </tr>
                    </thead>
                    <tbody>
                        {
                            props.data.map((item, i) => props.r(item))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default DataTable;