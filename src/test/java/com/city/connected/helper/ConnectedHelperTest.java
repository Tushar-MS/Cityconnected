package com.city.connected.helper;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConnectedHelperTest {
    @InjectMocks
    ConnectedServiceHelper connectedHelper;

    @Test
    public void testReadTextCityFile() throws IOException {
        LinkedHashSet<String> readAllPaths = connectedHelper.readTextCityFile();
        assertNotNull(readAllPaths);
    }

    @Test
    public void testFindPathExist()  {
        String origin="Boston";
        String destination="Philadelphia";
        String isPathExist = connectedHelper.findPathExist(origin, destination);
        assertNotNull(isPathExist);
    }


}
