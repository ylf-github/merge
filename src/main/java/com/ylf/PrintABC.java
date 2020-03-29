package com.ylf;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: leifeng.ye
 * @date: 2019-08-08
 * @desc:
 */
public class PrintABC {
    public static void main(String[] args) throws Exception{

        ReentrantLock lock=new ReentrantLock();

        Condition a=lock.newCondition();
        Condition b=lock.newCondition();
        Condition c=lock.newCondition();

        Thread A=new Thread(new AA(lock,a,b,c));
        Thread B=new Thread(new BB(lock,a,b,c));
        Thread C=new Thread(new CC(lock,a,b,c));
        A.start();
       // Thread.sleep(1000);
        B.start();
        C.start();
    }
}
class AA implements Runnable{

    private ReentrantLock lock;

    private Condition a;

    private Condition b;

    private Condition c;

    public  AA(ReentrantLock lock,Condition a,Condition b,Condition c){
        this.lock=lock;
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                System.out.print("A ");
                b.signal();
                a.await();

            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }


    }
}
class BB implements Runnable{

    private ReentrantLock lock;

    private Condition a;

    private Condition b;

    private Condition c;

    public  BB(ReentrantLock lock,Condition a,Condition b,Condition c){
        this.lock=lock;
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                System.out.print("B ");
                c.signal();
                b.await();

            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

    }
}
class CC implements Runnable{

    private ReentrantLock lock;

    private Condition a;

    private Condition b;

    private Condition c;

    public  CC(ReentrantLock lock,Condition a,Condition b,Condition c){
        this.lock=lock;
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public void run() {
        while (true){
            try{
                lock.lock();
                System.out.println("C");
                a.signal();
                c.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

    }
}