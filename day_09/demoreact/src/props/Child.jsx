import React from "react";
//props : laf Opject chứa dât nhận từ component cha
function Child(props){
    // console.log(props);

    const {name,age,numbers,onHello,onRandom} = props;

    const handleRandom = () =>{
        let rNumber = Math.floor(Math.random()*1000);
        onRandom(rNumber);
    }
    return(
        // <div>   
        //     <h1>{props.name}</h1>
        //     <h1>{props.age}</h1>
        //     <h1>{props.numbers}</h1>
        // </div>
         <div>   
         <h1>{name}</h1>
         <h1>{age}</h1>
         <h1>{numbers}</h1>
         <button onClick={onHello}>Click me</button>
         <button onClick={handleRandom}>Random</button>
     </div>
    
    );

}
export default Child;