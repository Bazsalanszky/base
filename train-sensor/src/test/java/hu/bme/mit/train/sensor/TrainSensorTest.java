package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    private TrainSensor sensor;
    private TrainController controller;
    private TrainUser user;

    @Before
    public void init(){
        user = mock(TrainUser.class);
        controller = mock(TrainController.class);
        sensor = new TrainSensorImpl(controller,user);
    }

    @Test
    public void noAlarmTest() {
        when(controller.getReferenceSpeed()).thenReturn(50);
        sensor.overrideSpeedLimit(100);
        assertFalse(sensor.getAlarmStatus());
    }

    @Test
    public void negativeLimitTest() {
        when(controller.getReferenceSpeed()).thenReturn(50);
        sensor.overrideSpeedLimit(-100);
        assert (sensor.getAlarmStatus());
    }

    @Test
    public void limitAbove500Test() {
        when(controller.getReferenceSpeed()).thenReturn(50);
        sensor.overrideSpeedLimit(600);
        assert (sensor.getAlarmStatus());
    }

    @Test
    public void relativeLimitAlarmTest() {
        when(controller.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(50);
        assert (sensor.getAlarmStatus());
    }
}
