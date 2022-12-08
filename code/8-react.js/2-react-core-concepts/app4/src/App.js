
import 'bootstrap/dist/css/bootstrap.css';
import Counter from './Counter';
import CounterWithHook from './CounterWithHook';

function App() {
  return (
    <div className="container">
      <hr />
      <div className='display-1'>React Hooks</div>
      <hr />
      <Counter />
      <br />
      <CounterWithHook />
    </div>
  );
}

export default App;
