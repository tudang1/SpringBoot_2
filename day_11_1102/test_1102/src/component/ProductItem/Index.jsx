import React from "react";
import { useState } from "react";
import { cartItems } from "../../data";

function ProductItem(props) {
  const { id, name, image, price, count, size ,onTru,onCong , onDelete} = props;
  // const [product,setProduct] = useState(props);
  const tru = (id) =>{
    // console.log(count);
    onTru(id);
  };
  const cong = (id) =>{
    // console.log(count);
    onCong(id);
  };
  const handleDelete = (id)=>{
    onDelete(id);
  };

  
  return (
    <div className="product-item d-flex border mb-4">
      <div className="image">
        <img
          src={image}
        />
      </div>
      <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
        <div>
          <div className="d-flex justify-content-between align-items-center">
            <h2 className="text-dark fs-5 fw-normal">{name}</h2>
            <h2 className="text-dark fs-5 fw-normal">{size}</h2>
            <h2 className="text-danger fs-5 fw-normal">{price}</h2>
          </div>
          <div className="text-black-50">
            <div className="d-inline-block me-3">
              <button className="border py-2 px-3 d-inline-block fw-bold bg-light"
                onClick={()=>tru(id)}
              >
                -
              </button>
              <span className="py-2 px-3 d-inline-block fw-bold">{count}</span>
              <button className="border py-2 px-3 d-inline-block fw-bold bg-light"
                onClick={()=>cong(id)}
              >
                +
              </button>
            </div>
          </div>
        </div>
        <div>
          <button className="text-primary border-0 bg-transparent fw-light"
            onClick={() => handleDelete(id)}
          >
            <span>
              <i className="fa-solid fa-trash-can"></i>
            </span>
            Xóa
          </button>
        </div>
      </div>
    </div>
  );
}
export default ProductItem;