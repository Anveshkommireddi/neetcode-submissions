/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (interval1, interval2) -> interval1.start - interval2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (interval1, interval2) -> { 
                if(interval2.end == interval1.end) {
                    return interval1.start - interval2.start;
                } else {
                    return interval2.end - interval1.end;
                }
        });
        for(Interval interval : intervals) {
            if(pq.isEmpty() || interval.start >= pq.peek().end) {
                pq.offer(interval);
            } else {
                return false;
            }
        }
        return true;
    }
}
