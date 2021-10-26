/*
1) Prefix search：举个例子，输入“bur”要返回所有以bur开头的business names，比如“Burge‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‍r King”，注意一个business name可能有多个word，“XXX Burger”也算满足条件。
    比如输入"bur"返回"Bu‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‍rger King", "kdk dnsd Burgers", "sad Burger's"， 返回的顺序无所谓
2) Non-prefix search：只要business name里包含关键词就返回。
    返回"Burger King", "kdk dnsd Burgers", "sad Burger's", "Walburgers"

楼主思路如下：1. prefix 用brute force或者建prefix tree，和面试官讨论最后她说用brute force写。
                        2. KMP
最后面试官没让我写第二问，只问了时间复杂度。
*/

const data = [
  'Burger King',
  'kdk dnsd Burgers',
  "sad Burger's",
  'asdd das a',
  'Walburgers'
];

function prefixSearch(list, prefix) {
  let result = [];
  for (let bussName of list) {
    if (isPrefix(bussName, prefix)) result.push(bussName);
  }
  return result;
}

function isPrefix(bussName, prefix) {
  wordList = bussName.toLowerCase().split(' ');
  prefix = prefix.toLowerCase();

  for (let word of wordList) {
    if (word.length >= prefix.length) {
      let i = 0;
      while (i < prefix.length) {
        if (prefix[i] !== word[i]) {
          break;
        }
        i++;
      }
      if (i === prefix.length) return true;
    }
  }
  return false;
}

// console.log(prefixSearch(data, 'wal'));

function subStringSearch(list, pattern) {
  let result = [];
  for (let bussName of list) {
    let wordList = bussName.toLowerCase().split(' ');
    let isFound = false;
    for (let word of wordList) {
      if (hasSubstring(word, pattern)) {
        isFound = true;
        break;
      }
    }
    if (isFound) result.push(bussName);
  }
  return result;
}

function hasSubstring(word, pattern) {
  let i = 0;
  let j = 0;
  let k = 0;

  // pattern: bur
  //             j
  // Walburgers
  //    k
  //       i
  while (i < word.length && j < pattern.length) {
    if (word[i] == pattern[j]) {
      i++;
      j++;
    } else {
      j = 0;
      k++;
      i = k;
    }
  }
  if (j == pattern.length) {
    return true;
  }
  return false;
}

function kmp(text, pattern) {
  let arr = buildKmp(pattern);
  let i = 0;
  let j = 0;
  while (i < text.length && j < pattern.length) {
    if (text[i] === pattern[j]) {
      i++;
      j++;
    } else {
      if (j != 0) {
        j = arr[j - 1];
      } else {
        i++;
      }
    }
  }

  if (j === pattern.length) return true;
  return false;
}

function buildKmp(pattern) {
  let kmpArr = new Array(pattern.length).fill(0);
  let patArr = pattern.split('');

  let i = 0;
  for (let j = 1; j < patArr.length; ) {
    if (pattern[i] === pattern[j]) {
      kmpArr[j] = i + 1;
      i++;
      j++;
    } else {
      if (i !== 0) {
        i = kmpArr[i - 1];
      } else {
        kmp[j] = 0;
        j++;
      }
    }
  }
  return kmpArr;
}

console.log(subStringSearch(data, 'ger'));
