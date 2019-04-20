package semantic;

import java.util.HashMap;
import parser.*;

public class ST extends Object {

  HashMap<String, STFunction> functionTable;

  public ST() {
    this.functionTable = new HashMap<String, STFunction>();
  }

  public HashMap<String, STFunction> getFunctionTable() {
    return this.functionTable;
  }

  public void addFunction(String identifier, STFunction function) {
    this.functionTable.put(identifier, function);
  }

  public void addSymbolToFunction(String symbolIdentifier, STO symbol, String functionIdentifier, boolean isParam) {
    this.functionTable.get(functionIdentifier).addSymbol(symbolIdentifier, symbol, isParam);
  }

  public STO doesSymbolExist(String identifier, String scope) {
    STO returnSymbol;
    return ((returnSymbol = functionTable.get(scope).doesSymbolExist(identifier)) != null) ? returnSymbol : functionTable.get("global").doesSymbolExist(identifier);
  }

  public STFunction doesFunctionExist(String identifier) {
    return this.functionTable.get(identifier);
  }

  public void dump() {

    System.out.println("\n** SYMBOL TABLE **\n");
    
    functionTable.forEach((key, value) -> {
      System.out.println("Function " + key + ":");
      value.dump();
    });
  }
 
}