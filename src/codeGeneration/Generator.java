package codeGeneration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import parser.*;
import semantic.*;

public class Generator {

  private ASTClassDeclaration root;

  private StringBuilder builder;
  private PrintWriter out;

  public Generator(SimpleNode root) throws IOException {

    this.root = (ASTClassDeclaration) root.jjtGetChild(0);

    String fileName = this.root.getName() + ".j";

    System.out.println("filename: " + fileName);

    try {

      File dir = new File("jasmin");
      if (!dir.exists()) {
        dir.mkdirs();
      }

      File file = new File("jasmin/" + fileName);
      if (!file.exists()) {
        file.createNewFile();
      }

      this.out = new PrintWriter(file);

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

    this.builder = new StringBuilder();

    FileWriter fw = new FileWriter("jasmin/" + fileName);
    
    this.out = new PrintWriter(fw);

  }

  

  private void appendLine(String line) {
		builder.append(line + "\n");
  }

  public void generate() {
    genClass(this.root.getName());
    genGlobals();

    genMethods();

    out.println(builder);
    out.close();
  }

  public void genClass(String className) {
    appendLine(".class public " + className + "\n.super java/lang/Object");
  }

  public void genGlobals() {
    for (int i = 0; i < root.jjtGetNumChildren(); i++) {
			SimpleNode childRoot = (SimpleNode) root.jjtGetChild(i);

			if (childRoot.getId() == JmmTreeConstants.JJTVARDECLARATION)
        genVarGlobal((ASTVarDeclaration) childRoot);
		}
  }

  public void genVarGlobal(ASTVarDeclaration dec){
    String varName, varType = "";
    
    varName = dec.getIdentifier();

    if (dec.getType().equals("int[]"))
				varType = " [I ";
		else if (dec.getType().equals("int"))
      varType = " I ";
    else if (dec.getType().equals("boolean"))
			varType = " Z ";
		else{
      return;
    }
		
		appendLine(".field static " + varName + varType);
    
  }


  private void genMethods() {
		for (int i = 0; i < root.jjtGetNumChildren(); i++) {
			SimpleNode childRoot = (SimpleNode) root.jjtGetChild(i);

			if (childRoot.getId() == JmmTreeConstants.JJTMETHODDECLARATION || childRoot.getId() == JmmTreeConstants.JJTMAINDECLARATION)
        genMethod(childRoot);
		}
	}


  public void genMethod(SimpleNode method) {
    genMethodSignature(method);
    genMethodBody(method);
    genMethodFooter();
    
  }
  
  public void genMethodSignature(SimpleNode method) {

    String identifier, type, funcArgs = "";

    appendLine("\n");

    if (method instanceof ASTMainDeclaration) {
      appendLine(".method public static main([Ljava/lang/String;)V");
    }
		else if (method instanceof ASTMethodDeclaration) {
      ASTMethodDeclaration methodDec = (ASTMethodDeclaration) method;
      type = methodDec.getType(); identifier = methodDec.getName();

      if (methodDec.jjtGetNumChildren() > 0 && methodDec.jjtGetChild(0) instanceof ASTMethodArguments) {
        for (int i = 0; i < ((SimpleNode) methodDec.jjtGetChild(0)).jjtGetNumChildren(); i++) {
          ASTMethodArgument argNode = (ASTMethodArgument) ((SimpleNode) methodDec.jjtGetChild(0)).jjtGetChild(i);
          funcArgs += VDMTypeConverter(argNode.getType());
        }

      }
      
      appendLine(".method public static " + identifier + "(" + funcArgs + ")" + VDMTypeConverter(type));
      
    }
    
  }

  public void genMethodCall(SimpleNode call) {

    if (call.jjtGetNumChildren() > 0) {
      SimpleNode args = (SimpleNode) call.jjtGetChild(0);
      //get function scope and corresponding stfunction object
      //go through params in the function and add them to the invocation
  
      SimpleNode child;
      for(int i = 0; i < args.jjtGetNumChildren(); i++) {
        child = (SimpleNode) args.jjtGetChild(0);
        
      }
    }

    /*
    iload_1
    iload 3
    invokevirtual (class name).(method name)(args all together)(return type)
    */

  }

  public void genVarDeclaration(ASTVarDeclaration var) {
    STO variable = SimpleNode.getSymbolTable().doesSymbolExist(var.getIdentifier(), var.getScope());
    switch(variable.getType()) {
      case "int":
        appendLine("  istore" + ((variable.getIndex() < 3) ? "_" : " ") + variable.getIndex());
        break;
      case "int[]":
        //TODO
        break;
      case "boolean":
        //TODO
        break;
      default:
        //TODO
    }
  }
  
  public void genMethodBody(SimpleNode method) {

    System.out.println(" Gen Body: " + JmmTreeConstants.jjtNodeName[method.getId()]);

    appendLine("  .limit stack 20"); //TODO
    String methodName = "";
    if (method instanceof ASTMethodDeclaration) {
      methodName = ((ASTMethodDeclaration) method).getName();
    } else {
      methodName = "main";
    }

    STFunction function = SimpleNode.getSymbolTable().doesFunctionExist(methodName);
    appendLine("  .limit locals " + function.getNumLocals());

    if(method.getId() != JmmTreeConstants.JJTMETHODDECLARATION && method.getId() != JmmTreeConstants.JJTMAINDECLARATION) return;
    if (method.jjtGetNumChildren() > 0) {

      int nSts = method.jjtGetNumChildren();
      //get function scope and corresponding stfunction object
  
      SimpleNode child;
      
      for(int i = 0; i < nSts; i++) {
        child = (SimpleNode) method.jjtGetChild(i);

        switch (child.getId()) {
          case JmmTreeConstants.JJTVARDECLARATION:
            genVarDeclaration((ASTVarDeclaration) child);
            break;
          case JmmTreeConstants.JJTASSIGN:
            //generateAssign(functionChild);
            break;
          case JmmTreeConstants.JJTARRAYASSIGN:
            //generateArrayAssign(functionChild);
            break;
          case JmmTreeConstants.JJTIF:
            //generateArrayAssign(functionChild);
            break;
          case JmmTreeConstants.JJTWHILE:
            //generateArrayAssign(functionChild);
            break;
          default:
            genExpression(child);
            //System.out.println(child.getId());
            break;
          }
      }
    }
  }

  public void genExpression(SimpleNode node) {
    String expression = JmmTreeConstants.jjtNodeName[node.getId()];
    switch (node.getId()) {
      case JmmTreeConstants.JJTAND:
        genLogicOp(node);
        break;
      case JmmTreeConstants.JJTLESSTHAN:
        genLogicOp(node);
        break;
      case JmmTreeConstants.JJTADDSUB:
        genArithmeticOp(node);
        break;
      case JmmTreeConstants.JJTMULTDIV:
        genArithmeticOp(node);
        break;
      default: // TODO missing cases
        break;
    }
  }

  public void genLogicOp(SimpleNode node) {
    switch(node.getId()) {
      case JmmTreeConstants.JJTAND:
        break;
      case JmmTreeConstants.JJTLESSTHAN:
        break;
    }
     
  }

  public void genArithmeticOp(SimpleNode node) {
    String op = "";
    switch(node.getId()) {
      case JmmTreeConstants.JJTADDSUB:
        op = ((ASTAddSub) node).getOp();
        break;
      case JmmTreeConstants.JJTMULTDIV:
        op = ((ASTMultDiv) node).getOp();
        break;
    }

    // 1 + 1
    SimpleNode lhs = (SimpleNode) node.jjtGetChild(0), rhs = (SimpleNode) node.jjtGetChild(1);
    genArithmeticOpAux(lhs);
    genArithmeticOpAux(rhs);

    switch(op) {
      case "+":
        appendLine("  iadd");
        break;
      case "-":
        appendLine("  isub");
        break;
      case "/":
        appendLine("  idiv");
        break;
      case "*":
        appendLine("  imul");
    } 

  }

  public void genArithmeticOpAux(SimpleNode node) {

    switch(node.getId()) {
      case JmmTreeConstants.JJTINTEGERLITERAL: 
        int value = ((ASTIntegerLiteral) node).getValue();
        if (value <= 5)
          appendLine("  iconst_" + value);
        else if(value <= 127)
          appendLine("  bipush " + value);
        else if(value <= 32767)
          appendLine("  sipush " + value);
        else
          appendLine("  ldc " + value);
        break;
      case JmmTreeConstants.JJTIDENTIFIER: 
        STO variable = SimpleNode.getSymbolTable().doesSymbolExist(((ASTIdentifier) node).getIdentifier(), node.getScope());
        switch(variable.getType()) {
          case "int":
            appendLine("  iload" + ((variable.getIndex() < 3) ? "_" : " ") + variable.getIndex());
            break;
          case "int[]":
            //TODO
            break;
        }
      break;
    }


  }

  public void genAssign(SimpleNode node){
    //TODO
  }

  public void genArrayAssign(SimpleNode node){
    //TODO
  }

  public void genMethodFooter(){

    //TODO


    endMethod();
  }

  public void endMethod(){
    appendLine(".end method\n");
  }
  
  public String VDMTypeConverter(String type){
    String VDMType = "";

    switch(type){
      case "int":
        return "I";
      case "int[]":
        return "[I";
      case "boolean":
        return "Z";
      case "void":
        return "V";
      default: return "";
    }
  } 

  public SimpleNode getRoot(){
    return this.root;
  }


}