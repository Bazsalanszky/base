package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TrainUserTest {

    private TrainUser user;
    private TrainController controller;


    @Before
    public void init() {
        controller = mock(TrainController.class);
        user = new TrainUserImpl(controller);
    }

    @Test
    public void alarmTest() {
        assertFalse (user.getAlarmFlag());
    }

    @Test
    public void alarmTest2() {
        user.setAlarmState(true);
        assertTrue (user.getAlarmFlag());
    }

    @Test
    public void joystickPositon() {
        user.overrideJoystickPosition(1);
        assertEquals(1,user.getJoystickPosition());
    }
}
