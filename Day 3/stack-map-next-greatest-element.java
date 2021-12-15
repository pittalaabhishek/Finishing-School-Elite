/*
Kiran Rao purchased two boxes (Box1,Box2) of unique weights 
of gold coins, where first box weights are subset of second box gold weights.

 Now design a method for Gumadi Baleshwar Rao to find all the next largest weights 
of Box1 gold coins in the corresponding locations of box2 , 
if doesn’t exist return -1.

The Next largest Weight is Weight ‘W’ in Box1 is the first largest weight 
 to its right side weight in Box2.

NOTE: Unique weights means, no two coins will have same weight.

 Input Format:
 -------------
Line-1: space separated integers, weihts of gold coins in the first box.
Line-2: space separated integers, weihts of gold coins in the second box.

Output Format:
--------------
 Print a list of integers, next largest weights

Sample Input-1:
---------------
 4 3 2
 1 3 4 2

Sample Output-1:
 ----------------
 [-1, 4, -1]


 Sample Input-2:
 ---------------
5 6 3 4
1 5 3 7 8 6 4 2

 Sample Output-2:
 ----------------
[7, -1, 7, -1]

*/

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int[] a=new int[s.length];
        for(int i=0;i<s.length;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        String s1[]=sc.nextLine().split(" ");
        int[] b=new int[s1.length];
        for(int i=0;i<s1.length;i++){
            b[i]=Integer.parseInt(s1[i]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[a.length];
        for(int i=b.length-1;i>=0;i--){
                while(!stack.empty()&&stack.peek()<b[i]){
                    stack.pop();
                }
                if(stack.empty()){
                    map.put(b[i],-1);
                }else{
                    map.put(b[i],stack.peek());
                }
                stack.push(b[i]);
        }
        for(int i=0;i<a.length;i++){
            ans[i]=map.get(a[i]);
        }
        
        for(int i=0;i<ans.length;i++){
         System.out.print(ans[i]+" ");
        }
    }
}