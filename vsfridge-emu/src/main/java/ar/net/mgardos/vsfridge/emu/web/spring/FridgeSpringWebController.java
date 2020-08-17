package ar.net.mgardos.vsfridge.emu.web.spring;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeBroker;
import ar.net.mgardos.vsfridge.assembly.broker.base.usage.BaseCheckPluggedFridgeUsage;
import ar.net.mgardos.vsfridge.assembly.broker.base.usage.BasePlugFridgeUsage;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.core.Product;
import ar.net.mgardos.vsfridge.core.ensemble.FridgeModel;
import ar.net.mgardos.vsfridge.emu.FridgeController;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Log4j2
@RestController
public class FridgeSpringWebController implements FridgeController<String> {
	private static final String INVALID_BROKER = "Fridge broker not present, unable to %s for fridge %s.";
	private static final String INVALID_BROKER_FOR_NEW_FRIDGE = "Fridge broker not present, unable to create new fridge.";
	private static final String UNABLE_TO_USE_FRIDGE = "Unable to %s for fridge %s due to broker error.";
	private static final String INVALID_FRIDGE_STATE = "After using fridge %s, it is not %s.";
	private static final String UNABLE_TO_DISCARD_FRIDGE = "Unable to discard fridge %s after failing to %s.";

	@Setter(onMethod = @__({@Autowired}))
	private FridgeBroker fridgeBroker;

	@Override
	@GetMapping("/fridge/{fridgeId}/isplugged")
	public boolean isPlugged(@PathVariable("fridgeId") final String fridgeId) {
		log.info(String.format("Incoming request for checking if fridge %s is plugged.", fridgeId));

		checkForValidBroker(String.format(INVALID_BROKER, "check if plugged", fridgeId));

		boolean fridgePlugged;
		try {
			final FridgeUsage checkIfPlugged = new BaseCheckPluggedFridgeUsage();
			fridgePlugged = fridgeBroker.useFridge(fridgeId, checkIfPlugged).isPlugged();
		} catch (final Exception e) {
			log.error(String.format(UNABLE_TO_USE_FRIDGE, "check if plugged", fridgeId));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(UNABLE_TO_USE_FRIDGE, "check if plugged", fridgeId), e);
		}

		log.info(String.format("The fridge %s is currently %s.", fridgeId, fridgePlugged ? "plugged" : "not plugged"));

		return fridgePlugged;
	}

	@Override
	@PostMapping("/fridge/plug")
	public String plug(@RequestBody final FridgeModel model) {
		log.info("Incoming request for plugging a new fridge.");

		checkForValidBroker(INVALID_BROKER_FOR_NEW_FRIDGE);

		String fridgeId = "";
		boolean fridgePlugged;
		try {
			fridgeId = fridgeBroker.makeFridge(model);
			final FridgeUsage plugFridge = new BasePlugFridgeUsage();
			fridgePlugged = fridgeBroker.useFridge(fridgeId, plugFridge).isPlugged();
		} catch (final Exception e) {
			log.error(String.format(UNABLE_TO_USE_FRIDGE, "plug", fridgeId));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(UNABLE_TO_USE_FRIDGE, "plug", fridgeId), e);
		}

		if (!fridgePlugged) {
			try {
				fridgeBroker.discardFridge(fridgeId);
			} catch (final Exception e) {
				log.error(String.format(UNABLE_TO_DISCARD_FRIDGE, fridgeId, "plug"));
			}
			log.error(String.format(INVALID_FRIDGE_STATE, fridgeId, "plugged"));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(INVALID_FRIDGE_STATE, fridgeId, "plugged"));
		}

		log.info(String.format("The fridge %s is now created and plugged.", fridgeId));

		return fridgeId;
	}

	@Override
	@DeleteMapping("/fridge/{fridgeId}/unplug")
	public void unplug(@PathVariable("fridgeId") final String fridgeId) {
		log.info(String.format("Incoming request for checking if fridge %s is plugged.", fridgeId));

		checkForValidBroker(String.format(INVALID_BROKER, "unplug", fridgeId));

		try {
			final FridgeUsage unplug = null;
			fridgeBroker.useFridge(fridgeId, unplug);
		} catch (final Exception e) {
			log.error(String.format(UNABLE_TO_USE_FRIDGE, "unplug", fridgeId));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(UNABLE_TO_USE_FRIDGE, "unplug", fridgeId), e);
		}

		log.info(String.format("The fridge %s is currently %s.", fridgeId, ""));
	}

	@Override
	@GetMapping("/fridge/{fridgeId}/isturnedon")
	public boolean isTurnedOn(@PathVariable("fridgeId") final String fridgeId) {
		return false;
	}

	@Override
	@PatchMapping("/fridge/{fridgeId}/turnon")
	public void turnOn(@PathVariable("fridgeId") final String fridgeId) {

	}

	@Override
	@PatchMapping("/fridge/{fridgeId}/turnoff")
	public void turnOff(@PathVariable("fridgeId") final String fridgeId) {

	}

	@Override
	@PutMapping("/fridge/{fridgeId}/putproduct")
	public void put(@RequestBody final Product product) {

	}

	@Override
	@PutMapping("/fridge/{fridgeId}/takeproduct")
	public void take(@RequestBody final Product product) {

	}

	private void checkForValidBroker(final String message) {
		Optional.ofNullable(fridgeBroker)
				.orElseThrow(() -> {
					log.error(() -> message);
					return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message);
				});
	}
}
