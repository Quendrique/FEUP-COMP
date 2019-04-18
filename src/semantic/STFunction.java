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