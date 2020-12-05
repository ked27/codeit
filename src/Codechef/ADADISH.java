/*
Chef Ada is preparing N dishes (numbered 1 through N). For each valid i, it takes Ci minutes to prepare the i-th dish. The dishes can be prepared in any order.

Ada has a kitchen with two identical burners. For each valid i, to prepare the i-th dish, she puts it on one of the burners and after Ci minutes, removes it from this burner; the dish may not be removed from the burner before those Ci minutes pass, because otherwise it cools down and gets spoiled. Any two dishes may be prepared simultaneously, however, no two dishes may be on the same burner at the same time. Ada may remove a dish from a burner and put another dish on the same burner at the same time.

What is the minimum time needed to prepare all dishes, i.e. reach the state where all dishes are prepared?

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line contains N space-separated integers C1,C2,…,CN.
Output
For each test case, print a single line containing one integer ― the minimum number of minutes needed to prepare all dishes.

Constraints
1≤T≤1,000
1≤N≤4
1≤Ci≤5 for each valid i
Subtasks
Subtask #1 (1 points): C1=C2=…=CN
Subtask #2 (99 points): original constraints

Example Input
3
3
2 2 2
3
1 2 3
4
2 3 4 5
Example Output
4
3
7
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	 {
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int c1=0,c2=0,i=n-1,time;
            while(i>=0){
                while(c1<=c2 && i>=0){
                    c1+=a[i];
                    i=i-1;
                }
                while(c2<c1 && i>=0){
                    c2+=a[i];
                    i=i-1;
                }
            }
            time=Math.max(c2,c1);
            System.out.println(time);
            t=t-1;
        }
    }
}
