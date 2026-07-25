import { useState } from 'react'
import UserGreeting from './components/UserGreeting'
import GuestGreeting from './components/GuestGreeting'
import Login from './components/Login'
import Logout from './components/Logout'

function App() {
  const [isLoggedin, setIsLoggedin] = useState(false)

  const handleLogin = () => {
    setIsLoggedin(true)
  }

  const handleLogout = () => {
    setIsLoggedin(false)
  }

  return (
    <div>
      {isLoggedin ? (
        <div>
          <UserGreeting />
          <Logout onClick={handleLogout} />
        </div>
      ) : (
        <div>
          <GuestGreeting />
          <Login onClick={handleLogin} />
        </div>
      )}
    </div>
  )
}

export default App
