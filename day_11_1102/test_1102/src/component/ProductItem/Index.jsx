import React from "react";
import { useState } from "react";
import { cartItems } from "../../data";

function ProductItem(props) {
  const { id, name, image, price, count, size ,onTru,onCong} = props;
  // const [product,setProduct] = useState(props);
  const tru = (count) =>{
    // console.log(count);
    onTru(count);
  };
  const cong = (count) =>{
    // console.log(count);
    onCong(count);
  };

  
  return (
    <div class="product-item d-flex border mb-4">
      <div class="image">
        <img
          src={image}
        />
      </div>
      <div class="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
        <div>
          <div class="d-flex justify-content-between align-items-center">
            <h2 class="text-dark fs-5 fw-normal">{name}</h2>
            <h2 class="text-dark fs-5 fw-normal">{size}</h2>
            <h2 class="text-danger fs-5 fw-normal">{price}</h2>
          </div>
          <div class="text-black-50">
            <div class="d-inline-block me-3">
              <button class="border py-2 px-3 d-inline-block fw-bold bg-light"
                onClick={()=>tru(count)}
              >
                -
              </button>
              <span class="py-2 px-3 d-inline-block fw-bold">{count}</span>
              <button class="border py-2 px-3 d-inline-block fw-bold bg-light"
                onClick={()=>cong(count)}
              >
                +
              </button>
            </div>
          </div>
        </div>
        <div>
          <button class="text-primary border-0 bg-transparent fw-light">
            <span>
              <i class="fa-solid fa-trash-can"></i>
            </span>
            Xóa
          </button>
        </div>
      </div>
    </div>
  );
}
export default ProductItem;