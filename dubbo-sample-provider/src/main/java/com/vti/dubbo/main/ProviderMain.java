package com.vti.dubbo.main;

import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderMain {
	public static void main(String[] args) {

		Server server = new Server();
		server.setDaemon(Boolean.TRUE);
		Executors.newFixedThreadPool(1).execute(server);

	}
}

class Server extends Thread {

	private ClassPathXmlApplicationContext context;

	public Server() {
		context = new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		context.start();
	}
}
