package ThreadLearning;

public class ThreadTryOut {

    public static void main(String[] args) {
        ThreadTryOut2 threadTryOut2 = new ThreadTryOut2();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("ssup bitch");
            }
        };

        Runnable runnable2 = ()->{
            System.out.println("ssupp bitch again");
        };
        Thread thread1 = new Thread(new ThreadTryOut2());
        Thread thread2 = new Thread(new ThreadTryOut2());
        Thread thread3 = new Thread(runnable1);
        Thread thread4 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread3.run();
        thread4.run();
    }


}

class ThreadTryOut2 implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread = " + Thread.currentThread().getName() + " count = " + i);
        }
    }

}