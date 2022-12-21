import { useRef, useState } from 'react';
import './App.css';

function App() {

  const [file, setFile] = useState();
  const inputRef = useRef(null);


  const handleFileChange = e => {
    if (!e.target.files) {
      return;
    }
    setFile(e.target.files[0]);
  };

  const handleSubmit = e => {
    e.preventDefault();

    const data = new FormData();
    data.append(`files`, file, file.name);

    fetch("http://localhost:8080/upload", {
      method: "POST",
      body: data
    })
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.log(error));

  }


  return (
    <div className="">
      <form onSubmit={e => handleSubmit(e)}>
        <input
          type="file"
          ref={inputRef}
          onChange={handleFileChange}
        />
        <button>Upload</button>
      </form>

    </div>
  );
}

export default App;
