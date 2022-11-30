import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { decrement, increment } from '../../app/slices/counterSlice';

function Counter() {
    const counter = useSelector((state) => state.counter);

    const dispatch = useDispatch();

    //xu ly tang
    const incrementCounter =() =>{
        dispatch(increment());

    }

    //xu ly giam
    const decrementCounter =() =>{
        dispatch(decrement());
    }

  return (
    <>
        <h2>Counter : {counter}</h2>

        <button onClick={incrementCounter}>Tang</button>
        <button onClick={decrementCounter}>Giam</button>

    </>
  )
}

export default Counter