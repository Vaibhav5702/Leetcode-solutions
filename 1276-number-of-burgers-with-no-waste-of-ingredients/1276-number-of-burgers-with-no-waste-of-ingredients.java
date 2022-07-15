class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list=new ArrayList<>();
        int low=2*cheeseSlices;
        int high=4*cheeseSlices;
        if(tomatoSlices%2==0&&tomatoSlices>=low&&tomatoSlices<=high)
        {
            int j=(tomatoSlices-low)/2;
            list.add(j);
            list.add(cheeseSlices-j);
            return list;
        }
        return list;
    }
}