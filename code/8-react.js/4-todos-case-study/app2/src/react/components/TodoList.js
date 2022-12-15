import React from 'react';
import TodoItem from './TodoItem';

import { useSelector } from 'react-redux'

function TodoList({ }) {

    const todos = useSelector(state => state.todos || [])

    const renderTodos = () => {
        return todos.map((todo) => {
            return (
                <li className='list-group-item' key={todo.id}>
                    <TodoItem
                        todo={todo}
                    />
                </li>
            )
        })
    }

    return (
        <div className='card card-body mt-3'>
            <ul className='list-group'>
                {renderTodos()}
            </ul>
        </div>
    );
}

export default TodoList;