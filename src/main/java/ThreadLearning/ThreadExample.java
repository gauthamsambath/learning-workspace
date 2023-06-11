package ThreadLearning;

public class ThreadExample {

    public static class ThreadOne extends Thread {
        @Override
        public void run(){
            System.out.println("running threadOne which runs thread by just extending Thread class and by overriding run method");
        }
    }

    public static class MyRunnableImplementation implements Runnable{

        @Override
        public void run() {
            System.out.println("running myRunnableImplementation which runs threas by implementing runnable functional interface");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadOne threadOne = new ThreadOne();
        Thread threadTwo = new Thread(new MyRunnableImplementation());
        Runnable runnableExample1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("you are in runnableExample1 where thread is implemented by anonymous classes");
            }
        };
        Runnable runnableExample2 = () ->{
            System.out.println("You are in runnableExample2 where thread is implemented by using lambda expression");
        };

        Thread threadThree = new Thread(runnableExample1);
        Thread threadFour = new Thread(runnableExample2);

//        threadOne.start();
//        threadTwo.start();
//        threadThree.start();
//        threadFour.start();

        System.out.println();

        Runnable runnableOne= new ThreadOne();
        Runnable runnableTwo = new MyRunnableImplementation();
        Runnable runnableThree = runnableExample1;
        Runnable runnableFour = runnableExample2;

        //In the below invocation every run is called sequentially and not called all at the same timme parallely using thread

        runnableOne.run();
        runnableTwo.run();
        runnableThree.run();
        runnableFour.run();


    }
}
