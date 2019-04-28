package semantic;

import parser.*;

public class STO extends Object {

  String type;  
  String value;
  int index;

  public STO(String type) {
    this.type = type;
    this.value = null;
  }

  public STO(String type, String value) {
    this.type = type;
    this.value = value;
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
}