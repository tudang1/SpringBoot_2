/*
- Reducer (wrire): dựa vào state hiện tại và action gửi lên => để giải quyết
định xem thay đổi state ntn
*/

const initialState = 0;

const counterReducer = (state = initialState, action) => {
    switch (action.type) {
        case "counter/increment": {
            return state + 1;
        }
        case "counter/decrement": {
            return state - 1;
        }
        default: {
            return state;
        }
    }
}

export default counterReducer;
