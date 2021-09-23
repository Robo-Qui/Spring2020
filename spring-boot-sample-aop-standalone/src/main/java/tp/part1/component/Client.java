package tp.part1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.part1.interfaces.*;

@Component
public class Client implements IRun, IClient {

    @Autowired
    private IFastLane iFastLane;
    @Autowired
    private ILane iLane;
    @Autowired
    private IJustHaveALook iJustHaveALook;

    @Autowired
    public Panier panier;

    @Override
    public void run() {
        iLane.addItemToCart(1,5,this.panier);
        iLane.addItemToCart(2,1,this.panier);
        iLane.pay(getPanierPrice(),this,this.panier);
    }

    private int getPanierPrice(){
        int price = 0;
        for(int key : panier.panier.keySet()){
            price += iJustHaveALook.getPrice(key) * panier.panier.get(key);
        }
        return price;
    }
}
