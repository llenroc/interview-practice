// question 1
public Map<Integer, Set<Integer>> generateMap(String[] employees, String[] friendships) {
  Map<Integer, Set<Integer>> map = new HashMap<>();
  for (String employee : employees) {
    String[] parts = employee.split(",");
    int employeeId = Integer.parseInt(parts[0]);
    map.put(employeeId, new HashSet<>());
  }
  for (String friendship : friendships) {
    String[] parts = friendship.split(",");
    int id1 = Integer.parseInt(parts[0]);
    int id2 = Integer.parseInt(parts[1]);
    map.get(id1).add(id2);
    map.get(id2).add(id1);
  }
  return map;
}

// question 2
public Map<String, int[]> getDepartmentStat(String[] employees, String[] friendships) {
  Map<String, int[]> res = new HashMap<>();
  Map<Integer, Set<Integer>> friendsMap = generateMap(employees, friendships);
  
  Map<String, Set<Integer>> departmentsMap = new HashMap<>();
  for (String employee : employees) {
    String[] parts = employee.split(",");
    int employeeId = Integer.parseInt(parts[0]);
    if (!departmentsMap.containsKey(parts[2])) {
      departmentsMap.put(parts[2], new HashSet<>());
      res.put(parts[2], new int[] { 0, 0 });
    }
    departmentsMap.get(parts[2]).add(employeeId);
    res.get(parts[2])[0]++;
  }
  
  for (String employee : employees) {
    String[] parts = employee.split(",");
    int employeeId = Integer.parseInt(parts[0]);
    String department = parts[2];
    
    Set<Integer> employeeSet = departmentsMap.get(department);
    Set<Integer> friendsList = friendsMap.get(employeeId);
    for (int friend : friendsList) {
      if (!employeeSet.contains(friend)) {
        res.get(de‍‍‍‌‍‍‌‌‍‌‌‌‍‍‍‌‌‍partment)[1]++;
        break;   // Terrible! Misunderstand the problem....
      }
    }
  }
  
  return res;
}