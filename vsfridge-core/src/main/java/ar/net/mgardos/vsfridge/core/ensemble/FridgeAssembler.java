package ar.net.mgardos.vsfridge.core.ensemble;

import ar.net.mgardos.vsfridge.core.component.SmartFridge;

public interface FridgeAssembler {
	/**
	 * Sets the factory that creates compatibles components that make up a fridge.
	 *
	 * @param factory capable of creating Fridge components
	 */
	void registerComponentsFactory(FridgeFactory factory);

	/**
	 * Sets the builder that assembles components to make up a functional Fridge.
	 *
	 * @param builder capable of assembling Fridge components
	 */
	void registerComponentsBuilder(FridgeBuilder builder);

	/**
	 * Creates a Fridge based on the model features, using the factory and build to create and assemble the
	 * components.
	 *
	 * @param model describes the features of the Fridge to be created
	 * @return the Fridge with the specified features
	 */
	SmartFridge makeFridge(FridgeModel model);
}
