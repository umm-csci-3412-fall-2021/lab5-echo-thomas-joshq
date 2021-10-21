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
      int count;
      byte[] buffer = new byte[8192]; // or 4096, or more
      while ((count = System.in.read(buffer)) > 0)
      {
        socketOutputStream.write();
      InputStream input = socket.getInputStream();
      byte output = (byte) input.read();
      System.out.println(output);
      }

      byte b = (byte) System.in.read();


    

    

      socket.shutdownOutput();

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