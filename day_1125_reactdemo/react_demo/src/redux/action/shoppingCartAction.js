//tăng
export const addCountProduct = (id) =>{
    return {
        type : "shoppingCart/addCountProduct",
        payload : id
    }
}
//giảm
export const subtractCountProduct = (id) =>{
    return {
        type : "shoppingCart/subtractCountProduct",
        payload : id
    }
}
//xóa
export const deleteProduct = (id) =>{
    return {
        type : "shoppingCart/deleteProduct",
        payload: id
    }
}
