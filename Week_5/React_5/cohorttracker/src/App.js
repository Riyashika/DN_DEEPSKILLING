import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';
import './App.css';

function App() {
  return (
    <div className="App">
      <h1>Cohort Details:</h1>
      {CohortsData.map((cohort, index) => 
        <CohortDetails key={index} cohort={cohort} />
      )}
    </div>
  );
}

export default App;
