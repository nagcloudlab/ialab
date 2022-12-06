import React from 'react'
import Box from './Box';
import List from './List';
import Message from './Message';
import Veg from './Veg';
import NonVeg from './NonVeg'

class App extends React.Component {

  state = {
    message: 'greetings',
    topics: [
      "java",
      "spring",
      "microservices",
      "javascript"
    ]
  }

  constructor(props) {
    console.log("App :: constructor");
    //console.log(props);
    super(props);
  }

  handleEvent(event, message) {
    console.log("App :: handleEvent i.e change state");
    this.setState({
      message
    })
  }
  render() {
    console.log("App :: render");
    let { title, version } = this.props;
    let { message, topics } = this.state;
    return (
      <div className='container' style={{ border: '1px solid red' }}>
        <hr />
        <div className='display-1'>{title}-{version}</div>
        <hr />
        <Box>
          <h1>foo</h1>
          <h1>bar</h1>
        </Box>
        <Box>
          <NonVeg />
          <NonVeg />
          <NonVeg />
        </Box>
        <Box>
          <Veg />
          <Veg />
        </Box>
        <hr />
        <List value={topics} />
        <hr />
        <div className='d-flex justify-content-around'>
          <button onClick={e => this.handleEvent(e, 'Foo')} className='btn btn-dark'>Foo</button>
          <button onClick={e => this.handleEvent(e, 'Bar')} className='btn btn-dark'>Bar</button>
          <button onClick={e => this.handleEvent(e, 'Buz')} className='btn btn-dark'>Buz</button>
          <button onClick={e => this.handleEvent(e, '')} className='btn btn-danger'>Delete</button>
        </div>
        <hr />
        {message ? <Message value={message} /> : null}
        <hr />
      </div>
    )
  }

}

export default App;
