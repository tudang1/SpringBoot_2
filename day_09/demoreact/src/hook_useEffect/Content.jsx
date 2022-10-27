import React,{useState} from "react";
import { useEffect } from "react";

function Content(){
//1.useEffect(callback)
//ddc gọi mỗi lần reREnder

    // useEffect(() =>{
    //     console.log("userEffect");
    // });

//2. useEffect(callback,[])
    // useEffect(() =>{
    //     console.log("userEffect []");
    // },[]);

//3 useEffect(callback, [deps])
    const [count , setCount] = useState(0);
    const [count2 , setCount2] = useState(0);

    

   
    const increment = () =>{
        setCount(count +1);
    };
    const decrement = () =>{ 
        setCount(count -1);
   
    };
    const increment2 = () =>{
        setCount2(count2 +1);
    };
    const decrement2 = () =>{ 
        setCount2(count2 -1);
   
    };


    return (
        
        <div>
            <h1>Counter : {count}</h1>
            <button onClick={increment}>Tăng</button>
            <button onClick={decrement}>Giảm</button>
            <hr />
            <h1>Counter2 : {count2}</h1>
            <button onClick={increment2}>Tăng</button>
            <button onClick={decrement2}>Giảm</button>
        </div>
    )
}

export default Content