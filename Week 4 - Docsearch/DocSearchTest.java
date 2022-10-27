import java.io.IOException;

import org.junit.jupiter.api.Test;

public class DocSearchTest extends DocSearchServer {

	
	@Test
	public void test() throws IOException {
		Handler test = new Handler("technical");
		test.handleRequest("hi");
	}
}
