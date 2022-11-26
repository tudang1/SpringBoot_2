/*
action (là obj) {
    type: kiểu hành động là gì(bắt buộc)
    payload: thông tin gửi đẻ thay đổi state(optional)
}
action creator: function trả về action(obj)

*/

export const increment = () => {
    return {
        type : "counter/increment"
    }
}

export const decrement = () => {
    return {
        type : "counter/decrement"
    }
}