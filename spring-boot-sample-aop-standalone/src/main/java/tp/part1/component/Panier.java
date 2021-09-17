package tp.part1.component;

import jdk.internal.net.http.common.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import tp.part1.interfaces.IClient;

import java.util.Map;

public class Panier {
    @Autowired
    public IClient iClient;
    public Map<Integer, Integer> panier;

    public void add(Pair<Integer,Integer> pair) {
        if (panier.containsKey(pair.first)) {
            panier.replace(pair.first, panier.get(pair.first) + pair.second);
        }
        else{
            panier.put(pair.first, pair.second);
        }
    }
}
