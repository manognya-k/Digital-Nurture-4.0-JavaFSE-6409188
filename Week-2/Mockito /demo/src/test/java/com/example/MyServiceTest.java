package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Inject mock into service
        MyService service = new MyService(mockApi);

        // 3. Call the method
        service.fetchData();

        // 4. Verify that getData() was called
        verify(mockApi).getData();
    }
}
