package ar.net.mgardos.vsfridge.core.ensemble;

import lombok.Getter;

@Getter
public class FridgeModel {
	private String name;
	private String factoryName;
	private int doors;
	private int shelves;
	private float totalCapacity;
	private boolean temperatureMonitor;
	private boolean foodTypeDetection;
	private boolean foodWeightDetection;
	private boolean networkEnabled;
	private boolean remoteAccessEnabled;
	private boolean voiceCommandEnabled;
}
