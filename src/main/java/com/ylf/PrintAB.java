package com.ylf;

/**
 * @author: leifeng.ye
 * @date: 2019-08-08
 * @desc:
 */
public class PrintAB {
    public static void main(String[] args) throws Exception{
        String lock="lock";
        Thread a=new Thread(new A(lock));
        Thread b=new Thread(new B(lock));
        a.start();
        Thread.sleep(1000);
        b.start();

    }

}
class A implements Runnable{

    private String lock;

    public A(String lock){
        this.lock=lock;
    }


    @Override
    public void run() {
        while(true){
            System.out.println("A");
            synchronized (lock){
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}

class B implements Runnable{
    public B(String lock){
        this.lock=lock;
    }

    private String lock;



    @Override
    public void run() {
        while(true){
            System.out.println("B");
            synchronized (lock){
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
