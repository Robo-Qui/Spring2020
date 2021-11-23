package component;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.Date;

@Component
public class FreeSlot {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
