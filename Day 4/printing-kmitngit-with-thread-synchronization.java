
/*Suppose you are given the following code:

class KmitNgit {
  public void kmit() {
    for (int i = 0; i < n; i++) {
      print("Kmit");
    }
  }

  public void ngit() {
    for (int i = 0; i < n; i++) {
      print("Ngit");
    }
  }
}

The same instance of KmitNgit will be passed to two different threads. 
Thread A will call kmit() while thread B will call ngit(). 
Modify the given program to output "KmitNgit" n times.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print KmitNgit for N times using threads.


Sample Input:
-------------
1
Sample Output:
--------------
KmitNgit

Explanation:
------------
There are two threads being fired asynchronously. 
One of them calls kmit(), while the other calls ngit(). 
"KmitNgit" is being output 1 time.


Sample Input:
-------------
2

Sample Output:
--------------
KmitNgitKmitNgit

Explanation:
------------
"KmitNgit" is being output 2 times.
*/
import java.util.*;

class shared {
    int range;
    int n = 1;
    int f = 0;

    shared(int range) {
        this.range = range;
    }

    public synchronized int get() {
        return f;
    }

    public synchronized void set() {
        if (f == 0) {
            f = 1;
        } else {
            f = 0;
            n++;
        }
    }

    public synchronized int check() {
        if (n <= range)
            return 1;
        else
            return 0;
    }
}

class Thread1 implements Runnable {
    shared n;

    Thread1(shared n) {
        this.n = n;
    }

    public void run() {
        synchronized (n) {
            while (n.check() == 1) {
                if (n.get() == 0) {
                    System.out.print("Kmit");
                    n.set();
                    n.notifyAll();
                } else {
                    try {
                        n.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

class Thread2 implements Runnable {
    shared n;

    Thread2(shared n) {
        this.n = n;
    }

    public void run() {
        synchronized (n) {
            while (n.check() == 1) {
                if (n.get() == 1) {
                    System.out.print("Ngit");
                    n.set();
                    n.notifyAll();
                } else {
                    try {
                        n.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

public class fifth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        shared ref = new shared(n);
        Thread t1 = new Thread(new Thread1(ref));
        Thread t2 = new Thread(new Thread2(ref));
        t1.start();
        t2.start();
    }
}