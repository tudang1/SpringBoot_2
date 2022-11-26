import { cartItems } from "../../data";

// const [initialState,setInitialState] = useState(cartItems);
const initialState = [
  {
    id: 1,
    name: "Sản phẩm 1",
    image:
      "https://images.unsplash.com/photo-1564584217132-2271feaeb3c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    price: 100000,
    count: 1,
    size: "M",
  },
  {
    id: 2,
    name: "Sản phẩm 2",
    image:
      "https://images.unsplash.com/photo-1564584217132-2271feaeb3c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    price: 200000,
    count: 2,
    size: "L",
  },
  {
    id: 3,
    name: "Sản phẩm 3",
    image:
      "https://images.unsplash.com/photo-1564584217132-2271feaeb3c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
    price: 300000,
    count: 1,
    size: "S",
  },
];

const shoppingCartReducer = (state = initialState, action) => {
//   console.log(action);

  switch (action.type) {
    case "shoppingCart/addCountProduct": {
      // Cập nhật và return state mới vào đây
      // Tìm kiếm item dựa trên id
      let currentItem = state.find((item) => item.id === action.payload);

      let currentCount = currentItem.count + 1;
    
        // Cập nhật trong state ban đầu
        const newState = state.map((item) => {
            if (item.id === action.payload) {
            return { ...item, count: currentCount };
            }
            return item;
        }); // Spread Operator (ES6)

        return newState;
    }
    case "shoppingCart/subtractCountProduct": {
      // Tìm kiếm item dựa trên id
      let currentItem = state.find((item) => item.id === action.payload);

      let currentCount = currentItem.count - 1;
    
        // Cập nhật trong state ban đầu
        const newState = state.map((item) => {
            if (item.id === action.payload) {
            return { ...item, count: currentCount };
            }
            return item;
        }); // Spread Operator (ES6)

        return newState;
    }
    case "shoppingCart/deleteProduct": {
        const newState = state.filter(item => item.id !== action.payload);

        return newState;
    }
    default: {
      return state;
    }
  }
};

export default shoppingCartReducer;
