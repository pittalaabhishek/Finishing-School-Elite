
/*
There are a group of kids playing a game in a circle.This game is to check their
Arithmetic division skills.We will start the game by selecting a kid and he has 
to say 1 to start the game and the next kid turn arrives he has to say next 
number but with the following rules.
   - if number is divisible by 3 then the answer is "Hi".
   - if number is divisible by 5 then the answer is "Hello".
   - if number is divisible by both 3 and 5 then the answer is "HiHello".
   - else the answer is the number itself.

 Given a number N , return a string array result[] (1-indexed),which consists the 
 answers from kid-1 to kid-N.

Input Format:
-------------
Line-1: An integer N.

Output Format:
--------------
Print a string array[].

Constraints:
• 1 <= n <= 10^4
 
Sample Input-1:
---------------
4

Sample Output-1:
----------------
1 2 Hi 4 


Sample Input-2:
---------------
15

Sample Output-2:
----------------
1 2 Hi 4 Hello Hi 7 8 Hi Hello 11 Hi 13 14 HiHello 
 


*/
import java.util.*;
import java.io.*;

class number {
    int i = 1;
    int n = 0;

    number(int n) {
        this.n = n;
    }

    public synchronized int get() {
        if (i <= n)
            return i;
        else
            return -1;
    }

    public synchronized void set() {
        this.i++;
    }
}

class Thread1 implements Runnable {
    number x;

    Thread1(number x) {
        this.x = x;
    }

    public void run() {
        synchronized (x) {
            while (x.get() != -1)
                if (x.get() % 3 == 0 && x.get() % 5 != 0) {
                    System.out.print("Hi ");
                    x.set();
                    x.notifyAll();
                } else {
                    try {
                        x.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
        }
    }
}

class Thread2 implements Runnable {
    number x;

    Thread2(number x) {
        this.x = x;
    }

    public void run() {
        synchronized (x) {
            while (x.get() != -1)
                if (x.get() % 3 != 0 && x.get() % 5 == 0) {
                    System.out.print("Hello ");
                    x.set();
                    x.notifyAll();
                } else {
                    try {
                        x.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
        }
    }
}

class Thread3 implements Runnable {
    number x;

    Thread3(number x) {
        this.x = x;
    }

    public void run() {
        synchronized (x) {
            while (x.get() != -1)
                if (x.get() % 3 == 0 && x.get() % 5 == 0) {
                    System.out.print("HiHello ");
                    x.set();
                    x.notifyAll();
                } else {
                    try {
                        x.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
        }
    }
}

class Thread4 implements Runnable {
    number x;

    Thread4(number x) {
        this.x = x;
    }

    public void run() {
        synchronized (x) {
            while (x.get() != -1)
                if (x.get() % 3 != 0 && x.get() % 5 != 0) {
                    System.out.print(x.get() + " ");
                    x.set();
                    x.notifyAll();
                } else {
                    try {
                        x.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
        }
    }
}

public class fourth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        number ob = new number(n);
        Thread t1 = new Thread(new Thread1(ob));
        Thread t2 = new Thread(new Thread2(ob));
        Thread t3 = new Thread(new Thread3(ob));
        Thread t4 = new Thread(new Thread4(ob));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}