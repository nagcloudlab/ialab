import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { login } from './userAPI';

const initialState = {
    isLoggedIn: false,
    status: 'idle',
};

// The function below is called a thunk and allows us to perform async logic. It
// can be dispatched like a regular action: `dispatch(incrementAsync(10))`. This
// will call the thunk with the `dispatch` function as the first argument. Async
// code can then be executed and other actions can be dispatched. Thunks are
// typically used to make async requests.
export const loginAsync = createAsyncThunk(
    'user/login',
    async (credentials) => {
        const response = await login(credentials);
        // The value we return becomes the `fulfilled` action payload
        return response.data;
    }
);

export const userSlice = createSlice({
    name: 'user',
    initialState,
    // The `reducers` field lets us define reducers and generate associated actions
    reducers: {
    },
    // The `extraReducers` field lets the slice handle actions defined elsewhere,
    // including actions generated by createAsyncThunk or in other slices.
    extraReducers: (builder) => {
        builder
            .addCase(loginAsync.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(loginAsync.fulfilled, (state, action) => {
                let { payload } = action;
                let { accessToken } = payload;
                localStorage.setItem('accessToken', accessToken);
                state.isLoggedIn = true
            });
    },
});

export const { } = userSlice.actions;
export default userSlice.reducer;
