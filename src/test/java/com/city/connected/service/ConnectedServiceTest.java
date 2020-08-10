package com.city.connected.service;

import com.city.connected.helper.ConnectedServiceHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConnectedServiceTest {

    @InjectMocks
    ConnectedServiceImpl connectedService;

    @Mock
    private ConnectedServiceHelper connectedServiceHelper;

    @Test
    public void testSourceDestination()  {
        String origin="Boston";
        String destination="Philadelphia";
        Mockito.doReturn("yes").when(connectedServiceHelper).findPathExist(Mockito.anyString(),Mockito.anyString());

        String response = connectedService.sourceDestination(origin, destination);
        assertNotNull(response);
    }
}
