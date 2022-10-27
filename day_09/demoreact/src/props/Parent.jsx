import React  from "react";
import Child from "./Child";


//props : là các dât đc truyền từ cha -> con (k có chiều ngược lại)
// props có thể là kiểu dữ liệu cơ bản : numver, string , ararry, ob,.. kể cả function
//component có thể có thể lấy ra data dựa trên obj "props"
// muốn truyền dữ liệu con -> cha 
// + cha cần gửi xuống 1 function
// + "con" nhận function đó tù trong props đẻ truyền dữ liệu lại
function Parent(){

    const hello = () =>{
        console.log("Hello");
    };

    const random = (number) =>{
        console.log("paren : ", number);
    }

    return(
        <>
            <h1>Parent</h1>
            <Child 
                name={"Đặng Hồng Tư"}
                age = {20}
                numbers={[1,1,11,21]}
                onHello={hello}
                onRandom = {random}
            />

        </>
    )
}
export default Parent;