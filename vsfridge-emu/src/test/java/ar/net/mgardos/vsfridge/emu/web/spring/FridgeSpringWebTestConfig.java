package ar.net.mgardos.vsfridge.emu.web.spring;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeBroker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Configuration
@Profile("test")
public class FridgeSpringWebTestConfig {
	private FridgeBroker fridgeBroker = mock(FridgeBroker.class);

	@Primary
	@Bean
	public FridgeBroker fridgeBroker() {
		return fridgeBroker;
	}
}
