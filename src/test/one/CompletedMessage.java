package test.one;

public class CompletedMessage extends BaseMessage{

    String requestId;

    Object userinfo;

    public CompletedMessage(String requestId,Object userinfo){

        this.requestId = requestId;
        this.userinfo = userinfo;
    }

    @Override
    public String toString() {
        return requestId + userinfo + id + ttl;
    }
}
