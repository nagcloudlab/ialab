import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { fetchTodos } from './todosAPI';

const initialState = {
    todos: [],
    status: 'idle',
};

// The function below is called a thunk and allows us to perform async logic. It
// can be dispatched like a regular action: `dispatch(incrementAsync(10))`. This
// will call the thunk with the `dispatch` function as the first argument. Async
// code can then be executed and other actions can be dispatched. Thunks are
// typically used to make async requests.
export const fetchTodosAsync = createAsyncThunk(
    'todos/fetch',
    async () => {
        const response = await fetchTodos();
        // The value we return becomes the `fulfilled` action payload
        return response.data;
    }
);

export const todosSlice = createSlice({
    name: 'todos',
    initialState,
    // The `reducers` field lets us define reducers and generate associated actions
    reducers: {
    },
    // extraReducers: (builder) => {
    //     builder
    //         .addCase(todosSlice.pending, (state) => {
    //             state.status = 'loading';
    //         })
    //         .addCase(todosSlice.fulfilled, (state, action) => {
    //             // let { payload } = action;
    //             // console.log(payload);
    //             // state.todos = [...payload]
    //         });
    // },
});

export const { } = todosSlice.actions;
export default todosSlice.reducer;
