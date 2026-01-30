class MyCalendar {
    private TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) -1);
        int count = 0;
        for(int delta : events.values()){
            count+=delta;
             if(count > 1){
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
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */