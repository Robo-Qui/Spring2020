package tp.part1.interfaces;

import jdk.internal.net.http.common.Pair;
import tp.part1.component.Panier;
import java.util.Map;

public interface ILane {
    void addItemToCart(int ref, int quantity, Panier panier);
    void pay(int price, IClient client, Panier panier);
}
