import java.io.* ;
import java.net.* ;
import java.util.* ;

public final class webserver2
{
  public static void main(String argv[]) throws Exception{
    // Set the port number.
    int port = 4478;

    // Establish the listen socket.
    ServerSocket welcomeSocket = new ServerSocket(port);

    // Process HTTP service requests in an infinite loop.
    while (true) {
    // Listen for a TCP connection request.
    Socket connectionSocket = welcomeSocket.accept();

    // Construct an object to process the HTTP request message.
    HttpRequest request = new HttpRequest( connectionSocket );

    // Create a new thread to process the request.
    Thread thread = new Thread(request);

    thread.start();
    
    }

    //welcomeSocket.close();
  }
}


final class HttpRequest implements Runnable{
  final static String CRLF = "\r\n";//returning carriage return (CR) and a line feed (LF)
  Socket socket;

  // Constructor
  public HttpRequest(Socket socket) throws Exception
  {
    this.socket = socket;
  }

  public void run(){
    try {
      processRequest();
    } catch (Exception e) {
      System.out.println(e);}
  }

  private void processRequest() throws Exception
  {
    String formdata = null;
    String requestMethod = null;
    Hashtable<String, String> headers = new Hashtable<String,String>();
    String line = null;
    String fileName = null;


    // Get a reference to the socket's input and output streams.
    InputStream instream = socket.getInputStream();
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());

    // Set up input stream filters.
    BufferedReader br = new BufferedReader(new InputStreamReader(instream));//reads the input data

    // Get the request line of the HTTP request message.
    String requestLine = br.readLine();// get /path/file.html version of http

    // Display the request line. For checking
    System.out.println();
    System.out.println("RequestLine:" + requestLine);

    // Extract the filename from the request line.
    StringTokenizer tokens = new StringTokenizer(requestLine);// this is a input method with deliminators

    // Store and display request method for checking
    requestMethod = tokens.nextToken().trim();
    System.out.println("Requestmethod = " + requestMethod);
    fileName = tokens.nextToken().replaceFirst("/", "");
    
    //Display fileName for checking
    System.out.println(fileName);

    //Sends user to Welcome.html if its an empty URL
    if (fileName.equals("")){
      fileName = "welcome.html";
    }

    //Reads the header and stores it in a hashmap
    int idx;
    line = br.readLine();
    while (!line.equals("")) {
      idx = line.indexOf(":");
      if (idx < 0) {
        headers = null;
        break;
      } else {
        headers.put(line.substring(0, idx).toLowerCase(), 
        line.substring(idx+1).trim());
      }
      line = br.readLine();
    }


    //Extracts form data
    if(requestMethod.equals("GET")){
      if(fileName.indexOf("?") != -1){
        String temp[] = fileName.split("\\?");
        fileName = temp[0];
        formdata = temp[1];
      }
    } else if(requestMethod.equals("POST")){
      int contentLength = Integer.parseInt(headers.get("content-length"));
      final char[] data = new char[contentLength];
      for (int i = 0; i < contentLength; i++) {
        data[i] = (char)br.read();
      }
      formdata = new String(data);
    }

    //Display form data for checking
    System.out.println("Form Data:" + formdata);


    //Open the requested file.
    FileInputStream fis = null;
    boolean fileExists = true;
    try {
      fis = new FileInputStream("./" + fileName);
    } catch (FileNotFoundException e) {
      fileExists = false;
    }

    //Display Filestream for checking
    System.out.println("FileInputStream :" + fis);

    //Construct the response message.
    String statusLine = null;
    String contentTypeLine = null;
    String entityBody = null;

    //Prepare response
    if (fileExists) {
      statusLine = "HTTP/1.0 200 OK" + CRLF; //common success message
      contentTypeLine = "Content-type: " + contentType( fileName ) + CRLF;
    }//content info
    else {
      statusLine = "HTTP/1.0 404 Not Found" + CRLF;//common error message
      contentTypeLine = "Content-type: " + "text/html" + CRLF;//content info
      entityBody = "<HTML>" +
        "<HEAD><TITLE>Not Found</TITLE></HEAD>" +
        "<BODY>Not Found</BODY></HTML>";
    }


    //Send the status line.
    os.writeBytes(statusLine);

    //Send the content type line.
    os.writeBytes(contentTypeLine);

    //Send a blank line to indicate the end of the header lines.
    os.writeBytes(CRLF);

    //Send the entity body.
    if (fileExists) {
      if(fileName.endsWith(".php")){
        Process proc = Runtime.getRuntime().exec("C:\\wamp64\\bin\\php\\php5.6.31\\php.exe " + fileName + " " + requestMethod + " " + formdata);
        BufferedReader temp = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        while ((line = temp.readLine()) != null) {
          // System.out.println(line);
          // System.out.println("Ello");
          os.writeBytes(line);
        }

      } else {
        sendBytes(fis, os); 
        fis.close();
      }
    } else {
      os.writeBytes(statusLine);//Send the status line.
      os.writeBytes(entityBody);//Send the an html error message info body.
      os.writeBytes(contentTypeLine);//Send the content type line.
    }

    System.out.println("*****");
    System.out.println(fileName);//print out file request to console
    System.out.println("*****");

    // Close streams and socket.
    os.close();
    br.close();
    socket.close();
  }


  //return the file types
  private static String contentType(String fileName)
  {
    if(fileName.endsWith(".htm") || fileName.endsWith(".html") || fileName.endsWith(".php")) {return "text/html";}
    if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {return "image/jpeg";}
    if(fileName.endsWith(".gif")) {return "image/gif";}
    return "application/octet-stream";
  }


  //set up input output streams
  private static void sendBytes(FileInputStream fis, OutputStream os) throws Exception
  {
    // Construct a 1K buffer to hold bytes on their way to the socket.
    byte[] buffer = new byte[1024];
    int bytes = 0;

    // Copy requested file into the socket's output stream.
    while((bytes = fis.read(buffer)) != -1 )// read() returns minus one, indicating that the end of the file
    {
      os.write(buffer, 0, bytes);
    }
  }
}