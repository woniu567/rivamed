package listsort;

import java.util.ArrayList;
import java.util.List;

public class DtoTest {

    public static void main(String[] args) {

        Dto dto = new Dto();
        List<Entity> entities = new ArrayList<>();
        List<String> list = new ArrayList<>();
        BspAccount bspAccount = new BspAccount();
        dto.setEntities(entities);
        dto.setList(list);
        dto.setBspAccount(bspAccount);

        for (int i = 0; i < 2; i++) {
            Entity entity = new Entity();
            entity.setName("sansan" + i);
            entity.setAge(1 + i);
            entities.add(entity);
            list.add("list" + i);
        }
        bspAccount.setAccountId("202005151650");
        bspAccount.setAccountName("ceshizhanghu");

        for (Entity e : dto.getEntities()) {
            System.out.println(e.getName() + ".." + e.getAge());
        }
    }
}
