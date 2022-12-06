import React from 'react'
import Message from './Message';

class App extends React.Component {

  state = {
    message: 'greetings'
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
    let { message } = this.state;
    return (
      <div className='container' style={{ border: '1px solid red' }}>
        <hr />
        <div className='display-1'>{title}-{version}</div>
        <hr />
        <div className='d-flex justify-content-around'>
          <button onClick={e => this.handleEvent(e, 'Foo')} className='btn btn-dark'>Foo</button>
          <button onClick={e => this.handleEvent(e, 'Bar')} className='btn btn-dark'>Bar</button>
          <button onClick={e => this.handleEvent(e, 'Buz')} className='btn btn-dark'>Buz</button>
          <button onClick={e => this.handleEvent(e, '')} className='btn btn-danger'>Delete</button>
        </div>
        <hr />
        {message ? <Message value={message} /> : null}
      </div>
    )
  }

}

export default App;
