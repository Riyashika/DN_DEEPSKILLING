import { Component } from 'react';

class Posts extends Component{
    constructor(props) {
        super(props);
        this.state = { posts: [] }
    }
    Loadposts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                this.setState({ posts : data });
            })
            .catch(error => console.log(error));
    }
    componentDidMount() {
        this.Loadposts();
    }
    render() {
        return (
            <div>
                {/* {this.state.posts.map(post => (
                    <Post key={post.id} id={post.id} title={post.title} body={post.body} />
                    ))} */}
                {this.state.posts.map(post => (
                   <div key={post.id}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
    componentDidCatch(error, info) {
        alert('Error occurred' + error);
    }
}
export default Posts;