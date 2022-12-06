// Chuyển chuỗi ngày tháng sang định dạng dd/mm/yyyy
export const convertDate = (dateString) => {
    let date = new Date(dateString);

    let year = date.getFullYear();
    let month = `0${date.getMonth() + 1}`.slice(-2); // 0 -> 11 || 012 -> 12, 01 -> 01, 02 -> 02
    let day = `0${date.getDate()}`.slice(-2); // 1 -> 31 || 01 -> 01, 011 -> 11, 021 -> 21, 031 -> 31

    return `${day}/${month}/${year}`;
}