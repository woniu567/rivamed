package test.one;

public abstract class BaseMessage {

    String id;

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    String ttl = "1000";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
