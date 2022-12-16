
const apiUrl = "http://localhost:8080/api/v1/products"

export function getProducts() {
    return fetch(apiUrl)
        .then(response => response.json())
}


export function getReviews(productId) {
    return fetch(`${apiUrl}/${productId}/reviews`)
        .then(response => response.json())
}

export function postNewReview(productId, reviewData) {
    return fetch(`${apiUrl}/${productId}/reviews`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reviewData)
    })
        .then(response => response.json())
}