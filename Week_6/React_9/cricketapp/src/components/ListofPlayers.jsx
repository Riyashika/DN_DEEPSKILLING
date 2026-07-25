import React from 'react'

function ListofPlayers() {
     const players = [
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 85 },
    { name: "Virat", score: 110 },
    { name: "Rohit", score: 45 },
    { name: "Rahul", score: 68 },
    { name: "Jadeja", score: 72 },
    { name: "Hardik", score: 50 },
    { name: "Bumrah", score: 15 },
    { name: "Shami", score: 30 },
    { name: "Ashwin", score: 78 },
    { name: "Pant", score: 82 }
  ];

  const listofplayers = players.filter(player => player.score >= 70);
    return (
        <div>
            <h2>List of All Players</h2>
            <ul>
                {players.map(player => (
                <li>Mr. {player.name} <span/> <span/> {player.score}</li>
                ))}
            </ul>

            <h2>Players with Score Greater Than 70</h2>
            <ul>
                {listofplayers.map(player => (
                <li>Mr. {player.name} <span/> <span/> {player.score}</li>
                ))}
            </ul>
        </div>
    )
}

export default ListofPlayers