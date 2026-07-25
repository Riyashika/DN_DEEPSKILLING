import React from 'react';

function IndianPlayers() {
  const nationalTeam = ["Virat", "Rohit", "Rahul", "Jadeja", "Bumrah", "Shami"];
  const [player1, player2, player3, player4, player5, player6] = nationalTeam;
  
  const oddTeam = [player1, player3, player5];  
  const evenTeam = [player2, player4, player6]; 

  const T20players = ["Hardik", "Suryakumar", "Samson"];
  const RanjiTrophyPlayers = ["Sarfaraz", "Abhimanyu", "Sai Sudharsan"];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Indian Players</h2>
      <div>
        <h3>Odd Team Players</h3>
            <ul>
                <li> First : {oddTeam[0]}</li>
                <li> Third : {oddTeam[1]}</li>
                <li> Fifth : {oddTeam[2]}</li>
            </ul>
      </div>
      <div>
        <h3>Even Team Players</h3>
            <ul>
                <li> Second : {evenTeam[0]}</li>
                <li> Fourth : {evenTeam[1]}</li>
                <li> Sixth : {evenTeam[2]}</li>
            </ul>
      </div>
      <div>
        <h3>Merged Players</h3>
        <ul>
          {mergedPlayers.map(player => 
            <li>Mr. {player}</li>
        )}
        </ul>
      </div>
    </div>
  );
}

export default IndianPlayers;
