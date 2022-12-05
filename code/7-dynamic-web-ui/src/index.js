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

setInterval(() => {
    let timeNow = new Date().toLocaleTimeString('en-US', { timeZone: "Asia/Kolkata" });
    document.querySelector("#timeSpan").innerText = timeNow
}, 1000);




//------------------------------------------------
// using DOM + XHR(XMLHTTPRequest) | Fetch API
//------------------------------------------------

const topFiveTodosBtn = document.querySelector('#top-five-todos-btn')


// XHR API
// topFiveTodosBtn.addEventListener('click', e => {
//     var xhttp = new XMLHttpRequest();
//     var url = "https://jsonplaceholder.typicode.com/todos?_limit=5"
//     xhttp.open("GET", url, true);
//     xhttp.send();
//     document.getElementById("progress-message").innerText = "Loading todos"

//     xhttp.onreadystatechange = () => {
//         if (xhttp.readyState == 4) {
//             document.getElementById("progress-message").innerText = ""
//             const jsonText = xhttp.responseText;
//             const todos = JSON.parse(jsonText);
//             const rows = todos.map(todo => {
//                 let row = `
//             <tr>
//                 <td>${todo.id}</td>
//                 <td>${todo.title}</td>
//                 <td>${todo.completed}</td>
//             </tr>
//         `
//                 return row
//             })
//             document.getElementById('todos-table-body').innerHTML = rows.join('')
//         }
//     }

// });


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



