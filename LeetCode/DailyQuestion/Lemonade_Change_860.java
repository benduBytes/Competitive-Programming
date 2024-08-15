package DailyQuestion;

//Time Complexity - O(N)
//Space Complexity - O(1)
public class Lemonade_Change_860 {
	public boolean lemonadeChange(int[] arr) {
        int n = arr.length;
        int a = 0;
        int b = 0;
        for(int i =0;i<n;i++){
            if(arr[i] == 5){
                a += 1;
            }
            else if(arr[i] == 10){
               if(a == 0){
                return false;
               }else{
                    a -= 1;
                    b += 1;
               }
            }
            else if( arr[i] == 20){
                 if (b > 0 && a > 0) {
                    b -= 1;
                    a -= 1;
                } else if (a >= 3) {
                    a -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation: 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
Example 2:

Input: bills = [5,5,10,10,20]
Output: false
Explanation: 
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.
*/
