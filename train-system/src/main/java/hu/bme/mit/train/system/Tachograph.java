package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.time.LocalDateTime;
import java.util.Map;

public class Tachograph {

    private final Table<LocalDateTime,Integer,Integer> table = HashBasedTable.create();

    public void recordData(LocalDateTime time,int joystichPos,int referenceSpeed) {
        table.put(time,joystichPos,referenceSpeed);
    }

   public Map<Integer,Integer> getRows(LocalDateTime time){
        return table.row(time);
    }
}
