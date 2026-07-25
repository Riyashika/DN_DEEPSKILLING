import React from 'react'

function BookDetails() {
    const books = [
        {id:1, name:'Master React', price : 670},
        {id:2, name:'Deep Drive into Angular 11', price: 800},
        {id:3, name:'Mongo Essentials', price: 450},
    ]
  return (
    <div>
        {books.map((book) => (
            <div>
                <h3>{book.name}</h3>
                <h5>{book.price}</h5>
            </div>
        ))}
    </div>
  )
}

export default BookDetails