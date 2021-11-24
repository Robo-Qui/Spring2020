package interfaces;

import component.RdvInfos;

import java.util.List;

public interface IProfessionnal extends IAccount{
    String getName();
    void setName(String name);

    IRdvInfos getRdvInfos();
    void setRdvInfos(RdvInfos rdvInfo);

    List<IFreeSlot> getFreeSlots();
    void setFreeSlots(List<IFreeSlot> freeSlots);
}
