import { useEffect, useState } from "react";
import TodoFilters from "./components/TodoFilters";
import TodoInput from "./components/TodoInput";
import TodoList from "./components/TodoList";

import { loadTodos, createTodo, deleteTodo } from './api/todos'

function App() {

  const [todos, setTodos] = useState([]);
  const [filter, setFilter] = useState('all')

  useEffect(() => {
    loadTodos().then(todos => setTodos(todos))
  }, [])

  const filteredTodos = todos.filter(todo => {
    if (filter === 'active') {
      return !todo.completed;
    }
    if (filter === 'completed') {
      return todo.completed;
    }
    return true;
  })

  const handleComplete = id => {
    setTodos(todos.map(todo => {
      if (todo.id === id) {
        todo.completed = !todo.completed;
      }
      return todo;
    }));
  }

  const handleDelete = (id) => {
    deleteTodo(id).then(() => setTodos(todos.filter(t => t.id !== id)))
  }


  const handleNewTodo = (title) => {
    createTodo(title)
      .then(response => response.json())
      .then(todo => {
        setTodos([...todos, todo]);
      })
  }

  return (
    <div className="container">
      <div className="display-1">todos</div>
      <hr />
      <TodoInput
        onNewTodo={handleNewTodo}
      />
      <TodoFilters
        currentFilter={filter}
        onChange={filter => setFilter(filter)} />
      <TodoList
        todos={filteredTodos}
        onDelete={handleDelete}
        onComplete={handleComplete}
      />
    </div>
  );
}

export default App;
