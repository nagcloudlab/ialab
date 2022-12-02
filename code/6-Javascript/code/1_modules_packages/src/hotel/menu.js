console.log("-hotel/menu.js")

let mainItem = {
    name: "Main Item",
    price: 0,
    description: "This is the main item",
}


let item1 = {
    name: "Item 1",
    price: 0,
}

let item2 = {
    name: "Item 2",
    price: 0,
}

// module.exports = mainItem // cjm
export default mainItem // esm
export { item1, item2 }

