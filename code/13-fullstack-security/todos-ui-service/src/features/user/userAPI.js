
import axios from 'axios';

export function login(credentials) {
    return axios.post('http://localhost:8080/login', credentials);
}