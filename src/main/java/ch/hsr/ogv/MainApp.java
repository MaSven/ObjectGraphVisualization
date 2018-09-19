package ch.hsr.ogv;

import ch.hsr.ogv.util.ResourceLocator;
import ch.hsr.ogv.util.ResourceLocator.Resource;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;

/**
 * Starts the application.
 * 
 * @author Simon Gwerder, Adrian Rieser
 * @version OGV 3.1, May 2015
 *
 */
public class MainApp extends Application {

	private final static Logger logger = LoggerFactory.getLogger(MainApp.class);

	private final static UncaughtExceptionHandler ueHandler = new UncaughtExceptionHandler() {
		public void uncaughtException(Thread thread, final Throwable throwable) {
			logger.debug("Error in thread " + thread + ": " + throwable.getMessage());
			throwable.printStackTrace();
		}
	};

	public static void main(String[] args) {
		// System.setProperty("prism.lcdtext", "false");
		// System.setProperty("prism.text", "t2k");
		// System.setProperty("prism.marlin", "true");
		Locale.setDefault(new Locale("en", "EN")); // set to English
		Font.loadFont(ResourceLocator.getResourcePath(Resource.SEGOEUI_TTF).toExternalForm(), Font.getDefault().getSize());
		Font.loadFont(ResourceLocator.getResourcePath(Resource.LUCIDASANS_TTF).toExternalForm(), Font.getDefault().getSize());
		Thread.setDefaultUncaughtExceptionHandler(ueHandler);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Thread.currentThread().setUncaughtExceptionHandler(ueHandler);
		new StageBuilder(primaryStage);
	}

}
