package com.vti.dubbo.main;

import java.util.UUID;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vti.dubbo.service.UserService;

public class ConsumerMain {

	public static void main(String[] args) {
		ClientThread client = new ClientThread();
		client.setDaemon(Boolean.TRUE);
		Executors.newFixedThreadPool(1).execute(client);
	}
}

class ClientThread extends Thread {

	private ClassPathXmlApplicationContext context;

	public ClientThread() {
		context = new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		context.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				UserService userService = context.getBean(UserService.class);
				System.out.println(
						userService.reg(UUID.randomUUID().toString() + "\t now:" + System.currentTimeMillis()));
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
