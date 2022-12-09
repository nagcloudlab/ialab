
import 'bootstrap/dist/css/bootstrap.css';
import UseContextHook from './components/UseContextHook';
import UseEffectHook from './components/UseEffectHook';
import UseReducerHook from './components/UseReducerHook';
import UseRefHook from './components/UseRefHook';
import UseStateHook from './components/UseStateHook';

function App() {
  return (
    <div className="container">
      <hr />
      <div className='display-1'>React Hooks</div>
      <hr />
      <UseRefHook />
    </div>
  );
}

export default App;
