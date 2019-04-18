package semantic;

import parser.*;

public class STO extends Object {

  String type;  
  String value;

  public STO(String type) {
    this.type = type;
    this.value = null;
  }

  public STO(String type, String value) {
    this.type = type;
    this.value = value;
  }

  public String toString() {
    return this.type;
  }
}