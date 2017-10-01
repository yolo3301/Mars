/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> index = new HashMap<>();
        for (Employee e : employees) {
            index.put(e.id, e);
        }
        return sum(id, index);
    }

    private int sum(int id, Map<Integer, Employee> index) {
        Employee curr = index.get(id);
        int res = curr.importance;

        for (int sub : curr.subordinates) {
            res += sum(sub, index);
        }

        return res;
    }
}