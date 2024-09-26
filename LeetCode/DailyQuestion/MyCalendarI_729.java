package DailyQuestion;
import java.util.*;

//Time Complexity: O(Log(N))
//Space Complexity: O(N)

public class MyCalendarI_729 {
	TreeMap<Integer,Integer> calendar = new TreeMap<>();
    public MyCalendarI_729() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }
}

/*
Example 1:
Input 
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]
Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
*/