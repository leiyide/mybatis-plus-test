/**
 * 
 */
package com.leiyide.utils;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ThreadUtils;

import com.leiyide.data.domain.model.VkUser;

import ch.qos.logback.core.util.TimeUtil;

/**
 * @Title:TestDeadLock
 * @Description:  测试死锁
 * @Company: 维坤智能科技 
 * @version v0.1
 * @author leiyide
 * @date 2020年6月10日 上午11:13:15
 */
public class TestDeadLock {
	
	public static void main(String[] args) {
		DeadLock one = new DeadLock();
		one.setFlag(0);
		DeadLock second = new DeadLock();
		second.setFlag(1);
		new Thread(one).start();
		new Thread(second).start();
		
	}
}

class DeadLock implements Runnable{
	
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	private static Object one = new Object();
	
	private static Object second = new Object();

	@Override
	public void run() {
		if (flag == 0) {
			synchronized (one) {
				//当前线程睡眠
				try {
					Thread.sleep(3000);
					for(int i = 0; i < 100; i ++) {
						System.out.println("逻辑处理one" + i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (second) {
					System.out.println("对象2获取锁资源");
				}
			}
		}
		if (flag == 1) {
			synchronized (second) {
				//当前线程睡眠
				try {
					Thread.sleep(3000);
					for(int i = 0; i < 100; i ++) {
						System.out.println("逻辑处理second" + i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (one) {
					System.out.println("对象1获取锁资源");
				}
			}
		}
	}
	
}
