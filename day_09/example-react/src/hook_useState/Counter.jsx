import React, { useState } from "react";

// mount : Khi component được gắn vào DOM
// unmount : Khi component bị loại bỏ vào DOM
// Khi thay đổi giá trị state => component bị re-render
// hàm setState là hàm bất đồng bộ
function Counter() {
    const [count, setCount] = useState(0);
    const [user, setUser] = useState({
        id: 1,
        name: "Nguyen Van A",
        email: "a@gmail.com",
    });

    const [products, setProducts] = useState([
        { id: 1, name: "Product 1" },
        { id: 2, name: "Product 2" },
        { id: 3, name: "Product 3" },
    ]);

    const [show, setShow] = useState(true);

    const increment = () => {
        // count++ => count = count + 1
        console.log("prev count = ", count);
        setCount(count + 1);
        console.log("next count = ", count);
    };

    const decrement = () => {
        setCount((count) => count - 1);
    };

    const changeName = () => {
        let rdName = Math.random() + "new name";
        setUser({ ...user, name: rdName });
    };

    const changeNameProduct = () => {
        const productId = 1 + Math.floor(Math.random() * 3);
        let rdName = Math.random() + "__new name product";

        let newProducts = products.map((product) => {
            if (product.id === productId) {
                return { ...product, name: rdName };
            }
            return product;
        });
        setProducts(newProducts);
    };

    const handleShow = () => {
        setShow(!show);
    };

    return (
        <>
            <h1>Counter : {count}</h1>
            <button onClick={increment}>Tăng</button>
            <button onClick={decrement}>Giảm</button>

            <hr />

            <h2>Id : {user.id}</h2>
            <h2>Name : {user.name}</h2>
            <h2>Email : {user.email}</h2>
            <button onClick={changeName}>Change Name</button>

            <hr />

            <h2>Product</h2>

            <ul>
                {products.map((product) => (
                    <li key={product.id}>
                        {product.id} - {product.name}
                    </li>
                ))}
            </ul>

            <button onClick={changeNameProduct}>Change Name Product</button>

            <hr />

            {show && (
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Impedit optio quos quaerat veniam ullam, praesentium iure
                    odit maiores fuga aut officia eligendi nisi vel labore velit
                    quae quibusdam qui molestiae.
                </p>
            )}

            <button onClick={handleShow}>{show ? "Hide" : "Show"}</button>

            {console.log("render")}
        </>
    );
}

export default Counter;
