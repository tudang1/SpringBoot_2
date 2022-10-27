import React from "react";
import Child from "./Child";

/*
+ props : Là các data được truyền từ cha --> con (k có chiều ngược lại)
+ props có thể là các kiểu dữ liệu cơ bản : number, string, array, object, ... kể cả function
+ component con có thể lấy ra data dựa trên object "props", hoặc sử dụng Destructuring assignment (ES6)
+ Muốn truyền dữ liệu từ con --> cha
    - "cha" cần gửi xuống 1 function
    - "con" nhận function đó từ trong props để truyền dữ liệu lên
*/

function Parent() {
    const hello = () => {
        console.log("Hello");
    };

    const random = (number) => {
        console.log("parent : ", number);
    };

    return (
        <>
            <h1>Parent</h1>
            <Child
                name={"Nguyễn Văn A"}
                age={25}
                numbers={[1, 2, 3, 4, 5]}
                onHello={hello}
                onRandom={random}
            />
        </>
    );
}

export default Parent;
