package listsort;

import java.util.List;

public class Dto {

    private List<Entity> entities;
    private List<String> list;
    private BspAccount bspAccount;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public BspAccount getBspAccount() {
        return bspAccount;
    }

    public void setBspAccount(BspAccount bspAccount) {
        this.bspAccount = bspAccount;
    }
}
