const jsonToForm = (obj, form) => {
    let formData = form || new FormData();
    // let len = Object.keys(obj).length;

    for (let prop in obj) {
        if (obj.hasOwnProperty(prop)) {
            // handle nested obj
            if (typeof obj[prop] === 'object') {
                jsonToForm(obj[prop], formData);
            } else {
                formData.append(prop, obj[prop]);
            }
        }
    }
    return formData;
}