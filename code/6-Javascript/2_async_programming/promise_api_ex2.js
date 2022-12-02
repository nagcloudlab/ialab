
function searchGoogle(term) {
    return new Promise(function (resolve, reject) {
        setTimeout(() => {
            console.log("google search result resolved");
            resolve("GOOGLE")
        }, 3000)
    })
}

function searchYandex(term) {
    return new Promise(function (resolve, reject) {
        setTimeout(() => {
            console.log("yandex search result reject");
            reject("oops")
        }, 1000)
    })
}


let p1 = searchGoogle("javascript")
let p2 = searchYandex("javascript")

Promise.race([p1, p2])
    .then(results => {
        console.log(results)
    })
    .catch(err => {
        console.log(err);
    })