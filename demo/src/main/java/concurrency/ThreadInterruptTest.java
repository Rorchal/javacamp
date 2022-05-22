package concurrency;

public class ThreadInterruptTest {
    static  int x = 5;
    public static void main(String[] args) {
        int y =5;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("x的值:"+ThreadInterruptTest.x);
                        System.out.println("y的值:"+y);
                        System.out.println(Thread.currentThread().getName()+"--->"+"中断");
                        e.printStackTrace();
                        return;

                    }
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        ThreadInterruptTest.x = 7;
        thread.interrupt();
    }
}

