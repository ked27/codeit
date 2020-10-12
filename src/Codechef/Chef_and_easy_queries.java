/*
Chef published a blog post, and is now receiving many queries about it. On day i, he receives Qi queries. But Chef can answer at most k queries in a single day.
Chef always answers the maximum number of questions that he can on any given day (note however that this cannot be more than k). The remaining questions (if any) will be carried over to the next day.
Fortunately, after n days, the queries have stopped. Chef would like to know the first day during which he has some free time, i.e. the first day when he answered less than k questions.
Input:
First line will contain T, the number of testcases. Then the testcases follow.
The first line of each testcase contains two space separated integers n and k.
The second line of each testcase contains n space separated integers, namely Q1,Q2,...Qn.
Output:
For each testcase, output in a single line the first day during which chef answers less than k questions.

Constraints
1≤T≤105
1≤ sum of n over all testcases ≤105
1≤k≤108
0≤Qi≤108
Subtasks
Subtask 1 - 20% points - Sum of Qi over all testcases and days ≤3.106
Subtask 2 - 80% points - Original constraints
Sample Input:
2
6 5
10 5 5 3 2 1
1 1
100
Sample Output:
6
101
 */


package Codechef;

import java.util.Scanner;

public class Chef_and_easy_queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long n = sc.nextInt();
            long k = sc.nextInt();
            long carry=0;
            long query[] = new long[(int) n];
            for(long i=0;i<n;i++){
                query[(int) i] = sc.nextInt();
                }
            for(int i=0;i<n;i++){
                if(query[i]+carry<k){
                    carry=-1;
                    System.out.println(i+1);
                    break;
                }
                else{
                    carry=carry+query[i]-k;
                    if(carry<0)carry=0;
                }
            }
            if(carry!=-1){
                System.out.println(n+(carry/k)+1);
            }
            t--;
        }
    }
}
