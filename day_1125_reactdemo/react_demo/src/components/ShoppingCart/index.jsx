import React from 'react'
import { useState } from 'react';
import ProductList from './ProductList';
import BillInformation from './BillInfomation';
import { useDispatch } from 'react-redux';
import style from "./style.css";
import { useSelector } from 'react-redux';
import { subtractCountProduct,addCountProduct,deleteProduct } from '../../redux/action/shoppingCartAction';

function ShoppingCart() {
 // Lấy ra dữ liệu từ state
 const shoppingCartItems = useSelector((state) => state.shoppingCarts);
  console.log(shoppingCartItems);
  // Dùng để dispatch action
  const dispatch = useDispatch();

  // Xử lý giảm
  const decrementCounter = (id) => {
    // Tìm kiếm item dựa trên id
    let currentItem = shoppingCartItems.find((item) => item.id === id);

    if (currentItem.count === 1) {
      alert("Tăng đê");
      return;
    }
    dispatch(subtractCountProduct(id));
  };


//cộng
const incrementCounter = (id) => {
   dispatch(addCountProduct(id));
};
// xóa
const handleDelete = (id) => {
  // Cần confirm trước khi xóa (window.confirm)
  const inDelete = window.confirm("Có muốn xóa k?");

  if(inDelete){
     dispatch(deleteProduct(id));
  }
};
  

  return (
    <div className="shopping-cart-container mt-5">
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <div className="mb-4">
            <h2>Shopping Cart</h2>
          </div>
        </div>
      </div>

      {/* <p className="fst-italic message">Không có sản phẩm trong giỏ hàng</p> */}
      <div className="row shopping-cart">
        <div className="col-md-8">
          {shoppingCartItems.length === 0 && (
            <li>Không có sản phẩm nào trong giỏ hàng</li>
          )}
          {shoppingCartItems.length > 0 && (
            <ProductList
              onItems={shoppingCartItems}
              onCong={incrementCounter}
              onTru={decrementCounter}
              onDelete={handleDelete}
            />
          )}
        </div>
        <BillInformation 
          onItems={shoppingCartItems}
        />
      </div>
    </div>
  </div>
  );
}

export default ShoppingCart