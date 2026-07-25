import React from 'react'

function CourseDetails() {
    const courses = [
        {id:1, name:'React', date:'4/5/2021'},
        {id:2, name:'Angular', date:'6/3/2021'}
    ]
  return (
    <div>
        {courses.map((course) => (
            <div>
                <h3>{course.name}</h3>
                <h5>{course.date}</h5>
            </div>
        ))}
    </div>
  )
}

export default CourseDetails