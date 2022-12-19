import { combineReducers, createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'

function cartReducer(state = {}, action) {
    let { type, payload } = action;
    switch (type) {
        case 'ADD_TO_CART': {
            let { item, qty = 1 } = payload
            let { id } = item
            let cartLine = state[id]
            if (cartLine) {
                cartLine.quantity += qty
            }
            else {
                cartLine = {
                    item, quantity: 1
                }
            }
            state = { ...state, [id]: cartLine }
            if (cartLine.quantity === 0)
                delete state[id]
            return state
        }
        default:
            return state;

    }

}

function reviewsReducer(state = {}, action) {
    let { type, payload } = action;
    switch (type) {
        case 'ADD_NEW_REVIEW': {
            let { review, productId } = payload;
            let existingReviews = state[productId] || [];
            existingReviews.unshift(review);
            state = { ...state, [productId]: existingReviews }
            return state
        }
        case 'LOAD_REVIEWS': {
            let { reviews, productId } = payload;
            let existingReviews = state[productId] || [];
            state = { ...state, [productId]: [...reviews, ...existingReviews] }
            return state
        }
        default:
            return state;
    }
}

function productsReducer(state = [], action) {
    let { type, payload } = action;
    switch (type) {
        case 'LOAD_PRODUCTS': {
            let { products } = payload;
            return [...products]
        }
        default:
            return state;
    }
}

const rootReducer = combineReducers({
    cart: cartReducer,
    reviews: reviewsReducer,
    products: productsReducer,
});

// const initialState = {
//     cart: {},
//     reviews: {},
//     products: []
// }

const store = createStore(rootReducer, applyMiddleware(thunk))


export default store;