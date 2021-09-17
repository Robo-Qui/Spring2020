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

    public Panier panier;

    @Override
    public void run() {

        System.out.println("PAPOPE");
        iFastLane.oneShotOrder(1,1,this);
    }

    private int getPanierPrice(){
        int price = 0;
        for(int key : panier.panier.keySet()){
            price += iJustHaveALook.getPrice(key) * panier.panier.get(key);
        }
        return price;
    }
}
