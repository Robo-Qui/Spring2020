package interfaces;

import java.util.List;

public interface IRdvInfos {
    int getDuree();
    void setDuree(int length);

    List<IIntitule> getIntitules();
    void setIntitules(List<IIntitule> intitules);


}
