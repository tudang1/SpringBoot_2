import { combineReducers } from "redux";
import counterReducer from "./counterReducer";
import todoReducer from "./todoReducer";
import shoppingCartReducer from "./shoppingCartReducer";

const rootReducer = combineReducers({
    counter : counterReducer,
    todos : todoReducer,
    shoppingCarts : shoppingCartReducer
})

export default rootReducer