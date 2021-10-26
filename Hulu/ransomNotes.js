/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
  let arr = new Array(26).fill(0);
  for (let i = 0; i < A.length; i++) {
    arr[magazine.charAt(i) - 'a']++;
  }

  for (let i = 0; i < ransomNote.length; i++) {
    if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
      return false;
    }
  }
  return true;
};

var canConstruct2 = function(ransomNote, magazine) {
  for (let i = 0; i < ransomNote.length; i++) {
    let index = magazine.indexOf(ransomNote[i]);
    if (index >= 0) {
      // magazine = magazine.slice(0,index)+magazine.slice(index+1);
      magazine = magazine.splice(index, 1);
    } else {
      return false;
    }
  }
  return true;
};
