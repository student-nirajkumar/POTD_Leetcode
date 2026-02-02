class MyCalendarThree {

    TreeMap<Integer, Integer> events;

    public MyCalendarThree() {
        events = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int count = 0;
        int maxInt = 0;
        for (int val : events.values()) {
            count += val;
            maxInt = Math.max(maxInt, count);
        }

        return maxInt;
    }
}
