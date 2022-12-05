


//------------------------------------
// with DOM + Timer Api
//------------------------------------

const clock1Ele = document.querySelector('#clock-1');
const clock2Ele = document.querySelector('#clock-2');
const clock3Ele = document.querySelector('#clock-3');


//------------------------------------
// component - class
//------------------------------------

function Clock(props) {
    let timeZone = props.timeZone
    return `
        <div class="card">
            <div class="card-header">${timeZone}</div>
            <div class="card-body">
                <span class="badge bg-danger">${new Date().toLocaleTimeString('en-US', { timeZone })}</span >
            </div>
        </div>
    `
}


setInterval(() => {
    clock1Ele.innerHTML = Clock({ timeZone: 'Asia/Kolkata' })
    clock2Ele.innerHTML = Clock({ timeZone: 'Asia/Dubai' })
    clock3Ele.innerHTML = Clock({ timeZone: 'America/Los_Angeles' })
}, 1000);
