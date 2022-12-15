import { combineReducers } from 'redux'

import { todosReducer } from './todos'


const rootReducer = combineReducers({
    todos: todosReducer,
    // user: userReducer,
})


export default rootReducer;

