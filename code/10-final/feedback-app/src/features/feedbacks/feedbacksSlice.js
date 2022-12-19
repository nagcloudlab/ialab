import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { fetchFeedbacks, postFeedbacks } from './feedbacksAPI';

const initialState = {
    value: 0,
    status: 'idle',
};

export const fetchFeedbacksAsync = createAsyncThunk(
    'feedbacks/fetchFeedbacksAsync',
    async () => {
        const response = await fetchFeedbacks()
        return response;
    }
);
export const postFeedbacksAsync = createAsyncThunk(
    'feedbacks/postFeedbacksAsync',
    async (feedback) => {
        const response = await postFeedbacks(feedback);
        console.log(response);
        return response;
    }
);

export const feedbacksSlice = createSlice({
    name: 'feebacks',
    initialState,
    reducers: {
    },
    extraReducers: (builder) => {
        builder
            .addCase(fetchFeedbacksAsync.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(fetchFeedbacksAsync.fulfilled, (state, action) => {
                console.log(action)
                state.status = 'idle';
                state.value = action.payload;
            })
            .addCase(postFeedbacksAsync.fulfilled, (state, action) => {
                console.log(action)
                state.status = 'idle';
                state.value = state.value.concat(action.payload);
            });
    },
});

export const { } = feedbacksSlice.actions;

export default feedbacksSlice.reducer;
