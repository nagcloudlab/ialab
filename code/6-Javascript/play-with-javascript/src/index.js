
require('./style.scss')
const greet = require('ialab-greet')
const lodash = require('lodash')

// let mainItem = require('./hotel/menu') // cjm
// import mainItem, { item1, item2 } from './hotel/menu' // esm
// import mi, { item1 as itemOne, item2 as itemTwo } from './hotel/menu' // esm
import * as items from './hotel/menu' // esm

console.log(items.default);
console.log(items.item1);
console.log(items.item2);


// greet("es")

// let arr1 = [1, 2, 4]
// let arr2 = [2, 3]


// let d1 = arr1.filter(ele => !arr2.includes(ele))
// let d2 = lodash.difference(arr1, arr2)
// console.log(d2);
