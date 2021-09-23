package tp.part1.component;

import jdk.internal.net.http.common.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.part1.interfaces.IClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class Panier {
    @Autowired
    public IClient iClient;
    public Map<Integer, Integer> panier = new HashMap<>();

    public void add(int ref, int quantity) {
        if (panier.containsKey(ref)) {
            panier.replace(ref, panier.get(ref) + quantity);
        }
        else{
            panier.put(ref, quantity);
        }
    }
}
