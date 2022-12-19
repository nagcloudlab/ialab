


export function fetchFeedbacks() {
    return fetch('http://localhost:8080/api/v1/feedbacks')
        .then(response => response.json());
}

export function postFeedbacks(feedback) {
    return fetch('http://localhost:8080/api/v1/feedbacks',
        {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(feedback)
        })
        .then(response => response.json());
}