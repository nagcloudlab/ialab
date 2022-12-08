
import React, { Component } from 'react';
import ReviewForm from './form/ReviewForm';
import Table from './fragments/Table';
import Foo from './jsx/Foo';



// const todos = [
//   {
//     id: 1,
//     title: 'Todo 1',
//     completed: true
//   },
//   {
//     id: 2,
//     title: 'Todo 2',
//     completed: false
//   }
// ]

// const products = [
//   {
//     id: 1,
//     title: 'Product 1',
//     price: 100.00
//   },
//   {
//     id: 2,
//     title: 'Product 2',
//     price: 200.00
//   }
// ]



function App() {

  const currentUser = "Tom"

  return (
    <div className='container'>
      <hr />
      <h1>react bytes</h1>
      <hr />

      <ReviewForm />

      {/* <Foo /> */}

      {/* <Table /> */}


      {/* <UserContext.Provider value={currentUser}>
        <A />
      </UserContext.Provider>

      <UserContext.Provider value={"Jerry"}>
        <A />
      </UserContext.Provider> */}


      {/* <DataTable
        columns={["Id", "Title", "Completed"]}
        data={todos}
        r={item => (
          <tr key={item.id}>
            <td>{item.id}</td>
            <td>{item.title}</td>
            <td>{item.completed ? 'completed' : 'pending'}</td>
          </tr>
        )
        } /> */}


    </div>
  );
}

export default App;