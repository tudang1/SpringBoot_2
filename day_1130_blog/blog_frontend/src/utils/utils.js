export const convertDate = (dateString) => {
    let date = new Date(dateString);

    let year = date.getFullYear();
    let month = `0${date.getMonth()+1}`.slice(-2);
    let day = `0${date.getDay()+1}`.slice(-2);

    return `${day}/${month}/${year}`;

}
