class Meal {
  constructor(name, ingredients) {
    this.name = name;
    this.ingredients = ingredients;
  }
}

const input = [
  new Meal('a', ['a', 'b', 'c']),
  new Meal('b', ['B', 'A', 'c']),
  new Meal('c', ['e', 'b', 'c']),
  new Meal('d', ['f', 'b', 'c'])
];

function getUnique(meals) {
  //edge cases
  if (!meals || !meals.length) return 0;
  let set = new Set();

  for (let meal of meals) {
    let list = meal.ingredients
      .map(m => m.toLowerCase())
      .sort((a, b) => {
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
      });
    set.add(list.toString());
  }
  return set.size;
}

console.log(getUnique(input));
