import { combineReducers, createStore } from 'redux'

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
        case 'ADD_TO_REVIEWS': {
            let { review, itemId } = payload;
            let existingReviews = state[itemId] || [];
            existingReviews.unshift(review);
            state = { ...state, [itemId]: existingReviews }
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
            return [...state, ...products]
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

const initialState = {
    cart: {},
    reviews: {},
    products: [
        {
            id: 1,
            name: "Product 1",
            price: 100,
            description: "Product Description",
            isAvailable: true,
            imageUrl: "images/Laptop.png"
        },
        {
            id: 2,
            name: "Product 2",
            price: 200,
            description: "Product Description",
            isAvailable: true,
            imageUrl: "images/Mobile.png"
        }
    ],
}

const store = createStore(rootReducer, initialState, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())


export default store;