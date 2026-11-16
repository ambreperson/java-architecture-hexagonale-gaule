package gaule.village.javanoramix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureRestTestClient
class JavanoramixApplicationTests {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Autowired
	private RestTestClient restTestClient;


	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testRecetteDeLaPotionMagique() {
		var message = "*accorde sa lyre* PLING PLONG… *s'éclaircit la voix* Hum hum… MI-MI-MIIIIII... Le plat Plat[nom=potion magique, quantité=35] est prêt ! ... LAAAAAAA !!";

		restTestClient.post().uri("/potion-magique")
				.exchange()
				.expectStatus()
				.isOk();

		assertTrue(outputStreamCaptor.toString().trim().contains(message));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

}
