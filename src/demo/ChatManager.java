package demo;

import java.util.Vector;

public class ChatManager {

    private ChatManager(){}
    private static final ChatManager cm = new ChatManager();
    public static final ChatManager getChatManager(){
        return cm;
    }
    Vector<ChatSocket> vector = new Vector<>();

    public void add(ChatSocket cs){
        vector.add(cs);
    }

    public void publish(ChatSocket cs,String out){
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatSocket = vector.get(i);
            if (!csChatSocket.equals(csChatSocket)){
                csChatSocket.out(out);
            }
        }
    }

}
