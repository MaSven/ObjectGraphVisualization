package ch.hsr.ogv.util;

import java.net.URL;

import javafx.scene.Node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.interactivemesh.jfx.importer.ImportException;
import com.interactivemesh.jfx.importer.obj.ObjModelImporter;

/**
 * 
 * @author Simon Gwerder
 * @version OGV 3.1, May 2015
 *
 */
public class ObjModelLoader {
	
	private final static Logger logger = LoggerFactory.getLogger(ObjModelLoader.class);

	public static Node[] load(URL modelUrl) {
		Node[] rootNodes = {};
		if (modelUrl != null) {
			ObjModelImporter tdsImporter = new ObjModelImporter();
			try {
				tdsImporter.read(modelUrl);
			}
			catch (ImportException e) {
				e.printStackTrace();
				logger.debug(e.getMessage());
			}
			return tdsImporter.getImport();
		}
		return rootNodes;
	}
	
}
