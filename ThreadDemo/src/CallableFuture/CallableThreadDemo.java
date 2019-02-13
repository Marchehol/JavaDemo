package CallableFuture;
 
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
 
 
public class CallableThreadDemo {
 
	private static int POOL_NUM = 30; // 线程池数量
 
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < POOL_NUM; i++) {
			Callable<Integer> callableThread = new CallableThread();
 
			FutureTask<Integer> thread = new FutureTask<Integer>(callableThread);
			//线程停顿
			Thread.sleep(1000); 
			//执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。  FutureTask 是  Future 接口的实现类
			executorService.submit(thread);
 
			System.out.println(thread.get());
		}
		// 关闭线程池
		executorService.shutdown();
	}
}
 
class CallableThread implements Callable<Integer> {
 
	@Override
	public Integer call() throws Exception {
		System.out.println("通过线程池方式创建的线程Callable方式：" + Thread.currentThread().getName() + " ");
		return 10086;
	}
}
