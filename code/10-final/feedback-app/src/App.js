import React from 'react';
import logo from './logo.svg';
import { Counter } from './features/counter/Counter';
import './App.css';
import Feebacks from './features/feedbacks/Feebacks';

import 'bootstrap/dist/css/bootstrap.css';
import FeedbackForm from './features/feedbacks/FeedbackForm';
// import FeedbackForm from './features/feedbacks/FeedbackForm';

function App() {
  return (
    <div className="container">

      <hr />
      <FeedbackForm />
      <br />
      <Feebacks />

    </div>
  );
}

export default App;
