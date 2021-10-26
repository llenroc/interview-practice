var Solution = function (w) {
    const newWeights = []
    let sum = 0

    for (const weight of w) {
        sum = weight + sum
        newWeights.push(sum)
    }

    this.w = newWeights
    this.max = newWeights[newWeights.length - 1]
};

Solution.prototype.pickIndex = function () {
    const { max, w } = this
    const target = Math.floor(Math.random() * max)

    let left = 0
    let right = w.length - 1

    // Begin binary search
    while (left < right) {
        const mid = (left + right) >> 1

        if (target >= w[mid]) left = mid + 1
        else right = mid
    }

    return left
};