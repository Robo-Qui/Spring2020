package tp.part1.component;

import jdk.internal.net.http.common.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tp.part1.data.component.interfaces.*;

import java.util.Map;

@Component
public class Store implements IFastLane, IJustHaveALook, ILane,IStore {
    @Autowired
    private IBank iBank;
    @Autowired
    private IProvider iProvider;

    @Value("#{${stock}}")
    public Map<Integer,Integer> stock;

    @Override
    public int getPrice(int ref) {
        return iProvider.getPrice(ref);
    }

    @Override
    public boolean isAvaiable(int ref) {
        return stock.containsKey(ref);
    }

    @Override
    public void oneShotOrder(int ref, int quantity,IClient client) {
        if(isAvaiable(ref)){
            if(stock.get(ref) >= quantity){
                //iBank.transfert(getPrice(ref) * quantity, client,this);
                stock.replace(ref, stock.get(ref) - quantity);
            }
        }
    }

    @Override
    public void addItemToCart(int ref, int quantity, Panier panier) {
        if(isAvaiable(ref)){
            if(stock.get(ref) >= quantity){
                panier.add(ref,quantity);
            }
        }
        else{
            System.out.println("Article non disponible");
        }
    }

    @Override
    public void pay(int price, IClient client,Panier panier) {
        for(int key : panier.panier.keySet()){
            stock.replace(key,stock.get(key) - panier.panier.get(key));
        }
        //iBank.transfert(price,client,this);
    }

    public void order(int ref, int quantity){
        iProvider.order(stock,ref,quantity);
    }
}
