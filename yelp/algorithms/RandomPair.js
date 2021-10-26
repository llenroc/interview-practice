class Person {
  constructor(name, team) {
    this.name = name;
    this.team = team;
  }
}

// const data1 = ['a', 'b', 'c', 'd', 'e'];
const data2 = [
  new Person('a', 'A'),
  new Person('b', 'B'),
  new Person('c', 'A'),
  new Person('d', 'B'),
  new Person('e', 'C')
];

// const matchBeans = people => {
//   const randGetPeople = (lastIdx, team) => {
//     if (
//       people.filter((p, idx) => p.team !== team && idx <= lastIdx).length <= 0
//     )
//       return null;
//     let p = Math.floor(Math.random() * (lastIdx + 1));
//     while (people[p].team === team) {
//       p = Math.floor(Math.random() * (lastIdx + 1));
//     }
//     const v = people[p];
//     [people[lastIdx], people[p]] = [people[p], people[lastIdx]];
//     return v;
//   };

//   const ret = [];
//   let lastIdx = people.length - 1;
//   while (lastIdx > 0) {
//     const one = randGetPeople(lastIdx--);
//     const two = randGetPeople(lastIdx--, one.team);
//     ret.push([one, two]);
//     if (!two) lastIdx++;
//   }
//   if (lastIdx === 0) {
//     ret.push([people[lastIdx], null]);
//   }
//   return ret;
// };

function getRandom(people) {
  //edge cases
  if (!people || !people.length) return [];

  let len = people.length;
  let result = [];
  let max = len - 1; // last position index;
  while (max > 0) {
    const first = getPerson(max--);
    const second = getPerson(max--, first.team);
    if (!second) max++; // if no team match found, offset the max we decremented

    result.push([first, second]);
  }
  if (max === 0) {
    result.push([people[max], null]);
  }

  return result;

  // randomly get a person
  function getPerson(end, team) {
    if (team) {
      if (!people.filter((p, i) => p.team !== team && i <= end).length)
        return null;
    }

    let randIndex = Math.floor(Math.random() * (end + 1));
    while (team && people[randIndex].team === team) {
      randIndex = Math.floor(Math.random() * (end + 1));
    }
    let person = people[randIndex];

    // in place swap to make sure it wont be selected again
    swap(randIndex, end);
    return person;
  }

  function swap(a, b) {
    let tmp = people[a];
    people[a] = people[b];
    people[b] = tmp;
  }
}

console.log(getRandom(data2));
