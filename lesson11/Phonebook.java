package lesson11;

import java.util.HashMap;
import java.util.Map;

public class Phonebook extends HashMap {
    HashMap<Integer, String> phonebook = new HashMap<>(16);

    public void add(Integer number, String name) {
        phonebook.put(number, name);
    }

    Object get(String name) {
        HashMap<Integer, String> res = new HashMap<>(phonebook.size());
        for (Map.Entry<Integer, String> o : phonebook.entrySet()) {
            if (o.getValue().equals(name)) {
                res.put(o.getKey(),o.getValue());
            }
        }
        return res;
    }

}
