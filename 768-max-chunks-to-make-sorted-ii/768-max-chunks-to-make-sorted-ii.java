class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        Map<Integer,Integer> map=new HashMap();
        int chunk=0;
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            map.put(sorted[i],map.getOrDefault(sorted[i],0)-1);
            if(map.get(arr[i])==0)
                map.remove(arr[i]);
            if(map.containsKey(sorted[i])&&map.get(sorted[i])==0)
                map.remove(sorted[i]);
            if(map.size()==0)
                chunk++;
        }
        return chunk;
    }
}