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

  public void addSymbol(String identifier, STO symbol, boolean isParam) {
    if (isParam) {
      this.params.put(identifier, symbol);
    } else {
      this.locals.put(identifier, symbol);
    }
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