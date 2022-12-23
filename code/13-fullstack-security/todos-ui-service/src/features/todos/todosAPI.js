
import axios from 'axios';

export function fetchTodos() {
    return fetch('http://localhost:8080/api/todos', {
        headers: {
            'Authorization': `Bearer ${localStorage.getItem('accessToken') || ''}`,
        }
    });
}