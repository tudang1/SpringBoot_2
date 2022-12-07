// Lưu dữ liệu vào localStorage
export const saveDataToLocalStorage = (key, value) => {
    localStorage.setItem(key, JSON.stringify(value));
}

// Lấy dữ liệu từ localStorage
export const getDataFromLocalStorage = key => {
    const localStorageValue = localStorage.getItem(key);
    if (localStorageValue) {
        return JSON.parse(localStorageValue);
    }
    return null;
}
