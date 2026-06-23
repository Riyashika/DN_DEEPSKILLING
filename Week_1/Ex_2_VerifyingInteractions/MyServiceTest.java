import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Call method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify interaction happened exactly as expected
        verify(mockApi).getData();

        // Bonus: verify it was called exactly once
        verify(mockApi, times(1)).getData();
    }
}
