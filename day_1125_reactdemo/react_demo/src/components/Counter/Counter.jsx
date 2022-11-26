import React from 'react'
import { useDispatch, useSelector } from "react-redux";
import { decrement,increment } from '../../redux/action/CounterAction';

function Counter() {
  // Lấy ra dữ liệu từ state
  const counter = useSelector((state) => state.counter);

  // Dùng để dispatch action
  const dispatch = useDispatch();

  // Xử lý tăng
  const incrementCounter = () => {
      dispatch(increment());
      // dispatch({
      //     type : "counter/increment"
      // })
  };

  // Xử lý giảm
  const decrementCounter = () => {
      dispatch(decrement());
  };

  return (
      <>
          <h2>Counter : {counter}</h2>

          <button onClick={incrementCounter}>Tăng</button>
          <button onClick={decrementCounter}>Giảm</button>
      </>
  );
}

export default Counter;