package com.rainbowbetter.week03;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 单线程的socket程序
@SpringBootApplication
public class LocalHttpServer {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8801);
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
//            Thread.sleep(5);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			printWriter.println("HTTP/1.1 200 OK");
			printWriter.println("Content-Type:text/html;charset=utf-8");
			String body = "welcome to call local server";
			printWriter.println("Content-Length:" + body.getBytes().length);
			printWriter.println();
			printWriter.write(body);
			printWriter.close();
			socket.close();
		} catch (IOException e) { // | InterruptedException e) {
			e.printStackTrace();
		}

	}

}

