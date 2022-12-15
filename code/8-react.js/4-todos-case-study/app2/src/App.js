import { useEffect, useState } from "react";
import TodoFilters from "./react/components/TodoFilters";
import TodoInput from "./react/components/TodoInput";
import TodoList from "./react/components/TodoList";


function App() {

  return (
    <div className="container">
      <div className="display-1">todos</div>
      <hr />
      <TodoInput />
      <TodoFilters />
      <TodoList />
    </div>
  );
}

export default App;
