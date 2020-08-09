package ar.net.mgardos.vsfridge.emu.web.spring;

import ar.net.mgardos.vsfridge.assembly.broker.FridgeBroker;
import ar.net.mgardos.vsfridge.assembly.broker.base.usage.BaseCloseDoorUsage;
import ar.net.mgardos.vsfridge.assembly.broker.base.usage.BaseOpenDoorUsage;
import ar.net.mgardos.vsfridge.assembly.broker.usage.FridgeUsage;
import ar.net.mgardos.vsfridge.emu.FridgeDoorController;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Log4j2
@RestController
public class FridgeDoorSpringWebController implements FridgeDoorController<String, String> {
	private static final String INVALID_BROKER = "Fridge broker nor present when opening door %s of fridge %s.";
	private static final String UNABLE_TO_OPEN_DOOR = "Unable to open door %s of fridge %s due to broker error.";

	@Setter(onMethod = @__({@Autowired}))
	private FridgeBroker fridgeBroker;

	@Override
	@PatchMapping(value = "/fridge/{fridgeId}/door/{doorId}/open")
	public void open(@PathVariable("fridgeId") final String fridgeId, @PathVariable("doorId") final String doorId) {
		log.info(String.format("Incoming request for opening door %s from fridge %s.", doorId, fridgeId));

		checkForValidBroker(fridgeId, doorId);

		try {
			final FridgeUsage openDoor = new BaseOpenDoorUsage<String>(doorId);
			fridgeBroker.useFridge(fridgeId, openDoor);
		} catch (final Exception e) {
			log.error(String.format(UNABLE_TO_OPEN_DOOR, doorId, fridgeId));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(UNABLE_TO_OPEN_DOOR, doorId, fridgeId), e);
		}

		log.info(String.format("The door %s from fridge %s was opened successfully.", doorId, fridgeId));
	}

	@Override
	@PatchMapping(value = "/fridge/{fridgeId}/door/{doorId}/close")
	public void close(@PathVariable("fridgeId") final String fridgeId, @PathVariable("doorId") final String doorId) {
		log.info(String.format("Incoming request for closing door %s from fridge %s.", doorId, fridgeId));

		FridgeUsage closeDoor = new BaseCloseDoorUsage<String>(doorId);
		fridgeBroker.useFridge(fridgeId, closeDoor);

		log.info(String.format("The door %s from fridge %s was closed successfully.", doorId, fridgeId));
	}

	private void checkForValidBroker(final String fridgeId, final String doorId) {
		Optional.ofNullable(fridgeBroker)
		        .orElseThrow(() -> {
			        log.error(() -> String.format(INVALID_BROKER, fridgeId, doorId));
			        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(INVALID_BROKER, fridgeId, doorId));
		        });
	}
}
