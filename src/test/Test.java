package test;

import test.one.CompletedMessage;

public class Test {

    public static void main(String[] args) {

        String requestId = "123456";
        String userinfo = "name";
        CompletedMessage completedMessage = new CompletedMessage(requestId,userinfo);
        completedMessage.setId("789");
        completedMessage.setTtl("3000");
        System.out.println(completedMessage.getId());
        System.out.println(completedMessage.getTtl());
        System.out.println(completedMessage.toString());
        System.out.println(String.format("Info.%d.%d",122,133));
        System.out.println(String.format("Info.%s.%s","122","133"));
//        System.out.println(completedMessage.getId());
    }
}
