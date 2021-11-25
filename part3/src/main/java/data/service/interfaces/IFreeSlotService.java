package data.service.interfaces;

import data.component.model.model.FreeSlot;

import java.util.List;

public interface IFreeSlotService {
    List<FreeSlot> add(FreeSlot slot, List<FreeSlot> slots);

    List<FreeSlot> remove(List<FreeSlot> slots, FreeSlot slot);
}
