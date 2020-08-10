package com.city.connected.resources;

import com.city.connected.service.ConnectedServiceImpl;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityRoutesResourceTest {
    @InjectMocks
    private CityRoutesResourceImpl cityRoutesResource;

    @Mock
    private ConnectedServiceImpl connectedService;

    @Test
    public void testSourceDestination() {
        String origin="Boston";
        String destination="Philadelphia";
        Mockito.doReturn("yes").when(connectedService).sourceDestination(Mockito.anyString(),Mockito.anyString());
        String response = cityRoutesResource.sourceDestination(origin, destination);
        assertNotNull(response);
    }
}