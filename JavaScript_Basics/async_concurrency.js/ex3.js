// async with array.map()

// Version with Promises chain
fetchJSON('/userProfile')
  .then(user => {
    return fetchJSON(`/users/${user.id}/friends`);
  })
  .then(friendIDS => {
    let promises = friendIDS.map(id => {
      return fetchJSON(`/users/${id}`);
    });
    // concurrently runing list of promises
    return Promise.all(promises);
  })
  .then(friends => {
    console.log('friends list are:', friends);
  })
  .catch(err => {
    console.err(err);
  });

// Version 2 with async await
const getAllFriends = async () => {
  const user = await fetch(`/userProfile/me`);
  const friendIDs = await fetch(`/users/${user.id}/friends`);
  const promises = friendIDs.map(id => {
    return fetch(`/users/${id}`);
  });
  const friends = await Promise.all(promises);
  return friends;
};

const init = async cb => {
  const friends = await getAllFriends();
  cb(friends);
};

// Version 3 with for await .. of ...  2019updates
