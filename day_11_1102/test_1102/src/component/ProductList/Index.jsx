import React from "react";
import { useState } from "react";
import ProductItem from "../ProductItem/Index";

function ProductList({ onItems, onCong, onTru, onDelete}) {

  return (
    // console.log(onItems)
    <div>
      {onItems.map((item) => (
        <ProductItem
          key = {item.id}
          id={item.id}
          name={item.name}
          image={item.image}
          price={item.price}
          count={item.count}
          size={item.size}
          onCong={onCong}
          onTru={onTru}
          onDelete = {onDelete}
        />
      ))}
    </div>
  );
}
export default ProductList;
