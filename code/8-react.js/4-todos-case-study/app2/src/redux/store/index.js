
import { createStore } from 'redux'
import rootReducer from '../reducers'


const intialState = {
    todos: [
        {
            id: 1,
            title: 'Use Redux',
            completed: false
        }
    ]
}

const store = createStore(rootReducer, intialState, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())


export default store