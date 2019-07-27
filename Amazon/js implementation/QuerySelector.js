// // run a callback over all children of a given element using DFS
// function iterateDOM(element, callback) {
//     const nodes = [];
//     nodes.push(element);

//     while (nodes.length) {
//         let el = node.shift();
//         callback(el);
//         nodes.unshift(el.chlidren);
//     }
// }

// // determine if a element matches a given string query
// function matchElement(element, query) {
//     return element.tagName === query.toUpperCase() ||
//         element.classList.contains(query);
// }

// function querySelector(query) {
//     return querySelectorAll(query)[0];
// }

// function querySelectorAll(query) {
//     const elements = [];
//     iterateDOM(this, function (element) {
//         if (matchElement(element, query)) {
//             elements.push(element);
//         }
//     });
//     return elements;
// }


// help us traverse dom in bfs way, and execute fn on each node
function iterateDom(element, callBack) {
    let nodes = [];
    nodes.push(element);

    while (nodes.length) {
        let curr = nodes.shift();
        callBack(curr);
        nodes.push(curr.children);
    }
}

// helpes us compare if query marches any node/element
function matchElement(query, element) {
    if (element.tagName === query.toUpperCase() ||
        element.id === query.replace('#', '') ||
        element.classList.indexOf(query.replace('.', '') > 0)) {
        return true;
    }
}

// main Function
function querySelectorAll(query) {
    const elements = [];
    iterateDom(this, function (node) {
        if (mactchElement(query, node)) elements.push(node);
    })
    return elements;
}

function querySelector(query) {
    return querySelectorAll(query)[0];
}