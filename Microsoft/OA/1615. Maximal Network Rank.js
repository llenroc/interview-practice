/**
 * @param {number} n
 * @param {number[][]} roads
 * @return {number}
 */
var maximalNetworkRank = function (n, roads) {
    let maxRank = 0;
    let neighborMap = new Map(); // Map that stored the connected neighbors one given city has

    for (let pair of roads) {
        let cityA = pair[0];
        let cityB = pair[1];

        // use set to record neighbor cities to avoid duplications
        neighborMap.set(cityA, (neighborMap.get(cityA) || new Set()).add(cityB));
        neighborMap.set(cityB, (neighborMap.get(cityB) || new Set()).add(cityA))
    }

    for (let i = 0; i < n; i++) {
        if (!neighborMap.has(i)) continue;
        let neighborsI = neighborMap.get(i);
        let roadsI = neighborsI.size;
        for (let j = i + 1; j < n; j++) {
            if (!neighborMap.has(j)) continue;
            let neighborsJ = neighborMap.get(j);
            let roadsJ = neighborsJ.size;
            if (neighborsJ.has(i)) roadsJ--; // connected between 2 cities count only once
            maxRank = Math.max(maxRank, roadsI + roadsJ);
        }
    }

    return maxRank;
};