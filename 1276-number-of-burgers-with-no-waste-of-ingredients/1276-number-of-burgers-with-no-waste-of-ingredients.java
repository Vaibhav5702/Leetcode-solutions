class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list=new ArrayList<>();
        if(tomatoSlices%2!=0)
            return list;
        if(2*cheeseSlices>tomatoSlices||4*cheeseSlices<tomatoSlices)
            return list;
        int j=0;
        while(tomatoSlices>0&&cheeseSlices>0&&tomatoSlices!=cheeseSlices*2)
        {
            j++;
            tomatoSlices-=4;
            cheeseSlices--;
        }
        if(tomatoSlices<0||cheeseSlices<0)
            return list;
        list.add(j);
        list.add(cheeseSlices);
        return list;
    }
}