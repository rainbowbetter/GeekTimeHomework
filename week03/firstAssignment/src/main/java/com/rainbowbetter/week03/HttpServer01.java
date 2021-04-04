package com.rainbowbetter.week03;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 单线程的socket程序
@SpringBootApplication
public class HttpServer01 {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8802);
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				service(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void service(Socket socket) {
		try {
			String s = OkHttp1.run("http://localhost:8801");
			System.out.println(s);
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}

	}
}


