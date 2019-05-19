package semantic;

import java.util.ArrayList;
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

  public boolean addFunction(String identifier, STFunction function) {
    if (this.functionTable.get(identifier) == null) {
      this.functionTable.put(identifier, function);
      return true;
    } else {
      return false;
    }
  }

  public void addSymbolToFunction(String symbolIdentifier, STO symbol, String functionIdentifier, boolean isParam) {
    this.functionTable.get(functionIdentifier).addSymbol(symbolIdentifier, symbol, isParam);
  }

  public boolean addGlobal(String identifier, STO symbol) {
    if (this.globalVariables.get(identifier) == null) {
      symbol.index = this.numGlobalVariables;
      this.numGlobalVariables++;
      this.globalVariables.put(identifier, symbol);
      return true;
    } else {
      return false;
    }
  }

  public STO doesSymbolExist(String identifier, String scope) {
    return this.functionTable.get(scope).doesSymbolExist(identifier);
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