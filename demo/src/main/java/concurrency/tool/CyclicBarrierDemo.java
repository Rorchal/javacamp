package concurrency.tool;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("回调>>"+Thread.currentThread().getName());
                System.out.println("回调>>线程组执行结束");
                System.out.println("==>各个子线程执行结束。。。。");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new readNum(i,cyclicBarrier,i*1000)).start();
        }

        // ==>>>


        System.out.println("==>主线程执行结束。。。。");

        //CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
//        for (int i = 11; i < 16; i++) {
//            new Thread(new readNum(i,cyclicBarrier)).start();
//        }
    }
    static class readNum  implements Runnable{
        private int id;
        private CyclicBarrier cyc;
        private long sleep;
        public readNum(int id,CyclicBarrier cyc,long sleep){
            this.id = id;
            this.cyc = cyc;
            this.sleep = sleep;
        }
        @Override
        public void run() {
            synchronized (this){
                System.out.println("id:"+id+","+Thread.currentThread().getName()+"sleep:"+sleep);
                try {
                    Thread.sleep(sleep);
                    System.out.println("线程组任务" + id + "await之前");
                    cyc.await();
                    System.out.println("线程组任务" + id + "结束，其他任务继续");
                    //cyc.await();   // 注意跟CountDownLatch不同，这里在子线程await
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
