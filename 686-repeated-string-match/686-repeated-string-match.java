class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count=(int)Math.ceil((double)b.length()/a.length());
        String repeated=a.repeat(count);
        if(repeated.contains(b))
            return count;
        repeated=repeated+a;
        if(repeated.contains(b))
            return count+1;
        return -1;
    }
}