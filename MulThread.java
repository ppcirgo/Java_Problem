public class WanShua implements Runnable{  
    public  static volatile   Integer i = 0;
	
    static  WanShua wanShua = new WanShua();
	
    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            synchronized (i){
                i++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(wanShua);
        Thread t2 = new Thread(wanShua);
        t1.start();
        t2.start();
        t1.join();  //join的通俗理解就是：等待t1线程执行完成
        t2.join();
        System.out.println(i);
    }
}



/*
这道题作者想通过线程t1,t2分别对i加1000000，理想结果是2000000，那么问题来了：这个程序的运行结果对不对？
*/
