package koho.util.config.source;

/**
 * This class retrieves parameters values from the system properties. 
 */
public class SystemProperty implements ParameterSource {
  
  /**
   * {@inheritDoc}
   */
  public String getParameterValue(String parameterName) {
    return System.getProperty(parameterName);
  }
  
}
