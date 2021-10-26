var Log = function(id, args) {
  this.id = id;
  this.args = args;
};

var LogSystem = function() {
  // use a list to store all the logs, since the data set is small
  this.list = [];
};

/**
 * @param {number} id
 * @param {string} timestamp
 * @return {void}
 */
LogSystem.prototype.put = function(id, timestamp) {
  let args = timestamp.split(':');
  let newLog = new Log(id, args);
  this.list.push(newLog);
};

/**
 * @param {string} s
 * @param {string} e
 * @param {string} gra
 * @return {number[]}
 */
LogSystem.prototype.retrieve = function(s, e, gra) {
  const range = ['Year', 'Month', 'Day', 'Hour', 'Minute', 'Second'];
  let index = range.indexOf(gra);

  let startArgs = s.split(':').slice(0, index + 1);
  let endArgs = e.split(':').slice(0, index + 1);

  let start = new Date(...startArgs).getTime();
  let end = new Date(...endArgs).getTime();
  let result = [];

  this.list.forEach(log => {
    let currArgs = log.args.slice(0, index + 1);
    let currTime = new Date(...currArgs).getTime();
    if (currTime >= start && currTime <= end) {
      result.push(log.id);
    }
  });
  return result;
};
