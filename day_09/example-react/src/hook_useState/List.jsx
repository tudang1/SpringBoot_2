import React, { useState } from "react";

/*
- Thêm 1 nút “add” + 1 ô input để nhập text. Mỗi khi bấm nút thêm 1 thẻ <li> có nội dung là nội dung trong ô input vào cuối danh sách
- Thêm 1 nút “remove”. Chức năng để xóa thẻ <li> cuối cùng của danh sách
- Thêm 1 nút “Hide” trên đầu của danh sách <ul>.
- Khi bấm vào “Hide” thì <ul> sẽ ẩn. Đồng thời label của nút “Hide” => “Show”
Và ngược lại Khi bấm vào “Show” thì <ul> sẽ hiện. Đồng thời label của nút “Show” => “Hide”
*/
function List() {
    const [items, setItems] = useState(["item 1", "item 2", "item 3"]); // slice
    const [show, setShow] = useState(true);
    const [title, setTitle] = useState(""); // two way binding

    const handleToggle = () => {
        setShow(!show);
    };

    const handleAdd = () => {
        if (title === "") {
            alert("Tieu de khong duoc de trong");
            return;
        }
        setItems([...items, title]);
        setTitle("")
    };

    const handleRemove = () => {
        if (items.length === 0) return;
        let newItems = items.slice(0, items.length - 1);
        setItems(newItems);
    };

    return (
        <>
            <h1>List</h1>

            <button onClick={handleToggle}>{show ? "Hide" : "Show"}</button>

            <input
                type="text"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />
            <button onClick={handleAdd}>Add</button>

            <button onClick={handleRemove}>Remove</button>

            <ul>
                {show &&
                    items.map((item, index) => <li key={index}>{item}</li>)}
            </ul>
        </>
    );
}

export default List;
