package tp.part1.component;

import jdk.internal.net.http.common.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tp.part1.data.component.interfaces.IBank;
import tp.part1.data.component.interfaces.IProvider;
import tp.part1.data.component.interfaces.IStore;

import java.util.Map;

@Component
public class Provider implements IProvider {

    @Value("#{${catalogue}}")
    public Map<Integer,Integer> catalogue;

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
