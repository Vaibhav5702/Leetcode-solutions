class MyCalendar {

    HashMap<Integer,Integer> map=new HashMap();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        for(Map.Entry entry:map.entrySet())
        {
            int key=(int)entry.getKey();
            int value=(int)entry.getValue();
            if((start>=key&&start<value)||(end>key&&end<=value)||(start<=key&&end>value))
                return false;
        }
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */