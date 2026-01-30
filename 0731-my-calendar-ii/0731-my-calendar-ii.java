class MyCalendarTwo {
  private TreeMap<Integer, Integer> events;
    public MyCalendarTwo() {
        events = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime , 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);
        int count = 0;

        for(int delta : events.values()){
            count+=delta;
            if(count > 2){
                events.put(startTime, events.get(startTime) - 1);
                if(events.get(startTime) == 0){
                    events.remove(startTime);
                }
            events.put(endTime, events.get(endTime) + 1);
            if(events.get(endTime) == 0){
                events.remove(endTime);
            }
            return false;
            }

        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */