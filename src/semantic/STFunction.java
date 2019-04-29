package semantic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import parser.*;

public class STFunction extends Object {

  STO returnDescriptor;  
  LinkedHashMap<String, STO> params; // TODO params and locals can have similar identifiers, fix this
  LinkedHashMap<String, STO> locals;
  int index;
  int numLocals;
  //add indices

  public STFunction() {
    this.returnDescriptor = null;
    this.params = new LinkedHashMap<String, STO>();
    this.locals = new LinkedHashMap<String, STO>();
    this.index = 1;
    this.numLocals = 0;
  }

  public STO getReturn() {
    return this.returnDescriptor;
  }

  public int getIndex() {
    return this.index;
  }

  public int getNumLocals() {
    return this.numLocals;
  } 

  public LinkedHashMap<String, STO> getParams() {
    return this.params;
  }

  public LinkedHashMap<String, STO> getLocals() {
    return this.locals;
  }

  public void addSymbol(String identifier, STO symbol, boolean isParam) {
    if (isParam) {
      if (this.params.get(identifier) == null) {
        symbol.index = this.index;
        this.params.put(identifier, symbol);
      } else {
        System.out.println("Variable " + identifier + " already declared");
      }
    } else {
      if (this.locals.get(identifier) == null) {
        symbol.index = this.index;
        this.numLocals++;
        this.locals.put(identifier, symbol);
      } else {
        System.out.println("Variable " + identifier + " already declared");
      }
    }
    this.index++;
  }

  public STO doesSymbolExist(String identifier) {
    STO returnSymbol;
    return ((returnSymbol = this.locals.get(identifier)) != null ? returnSymbol : this.params.get(identifier)); 
  }

  public void setReturn(STO returnSymbol) {
    this.returnDescriptor = returnSymbol;
  }

  public void dump() {
    System.out.println("  Return descriptor: " + (returnDescriptor == null ? "" : returnDescriptor.toString()));
    System.out.println("  Parameters:");
    params.forEach((key, value) -> {
      System.out.println("    " + value.toString() + " " + key + " (index " + value.getIndex() + ")");
    });
    System.out.println("  Locals:");
    locals.forEach((key, value) -> {
      System.out.println("    " + value.toString() + " " + key + " (index " + value.getIndex() + ")");
    });
  }
}