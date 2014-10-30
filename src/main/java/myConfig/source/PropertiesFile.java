package myConfig.source;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * A parameter source given a properties file.
 */
public class PropertiesFile implements ParameterSource {
  
  private static final Logger LOGGER = Logger.getLogger(PropertiesFile.class.getName());
  
  private static final String COULD_NOT_READ_PROPERTY_FILE = "Não foi possível ler o arquivo de propriedades: ";
  
  Properties fileProperties = new Properties();
  
  /**
   * Create the parameter source using a properties file.
   * 
   * @param fileName the absolute filename.
   */
  public PropertiesFile(String fileName) {
    InputStream propertiesResource = this.getClass().getClassLoader().getResourceAsStream(fileName);
    try {
      if (propertiesResource != null) {
        this.fileProperties.load(propertiesResource);
      }
      else {
        LOGGER.warning(COULD_NOT_READ_PROPERTY_FILE + fileName);
      }
    }
    catch(IOException e) {
      LOGGER.warning(COULD_NOT_READ_PROPERTY_FILE + fileName);
      LOGGER.warning(e.getMessage());
    }
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String getParameterValue(String parameterName) {
    return this.fileProperties.getProperty(parameterName);
  }
  
}
