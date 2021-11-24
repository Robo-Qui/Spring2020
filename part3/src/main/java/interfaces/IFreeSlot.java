package interfaces;

import java.util.Date;

public interface IFreeSlot {
    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);
}
