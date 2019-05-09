package semantic;

import java.util.HashMap;
import parser.*;

public class ST extends Object {

  HashMap<String, STFunction> functionTable;
  HashMap<String, STO> globalVariables;
  int numGlobalVariables;

  public ST() {
    this.functionTable = new HashMap<String, STFunction>();
    this.globalVariables = new HashMap<String, STO>();
    this.numGlobalVariables = 0;
  }

  public HashMap<String, STFunction> getFunctionTable() {
    return this.functionTable;
  }

  public HashMap<String, STO> getGlobalVariables() {
    return this.globalVariables;
  }

  public void addFunction(String identifier, STFunction function) {
    this.functionTable.put(identifier, function);
  }

  public void addSymbolToFunction(String symbolIdentifier, STO symbol, String functionIdentifier, boolean isParam) {
    this.functionTable.get(functionIdentifier).addSymbol(symbolIdentifier, symbol, isParam);
  }

  public void addGlobal(String identifier, STO symbol) {
    if (this.globalVariables.get(identifier) == null) {
      symbol.index = this.numGlobalVariables;
      this.numGlobalVariables++;
      this.globalVariables.put(identifier, symbol);
    } else {
      System.out.println("Semantic error: Variable " + identifier + " already declared."); //TODO
    }
  }

  public STO doesSymbolExist(String identifier, String scope) {
    STO returnSymbol;
    return ((returnSymbol = functionTable.get(scope).doesSymbolExist(identifier)) != null) ? returnSymbol : functionTable.get("global").doesSymbolExist(identifier);
  }

  public STO doesGlobalExist(String identifier) {
    return this.globalVariables.get(identifier);
  }

  public STFunction doesFunctionExist(String identifier) {
    return this.functionTable.get(identifier);
  }

  public void dump() {

    System.out.println("\n** SYMBOL TABLE **\n");

    System.out.println("Global variables:");

    globalVariables.forEach((key, value) ->{
      System.out.println(value.toString() + " " + key + " (index " + value.getIndex() + ")");
    });

    System.out.println("");
    
    functionTable.forEach((key, value) -> {
      System.out.println("Function " + key + ":");
      value.dump();
    });
  }
 
}