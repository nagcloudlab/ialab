


function Clock(props) {
    let timeZone = props.timeZone

    //a. javascript
    // const spanEle = React.createElement('span', { className: 'badge bg-danger' }, new Date().toLocaleTimeString('en-US', { timeZone }));
    // const cardBodyEle = React.createElement('div', { className: 'card-body' }, spanEle);
    // const cardHeaderEle = React.createElement('div', { className: 'card-header' }, timeZone);
    // const cardEle = React.createElement('div', { className: 'card' }, cardHeaderEle, cardBodyEle)
    // return cardEle

    //b.jsx
    return (
        <div className="card">
            <div className="card-header">{timeZone}</div>
            <div className="card-body">
                <span className="badge bg-danger">{new Date().toLocaleTimeString('en-US', { timeZone })}</span >
            </div>
        </div>
    )

}

function Wall() {
    return (
        <div className="row">
            <div className="col-4">
                <div><Clock timeZone="Asia/Kolkata" /></div>
            </div>
            <div className="col-4">
                <div><Clock timeZone="Asia/Dubai" /></div>
            </div>
            <div className="col-4">
                <div><Clock timeZone="America/New_york" /></div>
            </div>
        </div>
    )
}


setInterval(() => {
    ReactDOM.render(<Wall />, document.getElementById('root'));
}, 1000);


