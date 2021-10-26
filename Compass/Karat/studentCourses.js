function course(list) {
  let map = {};
  let res = {};
  for (let item of list) {
    let [id, course] = item;
    if (map[id] == undefined) map[id] = [];
    map[id] = [...map[id], course];
  }

  let keyList = Object.keys(map);
  for (let i = 0; i < keyList.length; i++) {
    for (let j = i + 1; j < keyList.length - 1; j++) {
      for (let c of map[i]) {
        if (map[j].indexOf(c) > -1) {
          if (res[(keys[i], keys[j])] == undefined)
            res[(keys[i], keys[j])] = [];
          res[(keys[i], keys[j])] = [...res[(keys[i], keys[j])], c];
        }
      }
    }
  }
  return res;
}

function findShared(records) {
  let students = new Set();
  let courseStudents = new Map();

  for (let record of records) {
    courseStudents.set(record[1], ((courseStudents.get(record[1]) || []).push(record[0])));
    students.add(record[0]);
  }

  let sharedCourse = {};
  let studentList = [...students];

  for (let i = 0; i < studentList.length; i++) {
    for (let j = i + 1; j < studentList.length; j++) {
      sharedCourse[[studentList[i], studentList[j]]] = [];
    }
  }

  courseStudents
}
