/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map=new HashMap();
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        Queue<Integer> queue=new LinkedList();
        queue.offer(id);
        int sum=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                Employee e=map.get(queue.poll());
                sum+=e.importance;
                for(int a:e.subordinates)
                {
                    queue.offer(a);
                }
            }
        }
        return sum;
    }
}