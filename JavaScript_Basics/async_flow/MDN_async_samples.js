function resolveAfter2Sec() {
    console.log('start slow promise');
    return new Promise(resolve => {
        setTimeout(() => {
            resolve('slow');
            console.log('resolve slow is done');
        },2000)
    })
}

function resolveAfter1Sec() {
    console.log('start fast promise');
    return new Promise(resolve => {
        setTimeout(() => {
            resolve('fast');
            console.log('resolve fast is done');
        },1000)
    })
}

const sequentialStart = async( ) => {
    console.log('sequential starts here');

    const slow = await resolveAfter2Sec();
    console.log('slow is done');

    const fast = await resolveAfter1Sec();
    console.log('fast is done');
}

const concurrentStart = async() => {
    console.log('cocurrent starts here');

    const slow = resolveAfter2Sec();
    const fast = resolveAfter1Sec();

    console.log(await slow);
    console.log(await fast);
}