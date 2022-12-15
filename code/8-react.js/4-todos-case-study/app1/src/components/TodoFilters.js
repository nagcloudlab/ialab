import React from 'react';

function TodoFilters({ currentFilter, onChange }) {
    return (
        <div className='mt-3 d-flex justify-content-around'>
            <ul className="nav nav-pills">
                <li className="nav-item">
                    <a
                        onClick={e => onChange('all')}
                        className={`nav-link ${currentFilter === 'all' ? 'active' : ''}`} href="#">All</a>
                </li>
                <li className="nav-item">
                    <a
                        onClick={e => onChange('active')}
                        className={`nav-link ${currentFilter === 'active' ? 'active' : ''}`} href="#">Active</a>
                </li>
                <li className="nav-item">
                    <a
                        onClick={e => onChange('completed')}
                        className={`nav-link ${currentFilter === 'completed' ? 'active' : ''}`} href="#">Completed</a>
                </li>
            </ul>
        </div>
    );
}
export default TodoFilters;