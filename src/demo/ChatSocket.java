package demo;

import java.io.*;
import java.net.Socket;

public class ChatSocket extends Thread{

    Socket socket;
    public ChatSocket(Socket socket){
        this.socket = socket;
    }

    public void out(String out){
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine())!=null){
                ChatManager.getChatManager().publish(this,line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*int count = 0;
        while (true){
            count++;
            out("loop:"+count+"; ");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/


        /*try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            int count = 0;
            while (true){
                bw.write("loop:" + count);
                sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
//telnet localhost 12345