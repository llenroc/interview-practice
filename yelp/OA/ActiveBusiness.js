class Event {
  constructor(type, times, biz_id) {
    this.type = type;
    this.times = times;
    this.biz_id = biz_id;
  }
}

function activeBussiness(eventList) {
  let eventType = {};
  let eventAvg = {};
  let bussiness = {};
  let result = [];

  for (let event of eventList) {
    let list = eventType[event.type] ? eventType[event.type] : [];
    eventType[event.type] = list.concat(event.times);
    // list.push(event.times);
    // eventType[event.type] = list;
  }

  Object.keys(eventType).forEach(type => {
    let total = eventType[type].reduce((acc, curr) => acc + curr);
    eventAvg[type] = total / eventType[type].length;
  });

  for (let event of eventList) {
    if (event.times >= eventAvg[event.type]) {
      bussiness[event.biz_id] = bussiness[event.biz_id]
        ? bussiness[event.biz_id] + 1
        : 1;
    }
  }

  Object.keys(bussiness).forEach(bus => {
    if (bussiness[bus] >= 2) result.push(bus);
  });
  result.sort((a, b) => a - b);
  return result;
}

const inputList = [
  new Event('ads', 7, 3),
  new Event('ads', 8, 2),
  new Event('ads', 5, 1),
  new Event('page', 11, 2),
  new Event('page', 12, 3),
  new Event('photo', 10, 3),
  new Event('review', 7, 2)
];

console.log(activeBussiness(inputList));
