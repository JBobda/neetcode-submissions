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
    public int minMeetingRooms(List<Interval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0;
        int j = 0;

        int current = 0;
        int max = 0;

        while(i < starts.length && j < ends.length) {
            if(starts[i] < ends[j]) {
                i++;
                current++;
            } else {
                j++;
                current--;
            }

            max = Math.max(max, current);
        }

        return max;
    }
}
