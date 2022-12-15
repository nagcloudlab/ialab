import React from 'react';
import TodoItem from './TodoItem';

function TodoList({ todos, onDelete, onComplete }) {

    const renderTodos = () => {
        return todos.map((todo) => {
            return (
                <li className='list-group-item' key={todo.id}>
                    <TodoItem
                        todo={todo}
                        onDelete={onDelete}
                        onComplete={onComplete}
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