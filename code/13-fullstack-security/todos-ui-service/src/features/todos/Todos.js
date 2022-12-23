import React, { useEffect } from 'react';

import { fetchTodosAsync } from './todosSlice'
import { useDispatch, useSelector } from 'react-redux'

function Todos(props) {
    const dispatch = useDispatch()
    const todos = useSelector(state => state.todos)
    useEffect(() => {
        dispatch(fetchTodosAsync())
    }, [])
    console.log(todos);
    return (
        <div>
            todos
        </div>
    );
}

export default Todos;