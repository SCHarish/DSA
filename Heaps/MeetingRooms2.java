/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */

import java.util.*;
public class MeetingRooms2 {

    public static void main(String args[]){
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        System.out.println("Min meeting rooms required "+MeetingRooms2.minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int []a, int []b){
                return a[0] - b[0];
            }
        });
            
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int []a, int []b){
                return a[1] - b[1];
            }
        });
        
        int rooms = 1, max_rooms = 1; 
        for(int[] interval : intervals){
            max_rooms = Math.max(rooms, max_rooms);
            while(!queue.isEmpty() && interval[0] >= queue.peek()[1]){
                rooms -= 1;
                queue.poll();
            }
            
            rooms += 1;
                       
            queue.offer(interval);
        }
        
        return rooms-1;
    }
}
