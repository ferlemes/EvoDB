package myConfig;

import java.util.logging.Logger;

import myConfig.source.ParameterSource;

/**
 * This class is a holder for parameter values with an encapsulated way of retrieving it.  
 */
public class ParameterHolder {
  
  private static final String DEFAULT_VALUE = null;
  private static final ParameterSource DEFAULT_SOURCE = ParameterSource.SYSTEM_PROPERTY;
  private static Logger LOGGER = Logger.getLogger(ParameterHolder.class.getName());
  
  private final String name;
  private final String defaultValue;
  private final ParameterSource source;
  private String currentValue;
  
  /**
   * Create a parameter holder with a name using the default value and source.
   * 
   * @param name The parameter name.
   */
  public ParameterHolder(String name) {
    this(name, DEFAULT_VALUE, DEFAULT_SOURCE);
  }
  
  /**
   * Create a parameter holder with a name and default value using the default source.
   * 
   * @param name The parameter name.
   * @param defaultValue The default parameter value.
   */
  public ParameterHolder(String name, String defaultValue) {
    this(name, defaultValue, DEFAULT_SOURCE);
  }
  
  /**
   * Create a parameter holder with a name and source using default value.
   * 
   * @param name The parameter name.
   * @param source The The source for the parameter value.
   */
  public ParameterHolder(String name, ParameterSource source) {
    this(name, DEFAULT_VALUE, source);
  }
  
  /**
   * Create a parameter holder with a name and source using default value.
   * 
   * @param name The parameter name.
   * @param defaultValue The default parameter value.
   * @param source The source for the parameter value.
   */
  public ParameterHolder(String name, String defaultValue, ParameterSource source) {
    this.name = name;
    this.defaultValue = defaultValue;
    this.source = source;
  }
  
  /**
   * @return the {@link String} value for the configuration
   */
  public String getValue() {
    if (this.currentValue == null) {
      this.currentValue = this.source.getParameterValue(name); 
      if (this.currentValue == null) {
        this.currentValue = this.defaultValue;
      }
    }
    return this.currentValue;
  }
  
  /**
   * A synonym for getValue() method.
   * 
   * @return the {@link String} value for the configuration
   */
  public String getStringValue() {
    return this.getValue();
  }
  
  /**
   * @return the {@link Integer} value for the configuration
   */
  public Integer getIntegerValue() {
    try {
      return Integer.valueOf(this.getValue());
    } catch (NumberFormatException e) {
      LOGGER.warning("Cannot parse parameter '" + this.name + "' with value '" + this.getValue() + "' to Integer.");
      LOGGER.warning(e.getMessage());
      return null;
    }
  }
  
  /**
   * @return the {@link Boolean} value for the configuration
   */
  public Boolean getBooleanValue() {
      return Boolean.valueOf(this.getValue());
  }
  
  /**
   * Reset cached value.
   */
  public void reset() {
    this.currentValue = null;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return (this.name + "=" + this.getValue());
  }
  
}
