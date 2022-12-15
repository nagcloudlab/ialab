

export function todosReducer(state = [], action) {
    console.log('todosReducer')
    let { type, payload } = action
    switch (type) {
        case "ADD_TODO": {
            let { title } = payload
            let todo = { id: state.length + 1, title, completed: false }
            return [...state, todo]
        }
        case "DELETE_TODO": {
            let { id } = payload
            return state.filter(todo => todo.id !== id)
        }
        default:
            return state
    }
}