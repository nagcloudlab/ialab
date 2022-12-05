import 'bootstrap/dist/css/bootstrap.css'



//------------------------------------------------
// using DOM API
//------------------------------------------------

const alertBox = document.querySelector('.alert')
const greetBtn = document.querySelector('.btn-primary')
const hideBtn = document.querySelector('.btn-danger');
const showBtn = document.querySelector('.btn-success')

greetBtn.addEventListener('click', e => {
    alertBox.innerText = "hello, good eve";
})

hideBtn.addEventListener('click', e => {
    alertBox.style.display = 'none';
})

showBtn.addEventListener('click', e => {
    alertBox.style.display = 'block';
});



//------------------------------------------------
// using DOM + Timer API
//------------------------------------------------


// setTimeout, setInterval
const timeSpanEle = document.querySelector("#timeSpan")
setInterval(() => {
    let timeNow = new Date().toLocaleTimeString('en-US', { timeZone: "Asia/Kolkata" });
    timeSpanEle.innerText = timeNow
}, 1000);




//------------------------------------------------
// using DOM + XHR(XMLHTTPRequest) | Fetch API
//------------------------------------------------

const topFiveTodosBtn = document.querySelector('#top-five-todos-btn')


topFiveTodosBtn.addEventListener('click', e => {

    var url = "https://jsonplaceholder.typicode.com/todos?_limit=5"
    const promise = fetch(url)
    document.getElementById("progress-message").innerText = "Loading todos"
    promise
        .then(response => response.json())
        .then(todos => {
            document.getElementById("progress-message").innerText = ""
            const rows = todos.map(todo => {
                let row = `
            <tr>
                <td>${todo.id}</td>
                <td>${todo.title}</td>
                <td>${todo.completed}</td>
            </tr>
        `
                return row
            })
            document.getElementById('todos-table-body').innerHTML = rows.join('')
        })
});



