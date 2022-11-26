import React from 'react'
import { useState } from 'react';
import { cartItems } from '../../data';
import ProductList from './ProductList';
import BillInformation from './BillInfomation';
import { useDispatch } from 'react-redux';
import style from "./style.css";
import { useSelector } from 'react-redux';
import { subtractCountProduct } from '../../redux/action/shoppingCartAction';

function ShoppingCart() {
  const [items, setItems] = useState(cartItems);

  // Lấy ra dữ liệu từ state
  const counterShoppingCart = useSelector((state) => state.shoppingCarts.count);

  // Dùng để dispatch action
  const dispatch = useDispatch();

  // Xử lý giảm
  const decrementCounter = (id) => {
    dispatch(subtractCountProduct(id));
  };


//cộng
const cong = (id) => {
  // Tìm kiếm item dựa trên id
  let currentItem = items.find((item) => item.id === id);

  let currentCount = currentItem.count + 1;

  // Cập nhật trong state ban đầu
  const newItem = items.map((item) => {
    if (item.id === id) {
      return { ...item, count: currentCount };
    }
    return item;
  }); // Spread Operator (ES6)

  setItems(newItem);
};
// xóa
const handleDelete = (id) => {
  console.log(id);
  let choice = window.confirm("Bạn có muốn xóa không?");
  if (choice == true) {
    setItems((current) =>
    current.filter((employee) => {
      return employee.id !== id;
    })
  );
  } else {
    return;
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
          {items.length === 0 && (
            <li>Không có sản phẩm nào trong giỏ hàng</li>
          )}
          {items.length > 0 && (
            <ProductList
              onItems={items}
              onCong={cong}
              onTru={decrementCounter}
              onDelete={handleDelete}
            />
          )}
        </div>
        <BillInformation 
          onItems={items}
        />
      </div>
    </div>
  </div>
  );
}

export default ShoppingCart