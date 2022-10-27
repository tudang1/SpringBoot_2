import React, { useEffect, useState } from "react";

function Api() {
    const [data, setData] = useState([]);
    const [type, setType] = useState("posts");

    useEffect(() => {
        fetch(`https://jsonplaceholder.typicode.com/${type}`)
            .then((response) => response.json())
            .then((json) => setData(json))
            .catch((error) => console.log(error));
    }, [type]);

    return (
        <div>
            <button onClick={() => setType("posts")}>Posts</button>
            <button onClick={() => setType("comments")}>Comments</button>
            <button onClick={() => setType("albums")}>Albums</button>

            <ul>
                {data.map((item) => (
                    <li key={item.id}>{item.title ?? item.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default Api;
