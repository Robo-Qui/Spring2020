package data.component.model.model;

import data.component.interfaces.IFreeSlot;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FreeSlot implements IFreeSlot {
    private Date startTime;
    private Date endTime;
    private Long id;

    public FreeSlot() {
    }

    public FreeSlot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id){
        this.id = id;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }
    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }
    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
