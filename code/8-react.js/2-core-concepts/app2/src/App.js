
import React, { Component } from 'react';
import VotingBox from './components/VotingBox';

class App extends Component {
  render() {
    return (
      <div className='container'>
        <div className='display-1'>Thinking in React</div>
        <hr />
        <VotingBox items={[
          "java",
          "spring",
          "react",
          "angular",
        ]} />
      </div>
    );
  }
}

export default App; 