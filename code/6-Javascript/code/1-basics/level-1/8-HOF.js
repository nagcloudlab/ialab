
//----------------------------------------------------------------

//----------------------------------------------------------------

// function hi() {
//     console.log("hi"); // main logic
// }
// hi()
// function hiWithBanner() {
//     console.log("π·π·π·π·"); //around logic e.g logging, security check , error handling...
//     console.log("hi"); // main logic
//     console.log("π·π·π·π·");
// }
// hi()

// hiWithBanner() // without flower banner

// function hello() {
//     console.log("hello"); // main logic
// }
// function helloWithBanner() {
//     console.log("π·π·π·π·");
//     console.log("hello"); // main logic
//     console.log("π·π·π·π·");
// }
// hello()
// helloWithBanner()

//----------------------------------------------------------------

/**
 *
 *  design issues
 *  --------------------------------
 *
 *  ==> code tangling / coupling
 *  ==> code scattering / duplication
 *
 */


//----------------------------------------------------------------

// Solution : using Higher Order Function


function hi() {
    console.log("hi");
}
function hello() {
    console.log("hello");
}

// hi();

// Higher-Order-Function i.e function composition
function withFlowerBanner(f1) {
    return function () {
        console.log("πΌπΌπΌπΌπΌπΌπΌ");
        f1();
        console.log("πΌπΌπΌπΌπΌπΌπΌ");
    }
}

// const hiWithFlowerBanner = withFlowerBanner(hi)
// // on event
// hiWithFlowerBanner();

// const helloWithFlowerBanner = withFlowerBanner(hello)
// helloWithFlowerBanner();


//----------------------------------------------------------------

// E.g 

function doTransfer() {
    console.log("transfer")
}

function doXXX() {
    console.log("doXXX")
}

// cross cutting concerns in HOF
function withLog(f1) {
    return function () {
        console.log("LOG: initiated")
        f1()
    }
}
function withSec(f1) {
    return function () {
        console.log("SEC: check")
        f1()
    }
}


// withLog(withSec(doTransfer))()

// or

const transferWithSec = withSec(doTransfer)
const transferWithLogAndSec = withLog(transferWithSec)
transferWithLogAndSec();

//----------------------------------------------------------------