import React, { useEffect, useState } from "react";
import axios from "axios";

const BookTable = () => {
    const [books, setBooks] = useState([]);

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/books");
            setBooks(response.data);
        } catch (error) {
            console.error("Error fetching books:", error);
        }
    };

    return (
        <div className="container mx-auto p-4">
            <h2 className="text-xl font-bold mb-4">Book List</h2>
            <table className="min-w-full bg-white border border-gray-200">
                <thead className="bg-gray-200">
                    <tr>
                        <th className="border px-4 py-2">ISBN</th>
                        <th className="border px-4 py-2">Title</th>
                        <th className="border px-4 py-2">Author</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map((book, index) => (
                        <tr key={index} className="border">
                            <td className="border px-4 py-2">{book.bookIsbn}</td>
                            <td className="border px-4 py-2">{book.title}</td>
                            <td className="border px-4 py-2">{book.author}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default BookTable;
