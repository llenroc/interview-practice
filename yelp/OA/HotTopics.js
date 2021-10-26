const topics = {
  buy: ['buy', 'purchase'],
  select: ['select', 'check'],
  sit: ['not stand', 'sit'],
  discount: ['discount', 'off']
};

const reviews = [
  'I will go to select a seat then buy it',
  "Check this product,‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‌ if it's good, purchase it",
  "Sit down, don't move"
];

function getTopics(topics, reviews) {
  let result = {};

  reviews = reviews.map(review => {
    let set = new Set(review.toLowerCase().split(' '));
    return set;
  });

  Object.keys(topics).forEach(topic => {
    let wordList = topics[topic];
    let count = 0;
    for (let word of wordList) {
      for (let review of reviews) {
        if (review.has(word)) count++;
      }
    }
    result[topic] = count;
  });
  return result;
}

console.log(getTopics(topics, reviews));
