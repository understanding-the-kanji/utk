package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.Configuration;
import org.junit.jupiter.api.Test;

public class FirstTimeSetupTest {

    @Test
    public void firstTimeSetupTest() {
        try {
            Configuration configuration = Configuration.GetInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
