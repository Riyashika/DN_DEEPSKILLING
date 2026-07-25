import { useState } from 'react'
import CurrencyConverter from './components/CurrencyConverter'


function App() {
  const [count, setCount] = useState(0)
  const increment =() => {
    setCount(count + 1)
  }
  const decrement =() => {
    setCount(count - 1)
  }
  const sayHello = () => {
    alert("This is a static message!");
  }
  const sayWelcome = (name) => {
    alert(`Welcome, ${name}!`);
  }
  const handleMultipleMethods =() => {
    increment();
    sayHello();
  }
  const handleSyntheticEvent = (event) => {
    alert(`Event type: ${event.type}`);
  }
  return (
    <div>
      <div>
        <h1>Count : {count}</h1>
        <ul>
          <ul><button onClick={() => handleMultipleMethods()}>Increment</button></ul>
          <ul><button onClick={decrement}>Decrement</button></ul>
          <ul><button onClick={() => sayWelcome("User")}>Say Welcome</button></ul>
          <ul><button onClick={() => handleSyntheticEvent({ type: "click" })}>Click Me</button></ul>
        </ul>
      </div>
      <CurrencyConverter/>
    </div>
  )
}

export default App
