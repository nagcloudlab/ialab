
import * as productsApi from '../api/products'

// action creator
export function loadProducts() {
    // thunk function
    return function (dispatch) {
        let promise = productsApi.getProducts(); // api call
        promise.then(data => {
            const action = {
                type: 'LOAD_PRODUCTS',
                payload: {
                    products: data
                }
            }
            dispatch(action)
        })
    }
}
export function loadRevies(productId) {
    // thunk function
    return function (dispatch) {
        let promise = productsApi.getReviews(productId); // api call
        promise.then(data => {
            const action = {
                type: 'LOAD_REVIEWS',
                payload: {
                    reviews: data,
                    productId
                }
            }
            dispatch(action)
        })
    }
}

export function addNewReview(productId, reviewData) {
    // thunk function
    return function (dispatch) {
        let promise = productsApi.postNewReview(productId, reviewData); // api-call
        promise.then(data => {
            const action = {
                type: 'ADD_NEW_REVIEW',
                payload: {
                    review: data,
                    productId
                }
            }
            dispatch(action)
        })
    }
}