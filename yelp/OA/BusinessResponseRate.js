class MyMessage {
  constructor(s, r, c) {
    this.sender = s;
    this.recipient = r;
    this.convo_id = c;
  }
}

function getResRate(owner, messages) {
  let result = 0;
  let receive = new Map();
  let response = new Map();

  for (let message of messages) {
    if (message.sender === owner) {
      if (!response.has(message.convo_id)) {
        response.set(message.convo_id, message.recipient);
      }
    }

    if (message.recipient === owner) {
      if (!receive.has(message.convo_id)) {
        receive.set(message.convo_id, message.sender);
      }
    }
  }

  //  value: recipient key: convo_id
  receive.forEach((value, key) => {
    if (response.has(key)) {
      if (response.get(key) === value) result++;
    }
  });

  result = (result / receive.size) * 100;
  return result;
}

// receive
// {
//     1: 0,
//     2: 1
// }

// response
// {
//     1: 0,
//     2, 1
// }
