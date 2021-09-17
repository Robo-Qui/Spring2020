package tp.part1.component;

import jdk.internal.net.http.common.Pair;
import org.springframework.stereotype.Component;
import tp.part1.interfaces.IBank;
import tp.part1.interfaces.IProvider;
import tp.part1.interfaces.IStore;

import java.util.Map;

@Component
public class Provider implements IProvider {

    public Map<Integer,Integer> catalogue;

    public Provider(){
        catalogue.put(1,100);
        catalogue.put(2,50);
        catalogue.put(3,25);
    }

    @Override
    public int getPrice(int ref) {
        if(catalogue.containsKey(ref)){
            return catalogue.get(ref);
        }
        else{
            return -1;
        }
    }

    @Override
    public void order(Map<Integer,Integer> stock, int ref, int quantity) {
        if(!stock.containsKey(ref)){
            stock.put(ref,quantity);
        }
        else{
            stock.replace(ref, stock.get(ref) + quantity);
        }
    }
}
