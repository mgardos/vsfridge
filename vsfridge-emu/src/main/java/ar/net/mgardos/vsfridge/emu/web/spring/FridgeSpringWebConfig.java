package ar.net.mgardos.vsfridge.emu.web.spring;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeBroker;
import ar.net.mgardos.vsfridge.assembly.broker.FridgeStore;
import ar.net.mgardos.vsfridge.assembly.broker.base.BaseFridgeBroker;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FridgeSpringWebConfig {
	@Bean
	public FridgeBroker fridgeBroker() {
		return new BaseFridgeBroker();
	}

	@Bean
	public FridgeAssembler fridgeAssembler() {
		return null;
	}

	@Bean
	public FridgeStore fridgeStore() {
		return null;
	}
}
