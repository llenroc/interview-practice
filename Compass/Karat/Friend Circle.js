/**
 * 按照department分类，统计每⼀个department⼈数，和这个department有多少⼈有其他 department的朋友
 */

function getDepartmentFriends(friendsList, employeeRecords) {
    let friendMap = new Map();
    let departmentMap = new Map();

    for (let friends of friendsList) {
        let tmp = friends.split(',');
        let personA = tmp[0];
        let personB = tmp[1];

        friendMap.set(personA, (friendMap.get(personA) || new Set()).add(personB));
        friendMap.set(personB, (friendMap.get(personB) || new Set()).add(personA));
    }

    for (let record of employeeRecords) {
        let list = record.split(',');
        let id = list[0];
        let department = list[2];

        departmentMap.set(department, (departmentMap.get(department) || new Set()).add(id));
    }

    let result = {};
    for (let [key, val] of departmentMap) {
        let count = 0;
        for (let id of val) {
            let friendSet = friendMap.get(id) || new Set();
            for (let friend of friendSet) {
                if (!departmentMap.get(key).has(friend)) {
                    count++;
                    break;
                }
            }
        }
        result[key] = [departmentMap.get(key).size, count];
    }

    return result;
}

let employee_records = [
    "1,Richard,Engineering",
    "2,Erlich,HR",
    "3,Monica,Business",
    "4,Dinesh,Engineering",
    "6,Carla,Engineering",
    "9,Laurie,Directors"
];

let friendshipsInput = [
    "1,2",
    "1,3",
    "1,6",
    "2,4"
];

console.log(getDepartmentFriends(friendshipsInput, employee_records));