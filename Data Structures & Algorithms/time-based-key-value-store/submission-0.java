class TimeMap {

    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeValue> times = map.getOrDefault(key, new ArrayList<>());
        TimeValue tv = new TimeValue(timestamp, value);
        times.add(tv);
        map.put(key, times);
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> times = map.getOrDefault(key, new ArrayList<>());
        TimeValue tv = floor(times, timestamp);
        if(null == tv) return "";
        return tv.value;
    }
    
    private TimeValue floor(List<TimeValue> times, int timestamp) {
        int start = 0;
        int end = times.size() - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            TimeValue mtv = times.get(mid);
            if(mtv.time == timestamp) {
                return mtv;
            } else if (mtv.time < timestamp) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end >= 0 ? times.get(end) : null;
    }

}


record TimeValue(int time, String value){

}