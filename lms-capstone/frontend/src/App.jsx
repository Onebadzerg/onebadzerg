import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';  // ✅ This imports your styles


function App() {
    const [books, setBooks] = useState([]);
    const [title, setTitle] = useState('');
    const [author, setAuthor] = useState('');

    // Fetch books on load
    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/books');
            setBooks(response.data);
        } catch (error) {
            console.error('Error fetching books:', error);
        }
    };

    // Add a new book
    const handleAddBook = async () => {
        if (!title || !author) {
            alert("Both Title and Author are required!");
            return;
        }

        const newBook = { id: Date.now(), title, author }; // Temporary ID for frontend
        try {
            const response = await axios.post('http://localhost:8080/api/books', newBook);
            setBooks([...books, response.data]);
            setTitle('');
            setAuthor('');
        } catch (error) {
            console.error('Error adding book:', error);
        }
    };

    return (
        <div className="container">
            <h1 className="title">📚 Library Management System</h1>

            {/* Form to add new books */}
            <div className="form-container">
                <input
                    type="text"
                    placeholder="Title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Author"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                />
                <button onClick={handleAddBook}>➕ Add Book</button>
            </div>

            {/* Display Books in a Table */}
            <table className="book-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map((book) => (
                        <tr key={book.id}>
                            <td>{book.id}</td>
                            <td>{book.title}</td>
                            <td>{book.author}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default App;
