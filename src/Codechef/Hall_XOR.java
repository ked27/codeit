/*
You are given a sequence A1,A2,…,AN and you have to perform the following operation exactly X times:

Choose two integers i and j such that 1≤i<j≤N.
Choose a non-negative integer p.
Change Ai to Ai⊕2p, and change Aj to Aj⊕2p, where ⊕ denotes bitwise XOR.
Find the lexicographically smallest sequence which can be obtained by performing this operation exactly X times.

A sequence B1,B2,…,BN is said to be lexicographically smaller than a sequence C1,C2,…,CN if there is an index i such that Bi<Ci and for each valid j<i, Bj=Cj.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers N and X.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing N space-separated integers ― the lexicographically smallest obtainable sequence.

Constraints
1≤T≤10
2≤N≤105
1≤X≤109
1≤Ai≤109 for each valid i
Subtasks
Subtask #1 (30 points): N≤100
Subtask #2 (70 points): original constraints

Example Input
1
3 3
2 2 3
Example Output
0 0 3
Explanation
Example case 1: The original sequence is (2,2,3). Consider the following three operations:

Choose i=1, j=2 and p=1. Then, A1 changes from 2 to 2⊕21=0 and similarly, A2 changes from 2 to 2⊕21=0. Now the sequence is (0,0,3).
Next, choose i=1, j=2 and p=1. Then, A1 changes to 0⊕21=2 and A2 changes to 0⊕21=2. The sequence is (2,2,3).
Next, again choose i=1, j=2 and p=1. Then, A1 changes to 2⊕21=0 and A2 changes to 2⊕21=0. The sequence is (0,0,3) again.
We can check that after exactly 3 operations, this is the lexicographically smallest sequence we can obtain.
 */

package Codechef;

import java.util.Scanner;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Hall_XOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long  a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            double p;
            int i=0,flag,q,r;
            long z;
            while(x>0 && i<n-1){
                flag=0;
                p=log(a[i])/log(2);
                r= (int) pow(2,p);
                a[i]=a[i]^r;
                for(int j=i+1;j<n;j++){
                    if((a[j]^r)<a[j]){
                        a[j]=a[j]^r;
                        flag=1;
                        break;
                    }
                }
                if(flag ==0){
                    a[n-1]=a[n-1]^r;
                }
                while(a[i]<=0) {
                    i++;
                }
            x--;

            }
            z=x+1;
            if(z>0 && z%2==0 && n<3){
                a[n-1]=a[n-1]^1;
                a[n-2]=a[n-2]^1;
            }
            for (i = 0; i < n; i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();
            t--;
        }
    }
}
