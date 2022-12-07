
import React, { Component } from 'react';
import Bar from './components/Bar';
import Counter from './components/Counter';
import Foo from './components/Foo';
import Message from './components/Message';

// class App extends Component {
//   render() {
//     return (
//       <div>
//         App component
//       </div>
//     );
//   }
// }

function App() {
  return (
    <div className='container'>
      <hr />
      <h1>react core concepts</h1>
      <hr />
      {/* <Message value="Hello concentrix" /> */}
      {/* <Counter /> */}
      <Foo title="foo" />
      <hr />
      <Bar title="bar" />
    </div>
  );
}

export default App;