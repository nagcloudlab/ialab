



// let arr1 = [1, 2]
// let arr2 = [2, 4]
// let diff = arr1.filter(ele => !arr2.includes(ele))
// console.log(diff);


// let arr = [0, "", 1, false, undefined, 5]
// let compact = arr.filter(ele => ele)
// console.log(compact);

// let arr = [1, 1, 2, 3, 4, 5, 6]
// let uniArr = []
// arr.forEach(ele => {
//     if (!uniArr.includes(ele))
//         uniArr.push(ele)
// })
// console.log(uniArr);


let arr = [1, 2, 3, 6, 1, 2, 2]
let map = {}
arr.forEach(ele => {
    if (map[ele]) {
        map[ele] = map[ele] + 1
    } else {
        map[ele] = 1
    }
})
console.log(map)


// ------------------------------------------------------

// How to oraganize javascript code into modules/packages
/// tool : NPM ( node package manager)