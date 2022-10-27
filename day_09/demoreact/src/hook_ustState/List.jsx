import React,{useState} from "react";

// Thêm 1 nút “add” + 1 ô input để nhập text. Mỗi khi bấm nút thêm 1 thẻ <li> có nội dung là nội dung trong ô input vào cuối danh sách
// Thêm 1 nút “remove”. Chức năng để xóa thẻ <li> cuối cùng của danh sách
// Thêm 1 nút “Hide” trên đầu của danh sách <ul>.
// Khi bấm vào “Hide” thì <ul> sẽ ẩn. Đồng thời label của nút “Hide” => “Show”
// Và ngược lại Khi bấm vào “Show” thì <ul> sẽ hiện. Đồng thời label của nút “Show” => “Hide”
function List() {
    const [items , setItem] = useState(["item1","item 2", "item 3"]);
    const [title,setTilte] = useState("");
    const [show,setShow]= useState(true);
    
    const handleShow = () =>{
        setShow(!show);
    };
    const handleRemove = () =>{
        if(items.length === 0) return;
        let newItem = items.slice(0,items.length -1);
        setItem(newItem);
    }
    const add=()=>{
        if(title === ""){
            alert("tieu de k hop le");
            return;
        }
        setItem([...items,title]);
        setTilte("")
    }

    return(
        <>
            <h1>list</h1>
            <button onClick={handleShow}>{show ? "hide" :"show"}</button>

            <input 
                type="text" 
                value={title} 
                onChange ={(e) => setTilte(e.target.value)} 
            />
            <button onClick={add}>Add</button>

            <button onClick={handleRemove}>Remove</button>
            <ul>
               {show && items.map((item,index) => <li key = {index}>item</li>)}
            </ul>

        </>
    )
}
export default List