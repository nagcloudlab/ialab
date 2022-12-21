import List from './List';

import 'bootstrap/dist/css/bootstrap.css';
import { useEffect, useState } from 'react';

function App() {

  const [subjects, setSubjects] = useState([])

  // By Nag
  useEffect(() => {
    fetch('http://13.234.32.50:8080/api/subjects')
      .then(response => response.json())
      .then(subjects => setSubjects(subjects))
  }, [])

  return (
    <div className="container">
      <div className='display-1'>Ui</div>
      <hr />
      <div className='row'>
        <div className='col-sm-6 col-md-6'>
          <List value={subjects} />
        </div>
      </div>
    </div>
  );
}

export default App;
