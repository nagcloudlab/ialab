import React, { useEffect, useState } from 'react';

import { loginAsync } from './userSlice'
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom'

function Login(props) {

    const [credentials, setCredentials] = useState({
        username: 'tom',
        password: '1234',
    })

    const dispatch = useDispatch();
    const navigate = useNavigate()

    const isLoggedIn = useSelector(state => state.user.isLoggedIn);
    console.log(isLoggedIn);

    useEffect(() => {
        if (isLoggedIn) {
            navigate("/todos")
        }
    }, [isLoggedIn])


    const handleSubmit = e => {
        e.preventDefault();
        dispatch(loginAsync(credentials))
    };


    return (
        <div>
            <div className='card'>
                <div className='card-header'>Login</div>
                <div className='card-body'>
                    <form onSubmit={e => handleSubmit(e)}>
                        <div className='form-group'>
                            <label htmlFor='username'>Username</label>
                            <input type='text'
                                value={credentials.username}
                                onChange={e => setCredentials({ ...credentials, username: e.target.value })}
                                className='form-control' />
                        </div>
                        <div className='form-group'>
                            <label htmlFor='password'>Password</label>
                            <input type='password'
                                value={credentials.password}
                                onChange={e => setCredentials({ ...credentials, password: e.target.value })}
                                className='form-control' />
                        </div>
                        <br />
                        <button className='btn btn-primary'>Login</button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Login;