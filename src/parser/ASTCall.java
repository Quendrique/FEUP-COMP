/* Generated By:JJTree: Do not edit this line. ASTCall.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

import semantic.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

public
class ASTCall extends SimpleNode {

  protected String value;

  public ASTCall(int id) {
    super(id);
  }

  public ASTCall(Jmm p, int id) {
    super(p, id);
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String getSymbolReturn() {
    return this.symbolTable.doesFunctionExist(this.value).getReturn().getType();
  }

  @Override
  public void checkNodeSemantic() {

    //System.out.println("checking if function " + this.value + " exists in function table");
    STFunction functionCalled = this.symbolTable.doesFunctionExist(this.value);
    if (functionCalled != null) {
      this.returnType = functionCalled.getReturn().getType();
    } else {
      this.returnType = "null"; //function external to the class
    }

    if (this.children != null) {
      if (functionCalled != null) {
        //System.out.println("call class function");
        checkForCorrectArgs(functionCalled);
      }
    }
  }

  public void checkForCorrectArgs(STFunction functionCalled) {
    LinkedHashMap<String, STO> paramsNeeded = functionCalled.getParams();
    Node[] args = ((SimpleNode) this.children[0]).children;
    int numArguments;
    if (args == null) {
      numArguments = 0;
    } else {
      numArguments = ((SimpleNode) this.children[0]).children.length;
    }
    if (paramsNeeded.size() != numArguments) {
      super.printSemanticError("No function signature for identifier " + this.value + " and specified number of arguments found");
      return;
    }

    Iterator<Map.Entry<String, STO>> it = paramsNeeded.entrySet().iterator();
    int count = 0;
    STO argument, parameter;
    String argIdentifier;
    
    while (it.hasNext() && count < ((SimpleNode) this.children[0]).children.length) {
      //System.out.println(((SimpleNode) this.children[0]).children.length);
      Map.Entry<String, STO> symbol = it.next();
      if (!symbol.getValue().getType().equals(((SimpleNode) (((SimpleNode) this.children[0]).children[count])).returnType)) {
        super.printSemanticError("No function signature for identifier " + this.value + " and specified arguments found");
        return;
      }
      count++;
    }
    
  }


  public void dump(String prefix) {
    System.out.println(toString(prefix) + ": " + this.value);
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        SimpleNode n = (SimpleNode)children[i];
        if (n != null) {
          n.dump(prefix + "    ");
        }
      }
    }
  }

}
/* JavaCC - OriginalChecksum=b64b01ac41baa4ccb219eac917d0e841 (do not edit this line) */
