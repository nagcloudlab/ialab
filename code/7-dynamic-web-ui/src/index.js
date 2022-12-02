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