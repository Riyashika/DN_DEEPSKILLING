import react,{useState} from 'react'
import BlogDetails from './components/BlogDetails'
import BookDetails from './components/BookDetails'
import CourseDetails from './components/CourseDetails'


function App() {

  const [showCourse,setShowCourse] = useState(true);
  const [viewBook,setViewBook] = useState('full');
  const [blogStatus,setBlogStatus] = useState('visible');

  return (
    <div className="App">
      <div className="row" style={{display:'flex', justifyContent:'space-around'}}>

        {/* 1.Using Logical AND operator */}
        <div className="col">
          <h1>Course Details</h1>
          <button onClick={()=>setShowCourse(!showCourse)}>{showCourse ? 'Hide' : 'Show'} Course</button>
          {showCourse && <CourseDetails />}
        </div>
        
        {/* 2.Using Ternary operator */}
        <div className="col">
          <h1>Book Details</h1>
          <button onClick={()=>setViewBook(viewBook === 'full' ? 'short' : 'full')}>{viewBook === 'full' ? 'Short View' : 'Full View'} Book</button>
          {viewBook === 'full' ? <BookDetails /> : <h5 style={{color:'red'}}>Click on the button to see Books!</h5>}
        </div>

        {/* 3.Using Switch Statement */}
        <div className="col">
          <h1>Blog Details</h1>
          <select value={blogStatus} onChange={(e)=>setBlogStatus(e.target.value)}>
            <option value="visible">Visible</option>
            <option value="hidden">Hidden</option>
          </select>
          {(() => {
            switch(blogStatus){
              case 'visible':
                return <BlogDetails />
              case 'hidden':
                return <h5 style={{color:'red'}}>Click on the dropdown to see Blogs!</h5>
              default:
                return <h5 style={{color:'red'}}>Click on the dropdown to see Blogs!</h5>
            }
          })()}
          </div>
      </div>
    </div>
  )
}

export default App
