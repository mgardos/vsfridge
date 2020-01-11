package ar.net.mgardos.vsfridge.emu.product;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductViewer extends Application {
	private DoubleProperty rotate = new SimpleDoubleProperty(this, "rotate", 60.0d);
	private ObjectProperty<DrawMode> drawMode = new SimpleObjectProperty<>(this, "drawMode", DrawMode.FILL);
	private ObjectProperty<CullFace> cullFace = new SimpleObjectProperty<>(this, "cullFace", CullFace.BACK);

	private Rotate rotateX;
	private Rotate rotateY;
	private Rotate rotateZ;
	private Translate translateZ;

	private ComboBox<DrawMode> drawModeComboBox;
	private ComboBox<CullFace> cullFaceComboBox;
	private Slider rotateSlider;

	@Override
	public void start(Stage stage) throws Exception {
		Camera camera = createCamera();

		drawModeComboBox = createDrawModeComboBox();
		cullFaceComboBox = createCullFaceComboBox();
		rotateSlider = createRotateSlider();

		stage.setTitle("Products viewer");
		stage.setScene(createScene(camera, createProduct()));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private Shape3D createProduct() {
		Box box = new Box(100, 100, 100);
		box.setMaterial(new PhongMaterial(Color.BLUE));
		box.setTranslateX(10.0d);
		box.setTranslateY(10.0d);
		box.setRotationAxis(new Point3D(1.0d, 1.0d, 1.0d));
		box.drawModeProperty().bind(drawMode);
		box.cullFaceProperty().bind(cullFace);
		box.rotateProperty().bind(rotate);

		return box;
	}

	private ComboBox<DrawMode> createDrawModeComboBox() {
		ComboBox<DrawMode> comboBox = new ComboBox<>();
		comboBox.setItems(FXCollections.observableArrayList(DrawMode.FILL, DrawMode.LINE));
		comboBox.setValue(DrawMode.FILL);

		return comboBox;
	}

	private ComboBox<CullFace> createCullFaceComboBox() {
		ComboBox<CullFace> comboBox = new ComboBox<>();
		comboBox.setItems(FXCollections.observableArrayList(CullFace.BACK, CullFace.FRONT, CullFace.NONE));
		comboBox.setValue(CullFace.BACK);

		return comboBox;
	}

	private Slider createRotateSlider() {
		Slider slider = new Slider(-180.0d, 180.0d, 60.0d);
		slider.setMinWidth(400.0d);
		slider.setMajorTickUnit(10.0d);
		slider.setMinorTickCount(5);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.valueProperty().bindBidirectional(rotate);

		return slider;
	}

	private VBox createControlsPanel() {
		HBox panelTopRow = new HBox(10,
		                            new Label("Draw mode:"), drawModeComboBox,
		                            new Label("Cull face:"), cullFaceComboBox);
		panelTopRow.setPadding(new Insets(10, 10, 10, 10));
		panelTopRow.setAlignment(Pos.CENTER_LEFT);

		HBox panelBottomRow = new HBox(10,
		                               new Label("Rotate around (1, 1, 1) axis:"), rotateSlider);
		panelBottomRow.setPadding(new Insets(10, 10, 10, 10));
		panelBottomRow.setAlignment(Pos.CENTER_LEFT);

		VBox panel = new VBox(10, panelTopRow, panelBottomRow);
		panel.setPadding(new Insets(10, 10, 10, 10));

		return panel;
	}

	private Scene createScene(Camera camera, Node... nodes) {
		List<Node> allNodes = Arrays.stream(nodes)
		                            .collect(Collectors.toList());
		allNodes.add(camera);
		Group productsGroup = new Group(allNodes);
		SubScene subScene = new SubScene(productsGroup,
		                                 800,
		                                 400,
		                                 true,
		                                 SceneAntialiasing.BALANCED);
		subScene.setCamera(camera);
		BorderPane sceneLayout = new BorderPane(subScene,
		                                        null,
		                                        null,
		                                        createControlsPanel(),
		                                        null);
		Scene scene = new Scene(sceneLayout,
		                 800,
		                 600,
		                 true,
		                 SceneAntialiasing.BALANCED);

		return scene;
	}

	private Camera createCamera() {
		Camera camera = new PerspectiveCamera(true);
		rotateX = new Rotate(-20, Rotate.X_AXIS);
		rotateY = new Rotate(-20, Rotate.Y_AXIS);
		rotateZ = new Rotate(-20, Rotate.Z_AXIS);
		translateZ = new Translate(0, 0, -250);

		camera.getTransforms().addAll(rotateX, rotateY, rotateZ, translateZ);

		return camera;
	}
}
