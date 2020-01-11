package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;

import java.time.Instant;
import java.util.Optional;

public class BaseFridgeDoor implements FridgeDoor {
	static final String ALREADY_OPENED = "The fridge door is already opened.";
	static final String ALREADY_CLOSED = "The fridge door is already closed.";

	private Boolean isOpened;
	private Integer timesOpened;
	private Long timeElapsed;

	public BaseFridgeDoor() {
		isOpened = false;
		timesOpened = 0;
		timeElapsed = 0L;
	}

	@Override
	public Boolean isOpened() {
		return isOpened;
	}

	@Override
	public void open() {
		Optional.of(isOpened)
				.filter(opened -> opened == false)
				.orElseThrow(() -> new IllegalStateException(ALREADY_OPENED));
		isOpened = true;
		timesOpened++;
		timeElapsed = timeElapsed();
	}

	@Override
	public void close() {
		Optional.of(isOpened)
		        .filter(opened -> opened == true)
		        .orElseThrow(() -> new IllegalStateException(ALREADY_CLOSED));
		timeElapsed = timeElapsed();
		isOpened = false;
	}

	@Override
	public Long timeElapsed() {
		return Optional.of(isOpened)
		               .filter(opened -> opened == true)
		               .map(opened -> Instant.now().getEpochSecond() - timeElapsed)
		               .orElse(timeElapsed);
	}

	@Override
	public Integer timesOpened() {
		return timesOpened;
	}
}
