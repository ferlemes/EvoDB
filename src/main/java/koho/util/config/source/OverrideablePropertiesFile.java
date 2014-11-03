package koho.util.config.source;

/**
 * A parameter source from a properties file which values may be override by system properties.
 */
public class OverrideablePropertiesFile extends PropertiesFile {
  
  /**
   * {@inheritDoc}
   */
  public OverrideablePropertiesFile(String fileName) {
    super(fileName);
  }
  
  /**
   * {@inheritDoc}
   */
  public String getParameterValue(String parameterName) {
    String parameterValue = System.getProperty(parameterName);
    if (parameterValue == null) {
      parameterValue = super.getParameterValue(parameterName);
    }
    return parameterValue;
  }
  
}
