package ar.net.mgardos.vsfridge.core.label;

/**
 * Behavior of the labeler based on a predictive model.
 *
 * @param <I> Defines the type of the value used to load the predictive model
 * @param <F> Defines the type for the features used by the prediction
 * @param <P> Defines the type of the predicted label
 */
public interface LabelerModel<I, F, P> {
	void load(I identifier);
	P predict(F features);
}
