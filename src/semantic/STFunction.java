package semantic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import parser.*;

public class STFunction extends Object {

  STO returnDescriptor;  
  LinkedHashMap<String, STO> params;
  LinkedHashMap<String, STO> locals;
  //add indices

  public STFunction() {
    this.returnDescriptor = null;
    this.params = new LinkedHashMap<String, STO>();
    this.locals = new LinkedHashMap<String, STO>();
  }

  public STO getReturn() {
    return this.returnDescriptor;
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
        this.params.put(identifier, symbol);
      } else {
        System.out.println("Variable " + identifier + " already declared");
      }
    } else {
      if (this.locals.get(identifier) == null) {
        this.locals.put(identifier, symbol);
      } else {
        System.out.println("Variable " + identifier + " already declared");
      }
    }
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
      System.out.println("    " + value.toString() + " " + key);
    });
    System.out.println("  Locals:");
    locals.forEach((key, value) -> {
      System.out.println("    " + value.toString() + " " + key);
    });
  }
}