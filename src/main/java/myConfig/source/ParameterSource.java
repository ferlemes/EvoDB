package myConfig.source;

/**
 * This class represents any possible parameter retriever.  
 */
public interface ParameterSource {
  
  public ParameterSource SYSTEM_PROPERTY = new SystemProperty();
  
  /**
   * Get the parameter value given a parameter name.
   * 
   * @param parameterName the parameter name
   * @return the value
   */
  public String getParameterValue(String parameterName);
  
}
