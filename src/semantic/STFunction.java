package semantic;

import java.util.ArrayList;
import java.util.HashMap;
import parser.*;

public class STFunction extends Object {

  STO returnDescriptor;  
  HashMap<String, STO> params;
  HashMap<String, STO> locals;

  public STFunction() {
    this.returnDescriptor = null;
    this.params = new HashMap<String, STO>();
    this.locals = new HashMap<String, STO>();
  }

  public STO getReturn() {
    return this.returnDescriptor;
  }

  public HashMap<String, STO> getParams() {
    return this.params;
  }

  public HashMap<String, STO> getLocals() {
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

  public void setReturn(STO returnSymbol) {
    this.returnDescriptor = returnSymbol;
  }

  public boolean doesSymbolExist(String identifier, String type) {
    STO doesVariableExist;
    if (((doesVariableExist = this.params.get(identifier)) != null || (doesVariableExist = this.locals.get(identifier)) != null)
    && doesVariableExist.type == type) {
      if (!doesVariableExist.checked) {
        doesVariableExist.checked = true;
        return false;
      } else {
        return true;
      }
    }
    return (((doesVariableExist = this.params.get(identifier)) != null || (doesVariableExist = this.locals.get(identifier)) != null)
    && doesVariableExist.type == type);
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