package services.interfaces;

import data.model.FreeSlot;

import java.util.List;

public interface IFreeSlotService {
    List<FreeSlot> add(FreeSlot slot, List<FreeSlot> slots);

    List<FreeSlot> remove(List<FreeSlot> slots, FreeSlot slot);

}
