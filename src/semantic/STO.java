package semantic;

import parser.*;

public class STO extends Object {

  String type;  
  String value;
  int index;
  boolean initialized;

  public STO(String type) {
    this.type = type;
    this.value = null;
    this.initialized = false;
  }

  public STO(String type, String value) {
    this.type = type;
    this.value = value;
    this.initialized = false;
  }

  public String getType() {
    return this.type;
  }

  public String toString() {
    return this.type;
  }

  public int getIndex() {
    return this.index;
  }

  public void initialize() {
    this.initialized = true;
  }

  public boolean isInitialized() {
    return this.initialized;
  }
}