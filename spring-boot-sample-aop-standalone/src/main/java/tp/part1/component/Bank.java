package tp.part1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.part1.interfaces.IBank;
import tp.part1.interfaces.IClient;
import tp.part1.interfaces.IProvider;
import tp.part1.interfaces.IStore;

import java.util.Map;

@Component
public class Bank implements IBank {

    private Map<IClient,Integer> comptesClients ;
    private Map<IStore,Integer> comptesMagasins;
    private Map<IProvider,Integer> comptesFournisseurs;

    @Override
    public void transfert(int price, IClient client, IStore store) {
        Integer soldeClient = comptesClients.getOrDefault(client,null);
        if(soldeClient != null && soldeClient>price){
            Integer soldeMagasin = comptesMagasins.getOrDefault(store,null);
            if(soldeMagasin != null){
                comptesClients.replace(client, soldeClient-price);
                comptesMagasins.replace(store, soldeMagasin-price);
            }
            else{
                System.out.println("Store inexistant");
            }
        }
        else{
            System.out.println("Solde insuffisant ou client inexistant");
        }
    }
}
