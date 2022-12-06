import React from 'react'


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
      <div className='container'>
        <hr />
        <div className='display-1'>{title}-{version}</div>
        <hr />
        <div className='d-flex justify-content-around'>
          <button onClick={e => this.handleEvent(e, 'good morning')} className='btn btn-dark'>GM</button>
          <button onClick={e => this.handleEvent(e, 'good noon')} className='btn btn-dark'>GN</button>
          <button onClick={e => this.handleEvent(e, 'good evening')} className='btn btn-dark'>GE</button>
        </div>
        <hr />
        <div className='card'>
          <div className='card-header bg-info'>Message</div>
          <div className='card-body'>
            {message}
          </div>
        </div>
      </div>
    )
  }

}

export default App;
