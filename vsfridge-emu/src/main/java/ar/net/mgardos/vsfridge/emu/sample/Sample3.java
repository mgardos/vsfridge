package ar.net.mgardos.vsfridge.emu.sample;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;

public class Sample3 extends Application {
	private Model model;
	private View view;

	public Sample3() {
		model = new Model();
	}

	@Override
	public void start(Stage stage) throws Exception {
		view = new View(model);
		stage.setTitle("Light Example");
		stage.setScene(view.scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private class CameraModel {
		private DoubleProperty rotateX = new SimpleDoubleProperty(this, "rotateX", -20.0d);
		private DoubleProperty rotateY = new SimpleDoubleProperty(this, "rotateY", -20.0d);
		private DoubleProperty rotateZ = new SimpleDoubleProperty(this, "rotateZ", -20.0d);

		public DoubleProperty rotateXProperty() {
			return rotateX;
		}

		public DoubleProperty rotateYProperty() {
			return rotateY;
		}

		public DoubleProperty rotateZProperty() {
			return rotateZ;
		}
	}

	private class RedLightModel {
		private DoubleProperty redLightX = new SimpleDoubleProperty(this, "redLightX", 20.0d);
		private DoubleProperty redLightY = new SimpleDoubleProperty(this, "redLightY", -15.0d);
		private DoubleProperty redLightZ = new SimpleDoubleProperty(this, "redLightZ", -20.0d);

		public DoubleProperty redLightXProperty() {
			return redLightX;
		}

		public DoubleProperty redLightYProperty() {
			return redLightY;
		}

		public DoubleProperty redLightZProperty() {
			return redLightZ;
		}
	}

	private class BlueLightModel {
		private DoubleProperty blueLightX = new SimpleDoubleProperty(this, "blueLightX", 15.0d);
		private DoubleProperty blueLightY = new SimpleDoubleProperty(this, "blueLightY", -15.0d);
		private DoubleProperty blueLightZ = new SimpleDoubleProperty(this, "blueLightZ", -5.0d);

		public DoubleProperty blueLightXProperty() {
			return blueLightX;
		}

		public DoubleProperty blueLightYProperty() {
			return blueLightY;
		}

		public DoubleProperty blueLightZProperty() {
			return blueLightZ;
		}
	}

	private class Model {
		private CameraModel cameraModel;
		private RedLightModel redLightModel;
		private BlueLightModel blueLightModel;

		Model() {
			cameraModel = new CameraModel();
			redLightModel = new RedLightModel();
			blueLightModel = new BlueLightModel();
		}

		CameraModel getCameraModel() {
			return cameraModel;
		}

		RedLightModel getRedLightModel() {
			return redLightModel;
		}

		BlueLightModel getBlueLightModel() {
			return blueLightModel;
		}
	}

	private class View {
		public Scene scene;

		private Box box;
		private PerspectiveCamera camera;
		private PointLight redLight;
		private PointLight blueLight;

		private MeshView mesh;

		private Rotate cameraRotateX;
		private Rotate cameraRotateY;
		private Rotate cameraRotateZ;
		private Translate translateZ;

		private View(Model model) {
			box = new Box(10, 10, 10);

			mesh = createShape();

			createCamera(model.getCameraModel());
			createRedLight(model.getRedLightModel());
			createBlueLight(model.getBlueLightModel());

			SubScene subScene = createShapeScene();

			HBox cameraControl = createCameraRotateControl(model.getCameraModel());
			HBox redLightControl = createRedLightControl(model.getRedLightModel());
			HBox blueLightControl = createBlueLightControl(model.getBlueLightModel());

			VBox controlsPanel = new VBox(10, cameraControl, redLightControl, blueLightControl);
			controlsPanel.setPadding(new Insets(10, 10, 10, 10));
			controlsPanel.setAlignment(Pos.CENTER);
			BorderPane borderPane = new BorderPane(subScene, null, null, controlsPanel, null);
			scene = new Scene(borderPane);
		}

		private SubScene createShapeScene() {
			Group group = new Group(mesh, camera, redLight, blueLight);
			SubScene subScene = new SubScene(group, 800, 600, true, SceneAntialiasing.BALANCED);
			subScene.setCamera(camera);

			return subScene;
		}

		private void createBlueLight(BlueLightModel model) {
			blueLight = new PointLight(Color.BLUE);
			blueLight.translateXProperty().bind(model.blueLightXProperty());
			blueLight.translateYProperty().bind(model.blueLightYProperty());
			blueLight.translateZProperty().bind(model.blueLightZProperty());
		}

		private void createRedLight(RedLightModel model) {
			redLight = new PointLight(Color.RED);
			redLight.translateXProperty().bind(model.redLightXProperty());
			redLight.translateYProperty().bind(model.redLightYProperty());
			redLight.translateZProperty().bind(model.redLightZProperty());
		}

		private HBox createCameraRotateControl(CameraModel model) {
			Slider rotateXSlider = createSlider(-180.0d, 180.0d, -20.0d);
			rotateXSlider.valueProperty().bindBidirectional(model.rotateXProperty());

			Slider rotateYSlider = createSlider(-180.0d, 180.0d, -20.0d);
			rotateYSlider.valueProperty().bindBidirectional(model.rotateYProperty());

			Slider rotateZSlider = createSlider(-180.0d, 180.0d, -20.0d);
			rotateZSlider.valueProperty().bindBidirectional(model.rotateZProperty());

			HBox controlPanel = new HBox(10, new Label("Camera rotate x:"), rotateXSlider,
			                             new Label("y:"), rotateYSlider,
			                             new Label("z:"), rotateZSlider);
			controlPanel.setPadding(new Insets(10, 10, 10, 10));
			controlPanel.setAlignment(Pos.CENTER);

			return controlPanel;
		}

		private HBox createBlueLightControl(BlueLightModel model) {
			Slider blueLightXSlider = createSlider(15);
			Slider blueLightYSlider = createSlider(-15);
			Slider blueLightZSlider = createSlider(-15);
			blueLightXSlider.valueProperty().bindBidirectional(model.blueLightXProperty());
			blueLightYSlider.valueProperty().bindBidirectional(model.blueLightYProperty());
			blueLightZSlider.valueProperty().bindBidirectional(model.blueLightZProperty());

			HBox controlPanel = new HBox(10, new Label("Blue light x:"), blueLightXSlider,
			                             new Label("y:"), blueLightYSlider,
			                             new Label("z:"), blueLightZSlider);
			controlPanel.setPadding(new Insets(10, 10, 10, 10));
			controlPanel.setAlignment(Pos.CENTER);

			return controlPanel;
		}

		private HBox createRedLightControl(RedLightModel model) {
			Slider redLightXSlider = createSlider(20);
			Slider redLightYSlider = createSlider(-20);
			Slider redLightZSlider = createSlider(-20);
			redLightXSlider.valueProperty().bindBidirectional(model.redLightXProperty());
			redLightYSlider.valueProperty().bindBidirectional(model.redLightYProperty());
			redLightZSlider.valueProperty().bindBidirectional(model.redLightZProperty());

			HBox controlPanel = new HBox(10, new Label("Red light x:"), redLightXSlider,
			                      new Label("y:"), redLightYSlider,
			                      new Label("z:"), redLightZSlider);
			controlPanel.setPadding(new Insets(10, 10, 10, 10));
			controlPanel.setAlignment(Pos.CENTER);

			return controlPanel;
		}

		private void createCamera(CameraModel model) {
			camera = new PerspectiveCamera(true);

			cameraRotateX = new Rotate(-20, Rotate.X_AXIS);
			cameraRotateY = new Rotate(-20, Rotate.Y_AXIS);
			cameraRotateZ = new Rotate(-20, Rotate.Z_AXIS);
			translateZ = new Translate(0, 0, -50);

			camera.getTransforms().addAll(cameraRotateX, cameraRotateY, cameraRotateZ, translateZ);

			cameraRotateX.angleProperty().bind(model.rotateXProperty());
			cameraRotateY.angleProperty().bind(model.rotateYProperty());
			cameraRotateZ.angleProperty().bind(model.rotateZProperty());
		}

		private Slider createSlider(double value) {
			return createSlider(-30.0d, 30.0d, value);
		}

		private Slider createSlider(double min, double max, double value) {
			Slider slider = new Slider(min, max, value);
			slider.setShowTickMarks(true);
			slider.setShowTickLabels(true);

			return slider;
		}

		private MeshView createShape() {
			double radius = 10.0d;
			double radiansStep = Math.PI / 4;
			float[] points = new float[10 * 3];
			points[0] = 0f;
			points[1] = 0f;
			points[2] = 0f;
			IntStream.range(0, 8).forEach(step -> {
				points[((step + 1) * 3) + 1] = BigDecimal.valueOf(radius * Math.cos(step * radiansStep))
				                                         .setScale(4, RoundingMode.HALF_UP)
				                                         .floatValue();
				points[((step + 1) * 3) + 2] = 0f;
				points[((step + 1) * 3) + 3] = BigDecimal.valueOf(radius * Math.sin(step * radiansStep))
				                                         .setScale(4, RoundingMode.HALF_UP)
				                                         .floatValue();

				System.out.println(String.format("Point %d { x=%f, y=%f, z=%f }",
				                                 step + 1,
				                                 points[((step + 1) * 3) + 1],
				                                 points[((step + 1) * 3) + 2],
				                                 points[((step + 1) * 3) + 3]));
			});
			points[27] = points[3];
			points[28] = points[4];
			points[29] = points[5];

			int[] faces = new int[8 * 6];
			IntStream.range(0, 8).forEach(step -> {
				faces[step * 6] = 0;
				faces[(step * 6) + 1] = 0;
				faces[(step * 6) + 2] = step + 1;
				faces[(step * 6) + 3] = 0;
				faces[(step * 6) + 4] = step + 2;
				faces[(step * 6) + 5] = 0;
			});

			TriangleMesh mesh = new TriangleMesh();
			mesh.getPoints().addAll(points);
			mesh.getTexCoords().addAll(0f, 0f);
			mesh.getFaces().addAll(faces);

			MeshView meshView = new MeshView(mesh);
			meshView.setDrawMode(DrawMode.LINE);

			return meshView;
		}
	}
}
