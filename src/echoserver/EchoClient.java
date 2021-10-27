package echoserver;

import java.net.*;
import java.io.*;
import java.util.*;  

public class EchoClient {
  public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {

    String server;
    // Use "127.0.0.1", i.e., localhost, if no server is specified.
    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      // Connect to the server
      Socket socket = new Socket(server, portNumber);
      OutputStream socketOutputStream = socket.getOutputStream();
      InputStream input = socket.getInputStream();

      int bytesRead;
      while ((bytesRead = System.in.read()) != -1) {
          socketOutputStream.write(bytesRead);
          socketOutputStream.flush();
          Byte output = (byte) input.read();
          System.out.println(output);
      }
      socket.shutdownOutput();

      socket.close();

    // Provide some minimal error handling.
    } catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}