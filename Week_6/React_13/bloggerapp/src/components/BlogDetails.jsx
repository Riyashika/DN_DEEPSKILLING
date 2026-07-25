import React from 'react'

function BlogDetails() {
    const blogs = [
        {id:1, name:'React Learning', author:'Stephen Biz', description:'Welcome to learning React!'},
        {id:2, name:'Installation', author:'Schewzdenier', description:'You can Install React from npm.'}
    ]
  return (
    <div>
        {blogs.map((blog) => (
            <div>
                <h3>{blog.name}</h3>
                <h5>By {blog.author}</h5>
                <p>{blog.description}</p>
            </div>
        ))}
    </div>
  )
}

export default BlogDetails