/*write a program to read a postive input 'n' from the user and print the following pattern 

Assume the input 'n' will always be a postive integer 

input = 5
output = 
A*1
B*C*3*2
D*E*F*6*5*4
G*H*I*J*10*9*8*7
K*L*M*N*O*15*14*13*12*11
 
Note - If in the above pattern if the alphabet exceed 'Z' then start print again from 'A'
*/

import java.util.*;

class Test3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 65;
        int num, count = 0;
        for (int i = 1; i <= n; i++) {
            count += i;
            num = count;
            for (int j = 1; j <= 2 * i; j++) {
                if (c > 90)
                    c = 65;
                if (j <= i) {
                    System.out.print((char) c + "*");
                    c++;
                } else {
                    if (j == (2 * i))
                        System.out.print(num);
                    else
                        System.out.print(num + "*");
                    num--;
                }
            }
            System.out.println();
        }
    }
}