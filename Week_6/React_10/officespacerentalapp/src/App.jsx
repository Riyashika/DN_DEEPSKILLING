import React from 'react'

function App() {
  const officeheader = "Office Space Rental App";
  const officeimage = "https://cdn.sanity.io/images/uqxwe2qj/production/62db3c671745e98cb27690dff96f8033d2bb7f35-2048x1010.jpg?q=80&auto=format&fit=clip&w=1440";
  const featureoffice = {
    name : "DBS",
    rent : 50000,
    address : "Chennai"
  }
  const listoffice = [
    { id: 1, name: "DBS", rent: 50000, address: "Chennai" },
    { id: 2, name: "TCS", rent: 60000, address: "Bangalore" },
    { id: 3, name: "Wipro", rent: 70000, address: "Hyderabad" }
  ]
  return (
    <div>
      <h1>{officeheader}</h1>
      <img src={officeimage} alt="Office" style={{ 
      width: '300px',    
      height: '180px',  
      objectFit: 'cover',  
      borderRadius: '4px'    
    }} />
      <h2>Featured Office</h2>
      <p>Name: {featureoffice.name}</p>
      <p>Rent: {featureoffice.rent}</p>
      <p>Address: {featureoffice.address}</p>
      <h2>List of Offices</h2>
      <div>
        <ul>
          {
            listoffice.map(office => (
            <li key={office.id}>
              <li>Name: {office.name}</li>
              <li style={{ color: office.rent >= 60000 ? 'green' : 'red' }}>Rent: {office.rent}</li>
              <li>Address: {office.address}</li>
            </li>
          ))}
        </ul>
      </div>
    </div>
  )
}

export default App
