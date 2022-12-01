import React, {useState} from "react"

function Box(){
    const initialColor = [
        '#3498db',
        '#9b59b6',
        '#e74c3c',
        '#2c3e50',
        '#d35400',
    ];

    const [colors, setColors] = useState(initialColor);

    const addMoreBox = ()=>{
        setColors([...colors,...initialColor]); //spread operator(ES6)
    }
    const deleteBox = (index) =>{
        let newColors =colors.filter((colors,i) => i !== index);
        setColors(newColors);
    }

    return (
        <>
        <div class="wrap">
            <h1> JS DOM</h1>
            <button id="btn" onClick={addMoreBox}>More boxes</button>
            <h4 id="score">
                 Total box:<span class="points">{colors.length}</span>
            </h4>

            <div class="boxes">
                {colors.map((color,index) =>{
                    <div 
                    key = {index}
                    ></div>
                })}
            </div>
        </div>
        </>
        
    )
}