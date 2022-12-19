import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import feedbacksReducer from '../features/feedbacks/feedbacksSlice';

export const store = configureStore({
  reducer: {
    counter: counterReducer,
    feedbacks: feedbacksReducer,
  },
});
