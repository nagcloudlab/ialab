


export function loadTodos() {
    return fetch("http://localhost:8080/api/v1/todos")
        .then(res => res.json())
}

export function createTodo(title, type = "OFFICE") {
    return fetch("http://localhost:8080/api/v1/todos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ title, type })
    })
}
export function deleteTodo(todoId) {
    return fetch(`http://localhost:8080/api/v1/todos/${todoId}`, {
        method: "DELETE",
    })
}