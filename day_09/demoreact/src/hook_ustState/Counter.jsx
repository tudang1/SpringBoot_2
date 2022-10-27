import React,{useState} from "react";


//mount: khi component đc gắn vào DOM
//unmount : khi component bị loại bỏ khỏi DOM
function Counter(){
    const [count , setCount] = useState(0);
    const [user , setUser] = useState({
        id:1,
        name : "nguyen huong l",
        email : "l@gmail.com",
    });

    const [products, setProduct] = useState([
        {id:1,name:"product1"},
        {id:2,name:"product2"},
        {id:3,name:"product3"}

    ]);

    const increment = () =>{
        setCount(count +1);
    };
    const decrement = () =>{
        console.log("prev count = ",count);
        setCount(count -1);
        console.log("next count = ", count);
    };

    const changeName = () =>{
        let rName = Math.random() + "new name";
        setUser({...user,name:rName});
    };

    const changeNameProduct =()=>{
        const productId = 1+ Math.floor(Math.random()*3);
        const rName = Math.random() + "new name product";
        let newProducts = products.map(product =>{
            if(product.id === productId){
                return {...product,name : rName};
            }
            return product;
        });
        setProduct(newProducts);
    };

    const [show,setShow] = useState(true);
    const handleShow = () =>{
        setShow(!show);
    };

    return(
        <>
        <h1>Counter : {count}</h1>
        <button onClick={increment}>Tăng</button>
        <button onClick={decrement}>Giảm</button>
        <hr />
        <h2>id : {user.id}</h2>
        <h2>name: {user.name}</h2>
        <h2>email : {user.email}</h2>

        <button onClick={changeName}>ChangeName</button>

        <hr />
        <h2>Product</h2>
        <ul>
            {products.map((product) =>(
                <li key={product.id}>
                    {product.id} - {product.name}
                </li>
            ))}
        </ul>
        <button onClick={changeNameProduct}>ChangeName</button>

        <hr />

        {show &&(<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ullam, ad. Nihil quis, esse, voluptates libero, tempore quas maiores eaque nisi nobis facilis atque deserunt inventore? Veniam voluptates sequi ea dolore.</p>
        )}

        <button onClick={handleShow}>{show ? "hide" :"show"}</button>
        {console.log("render")}
        </>
    )
}
export default Counter;