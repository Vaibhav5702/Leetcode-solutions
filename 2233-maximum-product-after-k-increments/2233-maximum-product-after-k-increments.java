class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long result = 1;
        int mod = 1_000_000_007;
        int current;
        
        for (int num : nums)
            queue.add(num);
        
        while (k-- > 0){
            current = queue.poll();
            ++current;
            queue.add(current);
        }
        
        for (int num : queue){
            result *= num;
            result %= mod;
        }
        
        return (int) result;
    }
}