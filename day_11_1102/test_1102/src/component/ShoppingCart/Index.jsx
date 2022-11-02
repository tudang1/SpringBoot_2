import React, { useState } from "react";
import BillInformation from "../bill/Index";
import ProductList from "../ProductList/Index";
import style from "./style.css";
import { cartItems } from "../../data";

function ShoppingCart() {
  const [items, setItems] = useState(cartItems);

  const tru = (count) =>{
    
    console.log("cha" +count);
    
  };
  const cong = (count) =>{
    console.log("cha" + count);
  };

  return (
    <div class="shopping-cart-container mt-5">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="mb-4">
              <h2>Shopping Cart</h2>
            </div>
          </div>
        </div>

        {/* <p class="fst-italic message">Không có sản phẩm trong giỏ hàng</p> */}
        <div class="row shopping-cart">
          <div class="col-md-8">
            {items.length === 0 && (
              <li>Không có sản phẩm nào trong giỏ hàng</li>
            )}
            {items.length > 0 &&(
              <ProductList 
                onItems = {items}
                onCong ={cong}
                onTru ={tru}
              />
            )}
          </div>
          <BillInformation />
        </div>
      </div>
    </div>
  );
}
export default ShoppingCart;
