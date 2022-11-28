"use strict";

// model

class Todo {
    static nextId = 0;
    constructor(title) {
        this.id = ++Todo.nextId;
        this.title = title;
        this.completed = false;
    }
}

// service
const todoFilters = {
    ALL: todo => true,
    ACTIVE: todo => !todo.completed,
    COMPLETED: todo => todo.completed
}

class TodoService {
    todos = []
    addTodo(title) {
        const todo = new Todo(title)
        // this.todos.push(todo); // mutable
        this.todos = this.todos.concat(todo) // immutable
    }
    editTodo(id, newTitle) {
        // const todo = this.todos.find(todo => todo.id === id);
        // if (todo)
        //     todo.title = newTitle;
        this.todos = this.todos.map(todo => {
            if (todo.id === id)
                todo.title = newTitle;
            return todo;
        });
    }
    deleteTodo(id) {
        // const idx = this.todos.findIndex(todo => todo.id === id);
        // this.todos.splice(idx, 1);
        this.todos = this.todos.filter(todo => todo.id !== id);
    }
    completeTodo(id) {
        // const todo = this.todos.find(todo => todo.id === id);
        // todo.completed = !todo.completed;
        this.todos = this.todos.map(todo => {
            if (todo.id === id)
                todo.completed = !todo.completed;
            return todo;
        });
    }
    completeAll() {
        const areAllCompleted = this.todos.every(todo => todo.completed)
        // this.todos.forEach(todo => todo.completed = !areAllCompleted);
        this.todos = this.todos.map(todo => {
            todo.completed = !areAllCompleted;
            return todo;
        });
    }
    clearCompleted() {
        // this.todos.forEach((todo, idx) => {
        //     if (todo.completed)
        //         this.todos.splice(idx, 1);
        // });
        this.todos = this.todos.filter(todo => !todo.completed);
    }
    viewTodos(flag = "ALL") {
        this.todos
            .filter(todoFilters[flag])
            .forEach(todo => console.log(todo))
    }
}




const service = new TodoService();
service.addTodo("todo-1");
service.addTodo("todo-2");
service.addTodo("todo-3");
// service.editTodo(2, "todo two");
// service.deleteTodo(1);
service.completeTodo(1)
service.completeTodo(3)