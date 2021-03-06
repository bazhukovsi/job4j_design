package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("?msg=Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                        }
                        if (str.contains("?msg=What")) {
                            out.write("What? Dear friend.".getBytes());
                        }
                        if (str.contains("?msg=Exit")) {
                            out.write("Bye...bye".getBytes());
                            socket.close();
                            server.close();
                        }
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in socket localhost" + e);
        }
    }
}
