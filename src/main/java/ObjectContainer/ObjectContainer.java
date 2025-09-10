package ObjectContainer;

import java.util.HashMap;

public class ObjectContainer {

    HashMap<String, Object> objectContainer = new HashMap<>();

    public void register(String key, Object object){
        objectContainer.put(key,object);
    }

    public Object getObject(String key){
        return objectContainer.get(key);
    }
}
