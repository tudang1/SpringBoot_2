import React, {useState} from "react"
import "./Counter.css"
function Counter(){
    const [count , setCount] = useState(0);
    const [color, setColor] = useState("#333333");

    const tru= ()=>{
        setCount(count -1);
    }
    const cong = ()=>{
        setCount(count +1);
    }
    return(
        <div class="main-container">
            <h1 className="title">Đếm số</h1>
            <h1 id="counter" style={{color : count ===0 ? "black" : count > 0 ? "green" : " red"}}>{count}</h1>
            <div className="btn-container">
                <button className="btn counterBtn prevBtn" onClick={tru}>Trừ</button>
                <button className="btn counterBtn nextBtn" onClick={cong}>Cộng</button>
            </div>
        </div>
    )
}
export default Counter;