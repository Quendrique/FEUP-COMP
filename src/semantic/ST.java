package semantic;

import java.util.HashMap;
import parser.*;

public class ST extends Object {

  HashMap<String, STFunction> functionTable;
  SimpleNode AST;

  public ST() {
    this.functionTable = new HashMap<String, STFunction>();
  }

  public void addFunction(String identifier, STFunction function) {
    this.functionTable.put(identifier, function);
  }

  public void addSymbolToFunction(String symbolIdentifier, STO symbol, String functionIdentifier, boolean isParam) {
    this.functionTable.get(functionIdentifier).addSymbol(symbolIdentifier, symbol, isParam);
  }

  public void dump() {

    System.out.println("\n** SYMBOL TABLE **\n");
    
    functionTable.forEach((key, value) -> {
      System.out.println("Function " + key + ":");
      value.dump();
    });
  }
 
}