function fakeAjax(url, cb) {
  const fake_response = {
    file1: 'the first text',
    file2: 'the middle text',
    file3: 'the last text'
  };
  let randomDelay = (Math.round(Math.random() * 1e4) % 8000) + 1000;

  setTimeout(() => {
    cb(fake_response[url]);
  }, randomDelay);
}

function output(text) {
  console.log(text);
}

function getFile(file) {
  return new Promise(resolve => {
    fakeAjax(file, resolve);
  });
}

let p1 = getFile('file1');
let p2 = getFile('file2');
let p3 = getFile('file3');
