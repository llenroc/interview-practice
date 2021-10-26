// const posts = [
//     {title: 'post one', body: 'this is post one'},
//     {title: 'post two', body: 'this is post two'}
// ]

// function getPosts() {
//     console.log('get post starts');
//     setTimeout(() => {
//         let output = '';
//         posts.forEach(p => {
//             output += `<li>${p.title}</li>`;
//         })
//         document.body.innerHTML = output;
//     }, 1000);
// }

// function createPost(post, callback) {
//     console.log('create post starts here');
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             posts.push(post);
//             const error = false;
//             error? reject('something went wrong'): resolve();
//         }, 2000)
//     })
// }

// const init = async() => {
//     await createPost({title: 'post three', body: 'this is post three'});
//     getPosts();
// }

// init();

// // createPost({title: 'post three', body: 'this is post three'})
// // .then(getPosts)
// // .catch(err => {
// //     console.log(err);
// // });

// // const promise1 = Promise.resolve('hello world');
// // const promise2 = new Promise((resolve, reject) => {
// //     setTimeout(resolve, 2000, 'Goodjob');
// // })

// // Promise.all([promise1, promise2]).then((val) => {
// //     console.log(val);
// // });

// const service = async (data, len, callback) => {
//     try{
//         setTimeout(async() => {
//             if(data.length >= len) {
//                 callback(null, 'data fetched succesfully');
//                 return data;
//             } else {
//                 throw new Error('length is less than required');
//             }
//         }, 2000)
//     }catch (err) {
//         console.log(err);
//     }
// }

//server
const service = (data, len, callback) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (data.length < len) {
        // callback('length is less than required');
        reject('length is less than required');
      } else {
        callback(null, 'data fetched succesfully');
        resolve(data);
      }
    }, 2000);
  });
};

//client
const init = async () => {
  let testData = ['hello', 'world'];
  let requiredLen = 1;

  try {
    const response = await service(testData, requiredLen, (error, data) => {
      error ? console.error(error) : console.log(data);
    });
  } catch (error) {
    console.log(error);
  }
};

init();
