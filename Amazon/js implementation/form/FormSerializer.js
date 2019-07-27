const formToJson = elements => [].reduce.call(elements, (data, element) => {

    // validation 
    if (isValidElement(element) && isValidValue(element)) {

        if (element.type === 'checkbox') {
            // check box
            data[element.name] = (data[element.name] || []).concat(element.value)

        } else if (element.options && element.multiple) {
            // multiselect
            data[element.name] = getMultiSelval(element);
        } else {
            data[element.name] = element.value;
        }
    }
    return data;
}, {})

const getMultiSelval = options => [].reduce.call(options, (data, option) => {
    return option.selected ? data.concat(option.value) : data;
}, [])