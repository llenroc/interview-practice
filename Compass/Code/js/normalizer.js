const rowData = [
  {
    title: 'Animals',
    children: [
      {
        title: 'dog',
        children: [
          {
            title: 'Pitbull',
            children: [
              {
                title: 'Englist Picbull',
                children: null
              },
              {
                title: 'Franch Picbull',
                children: null
              },
              {
                title: 'Chinsee Picbull',
                children: null
              }
            ]
          }
        ]
      },
      {
        title: 'cats',
        children: [
          {
            title: 'miemie',
            children: [
              {
                title: 'Englist miemie',
                children: null
              },
              {
                title: 'Franch miemie',
                children: null
              },
              {
                title: 'Chinsee miemie',
                children: null
              }
            ]
          },
          {
            title: 'miao miao',
            children: null
          }
        ]
      }
    ]
  }
];

function normalizer(dataList) {
  //base cases
  if (!dataList) return;
  let obj = {};

  for (let itemObj in dataList) {
    for (let prop of itemObj) {
      if (itemObj.hasOwnProperty(prop)) {
        if (typeof itemObj[prop] === String) {
          obj[itemObj[prop]] = {};
        } else if (typeof itemObj[prop] === Array) {
          obj[itemObj[prop]];
        }
      }
    }
  }
}

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
};
