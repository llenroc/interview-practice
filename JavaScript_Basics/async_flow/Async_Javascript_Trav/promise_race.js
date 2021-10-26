// Create a new Express app and set the port
const app = require('express')();
const PORT = process.env.PORT || 5000;

// The timeout in seconds for API responses
const TIMEOUT_SECONDS = 5;

// Define a new route on the Express app: GET /random
app.get('/random', (req, res) => {
  /**
   * `execute` is a promise that simulates a time-consuming asynchronous operation
   * which may take anywhere between 1s - 10s to complete its execution.
   * On completion, it is fulfilled with an object that looks like this:
   * {
   *   statusCode: 200,
   *   random: (A random integer in the range of 0 - 100, both inclusive)
   *   duration: (The duration of the execution in seconds, expressed as {duration}s)
   * }
   */
  const execute = new Promise(resolve => {
    // Random execution time in milliseconds
    const timeInMs = Math.floor(Math.random() * 10 * 1000);

    // Simulate execution delay using setTimeout and fulfill the promise
    // with the response object
    setTimeout(() => {
      resolve({
        statusCode: 200,
        random: Math.floor(Math.random() * 101),
        duration: `${timeInMs / 1000}s`
      });
    }, timeInMs);
  });

  /**
   * `requestTimer` is a promise that is settled after `TIMEOUT_SECONDS` seconds
   * On completion, it is fulfilled with an object that looks like this:
   * { statusCode: 504 }
   * which represents a Gateway Timeout on the server.
   */
  const requestTimer = new Promise(resolve => {
    // Simulate execution delay using setTimeout and fulfill the promise
    // with the response object
    const timeoutInMs = TIMEOUT_SECONDS * 1000;
    setTimeout(() => resolve({ statusCode: 504 }), timeoutInMs);
  });

  /**
   * `Promise.race()` is used to run both the `execute` and the `requestTimer` promises.
   * The first of the two promises that gets settled will be used to settle the race promise.
   * The fulfilled response object is then used to form and send the HTTP response.
   * If an error occurs, a HTTP 500 error response is sent.
   */
  return Promise.race([execute, requestTimer])
    .then(({ statusCode = 200, ...data }) => {
      const response = res.status(statusCode);

      return statusCode == 200 ? response.json(data) : response.end();
    })
    .catch(() => res.status(500).end());
});

// Start the app on the set port
app.listen(PORT, () => console.log(`App is running on port ${PORT}.`));
