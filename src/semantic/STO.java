package semantic;

import parser.*;

public class STO extends Object {

  String type;  
  int value;
  boolean constant;
  int index;
  boolean initialized;

  public STO(String type) {
    this.type = type;
    this.initialized = false;
    this.constant = false;
  }

  public STO(String type, int value) {
    this.type = type;
    this.value = value;
    this.initialized = false;
    this.constant = false;
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

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public void initialize() {
    this.initialized = true;
  }

  public void setConstant(boolean constant) {
    this.constant = constant;
  }

  public boolean getConstant() {
    return this.constant;
  } 

  public boolean isInitialized() {
    return this.initialized;
  }
}