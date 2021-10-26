const util = require('util');
const fs = require('fs');

var read = util.promisify(fs.readFile);

Promise.all(
  readFile('text1.txt'),
  readFile('text2.txt'),
  readFile('text3.txt')
).then(data => {
  let [data1, data2, data3] = data;
});
