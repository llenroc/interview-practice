var removeDuplicateLetters = function(s) {
  let dict = new Array(26);
  dict.fill(0);
  let builder = '';

  for (let i = 0; i < s.length; i++) {
    let charCode = s[i].charCodeAt(0) - 'a'.charCodeAt(0);
    dict[charCode]++;
    if (dict[charCode] != 1) continue;
    builder += s[i];
  }
  return builder;
};
