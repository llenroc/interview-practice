/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = new Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */

class Twitter {
  constructor() {
    this.userTweets = new Map(); // store tweets ever posted under each user
    this.usersFollowing = new Map(); // store other users this user currently follows
    this.index = 0; // global index, incremented and assigned to every new tweet
  }

  /**
   * Compose a new tweet.
   * @param {number} userId
   * @param {number} tweetId
   * @return {void}
   */
  postTweet(userId, tweetId) {
    let tweets = this.userTweets.get(userId);
    if (!tweets) {
      tweets = [];
      this.userTweets.set(userId, tweets);
    }
    tweets.unshift({ id: tweetId, index: this.index });
    this.userTweets.set(userId, tweets);
    this.index++;
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed.
   * Each item in the news feed must be posted by users who the user followed or by the user herself.
   * Tweets must be ordered from most recent to least recent.
   * @param {number} userId
   * @return {number[]}
   */
  getNewsFeed(userId) {
    const followingIds = this.usersFollowing.get(userId);
    let tweets = (this.userTweets.get(userId) || []).slice(0, 10);

    followingIds &&
      followingIds.forEach(id => {
        // skip in case user follows himself
        if (id === userId) return;
        let list = this.userTweets.get(id);
        if (list) tweets = tweets.concat(list);
      });

    return tweets
      .sort((a, b) => b.index - a.index)
      .slice(0, 10)
      .map(obj => obj.id);
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   * @param {number} followerId
   * @param {number} followeeId
   * @return {void}
   */
  follow(followerId, followeeId) {
    let followings = this.usersFollowing.get(followerId);
    if (!followings) followings = new Set();
    followings.add(followeeId);
    this.usersFollowing.set(followerId, followings);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   * @param {number} followerId
   * @param {number} followeeId
   * @return {void}
   */
  unfollow(followerId, followeeId) {
    let followings = this.usersFollowing.get(followerId);
    followings && followings.delete(followeeId);
    this.usersFollowing.set(followerId, followings);
  }
}
