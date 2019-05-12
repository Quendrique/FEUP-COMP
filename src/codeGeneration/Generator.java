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
    
    genInitializer();
    genMethods();

    out.println(builder);
    out.close();
  }

  public void genClass(String className) {
    appendLine(".class public " + className + "\n.super java/lang/Object");
  }

  public void genInitializer() {
    appendLine(".method public <init>()V");
    appendLine("  aload_0");
    appendLine("  invokespecial java/lang/Object/<init>()V");
    appendLine("  return");
    appendLine(".end method");
  }

  public void genGlobals() {
    for (int i = 0; i < root.jjtGetNumChildren(); i++) {
			SimpleNode childRoot = (SimpleNode) root.jjtGetChild(i);

			if (childRoot.getId() == JmmTreeConstants.JJTVARDECLARATION)
        genVarGlobal((ASTVarDeclaration) childRoot);
    }
    appendLine("\n");
  }

  public void genVarGlobal(ASTVarDeclaration dec){
    String varName, varType = "";
    
    varName = dec.getIdentifier();
    varType = parseReturnType(dec.getType());
		
		appendLine(".field static " + varName + " " + varType);
    
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
    genMethodFooter(method);
    
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
      
      appendLine(".method public " + identifier + "(" + funcArgs + ")" + VDMTypeConverter(type));
      
    }
    
  }

  public void genMethodCall(SimpleNode call, String variableType) {

    String paramTypes = "";
    if (call.jjtGetNumChildren() > 0 && ((SimpleNode) call.jjtGetChild(0)).getId() == JmmTreeConstants.JJTARGS) {
      SimpleNode args = (SimpleNode) call.jjtGetChild(0);
      //get function scope and corresponding stfunction object
      //go through params in the function and add them to the invocation
      SimpleNode child;
      for(int i = 0; i < args.jjtGetNumChildren(); i++) {
        child = (SimpleNode) args.jjtGetChild(0);
        genExpression(child);
        paramTypes += parseReturnType(((ASTIdentifier) child).getReturnType());
      }
    }

    String methodName = ((ASTCall) call).getValue();
    STFunction function = SimpleNode.getSymbolTable().doesFunctionExist(methodName);
    String returnType = "";
    if (function != null) {
      returnType = parseReturnType(function.getReturn().getType());
    } else {
      returnType = "V";
    }

    appendLine("  invokevirtual " + variableType + "/" + methodName + "(" + paramTypes + ")" + returnType);

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
      SimpleNode child;
      for(int i = 0; i < nSts; i++) {
        child = (SimpleNode) method.jjtGetChild(i);
        genStatement(child);
      }
    }
  }

  public void genStatement(SimpleNode node) {
    switch (node.getId()) {
      case JmmTreeConstants.JJTVARDECLARATION: 
        break;
      case JmmTreeConstants.JJTASSIGN:
        genAssign(node);
        break;
      case JmmTreeConstants.JJTARRAYASSIGN:
        genArrayAssign(node);
        break;
      case JmmTreeConstants.JJTIF:
        genIf(node);
        break;
      case JmmTreeConstants.JJTWHILE:
        genWhile(node);
        break;
      default:
        genExpression(node);
        break;
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
      case JmmTreeConstants.JJTIDENTIFIER:
        genIdentifierLoad(node);
        break;
      case JmmTreeConstants.JJTNEW:
        genNew(node);
        break;
      case JmmTreeConstants.JJTBOOLEANLITERAL:
        genBooleanLiteral(node);
        break;
      case JmmTreeConstants.JJTINTEGERLITERAL:
        genIntegerLiteral(node);
        break;
      case JmmTreeConstants.JJTNOT:
        genNot(node);
        break;
      case JmmTreeConstants.JJTTHIS:
        genThis(node); 
        break;
      case JmmTreeConstants.JJTNESTEDEXP:
        genNestedExp(node); 
        break;
      default: // todo
        break;
    }
  }

  public void genLogicOp(SimpleNode node) {
    String op = "";
    switch(node.getId()) {
      case JmmTreeConstants.JJTAND:
        op = "&&";
        break;
      case JmmTreeConstants.JJTLESSTHAN:
        op = "<";
    }

    SimpleNode lhs = (SimpleNode) node.jjtGetChild(0), rhs = (SimpleNode) node.jjtGetChild(1);
    genExpression(lhs);
    genExpression(rhs);

    switch(op) {
      case "&&":
        appendLine("  iand");
        break;
      case "<":
        appendLine("  isub"); 
        appendLine("  iflt LT_ELSE_" + ((ASTLessThan) node).getLabelId());
        appendLine("  iconst_1");
        appendLine("  goto LT_NEXT_" + ((ASTLessThan) node).getLabelId());
        appendLine("  LT_ELSE_" + ((ASTLessThan) node).getLabelId() + ":");
        appendLine("  iconst_0");
        appendLine("  LT_NEXT_" + ((ASTLessThan) node).getLabelId() + ":");
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

    SimpleNode lhs = (SimpleNode) node.jjtGetChild(0), rhs = (SimpleNode) node.jjtGetChild(1);
    genExpression(lhs);
    genExpression(rhs);

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

  public void genAssign(SimpleNode node){
    
    STO lhs = SimpleNode.getSymbolTable().doesSymbolExist(((ASTAssign) node).getLhs(), node.getScope());

    SimpleNode rhs = (SimpleNode) node.jjtGetChild(0);
    genExpression(rhs);

    if (lhs != null) {
      String type = lhs.getType();
      int index = lhs.getIndex();
      switch(type) {
        case "int":
          appendLine("  istore" + ((lhs.getIndex() <= 3) ? "_" : " ") + lhs.getIndex());
          break;
        case "int[]":
          appendLine("  astore" + ((lhs.getIndex() <= 3) ? "_" : " ") + lhs.getIndex());
          break;
        case "boolean":
          appendLine("  istore" + ((lhs.getIndex() <= 3) ? "_" : " ") + lhs.getIndex());
          break;
        default:
          appendLine("  astore" + ((lhs.getIndex() <= 3) ? "_" : " ") + lhs.getIndex());
      }
    } else {
      lhs = SimpleNode.getSymbolTable().doesGlobalExist(((ASTAssign) node).getLhs());
      if (lhs != null) {
        int index = lhs.getIndex();
        appendLine("  putstatic " + SimpleNode.getClassName() + "/" + ((ASTAssign) node).getLhs() + " " + parseReturnType(lhs.getType())); 
      }
    }

  }

  public void genArrayAssign(SimpleNode node){

    STO lhs = SimpleNode.getSymbolTable().doesSymbolExist(((ASTArrayAssign) node).getIdentifier(), node.getScope());
    
    if (lhs != null) {
      appendLine("  aload" + ((lhs.getIndex() <= 3) ? "_" : " ") + lhs.getIndex());
    } else if ((lhs = SimpleNode.getSymbolTable().doesGlobalExist(((ASTArrayAssign) node).getIdentifier())) != null) {
      appendLine("  getstatic " + SimpleNode.getClassName() + "/" + ((ASTArrayAssign) node).getIdentifier() + " " + parseReturnType(lhs.getType()));
    }

    // array index
    genExpression((SimpleNode) ((SimpleNode) node.jjtGetChild(0)).jjtGetChild(0));
    
    // rhs expression
    SimpleNode rhs = (SimpleNode) node.jjtGetChild(1);
    genExpression(rhs);

    if (lhs != null) {
      appendLine("  iastore");
    }

  }

  public void genNew(SimpleNode node) {
    if (node.jjtGetNumChildren() > 0) { // new array
      genExpression((SimpleNode) node.jjtGetChild(0));
      appendLine("  newarray int");
    } else {
      appendLine("  new " + ((ASTNew) node).getActualReturnType());
      appendLine("  dup");
      appendLine("  invokespecial " + ((ASTNew) node).getActualReturnType() + "/<init>()V");
    }
  }

  public void genMethodFooter(SimpleNode method){

    STFunction function;
    if (method.getId() == JmmTreeConstants.JJTMAINDECLARATION) {
      function = SimpleNode.getSymbolTable().doesFunctionExist("main");
    } else {
      function = SimpleNode.getSymbolTable().doesFunctionExist(((ASTMethodDeclaration) method).getName());
    }

    SimpleNode returnNode = (SimpleNode) method.jjtGetChild(method.jjtGetNumChildren()-1);
    if (returnNode.getId() == JmmTreeConstants.JJTRETURN) {
      genExpression(((SimpleNode) returnNode.jjtGetChild(0)));
    }

    String returnType = "void";
    if (function != null) {
      returnType = function.getReturn().getType();
    }
    switch(returnType) {
      case "int":
        appendLine("  ireturn");
        break;
      case "int[]":
        appendLine("  areturn"); //??
        break;
      case "boolean":
        appendLine("  ireturn"); //??
        break;
      case "void":
        appendLine("  return");
        break;
      default:
        appendLine("  areturn");

    }
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

  public void genIntegerLiteral (SimpleNode node) {
    int value = ((ASTIntegerLiteral) node).getValue();
    if (value <= 5)
      appendLine("  iconst_" + value);
    else if(value <= 127)
      appendLine("  bipush " + value);
    else if(value <= 32767)
      appendLine("  sipush " + value);
    else
      appendLine("  ldc " + value);
  }

  public void genBooleanLiteral (SimpleNode node) {
    String value = ((ASTBooleanLiteral) node).getBooleanValue();
    if (value.equals("true")) {
      appendLine("  iconst_1");
    } else {
      appendLine("  iconst_0");
    }
  }

  public void genIdentifierLoad (SimpleNode node) {

    STO variable = SimpleNode.getSymbolTable().doesSymbolExist(((ASTIdentifier) node).getIdentifier(), node.getScope());
    if (variable != null) {
      System.out.println(((ASTIdentifier) node).getIdentifier());
      switch(variable.getType()) {
        case "int":
        appendLine("  iload" + ((variable.getIndex() <= 3) ? "_" : " ") + variable.getIndex());
        break;
        case "int[]":
        appendLine("  aload" + ((variable.getIndex() <= 3) ? "_" : " ") + variable.getIndex());
        break;
        case "boolean":
        appendLine("  iload" + ((variable.getIndex() <= 3) ? "_" : " ") + variable.getIndex());
        break;
        default:
      }
    } else { 
      variable = SimpleNode.getSymbolTable().doesGlobalExist(((ASTIdentifier) node).getIdentifier());
      if (variable != null) {
        appendLine("  getstatic " + SimpleNode.getClassName() + "/" + ((ASTIdentifier) node).getIdentifier() + " " + parseReturnType(variable.getType()));
      }
    }

    if (node.jjtGetNumChildren() > 0) {
      SimpleNode child = ((SimpleNode) node.jjtGetChild(0));
      switch(child.getId()) {
        case JmmTreeConstants.JJTARRAYINDEX:
          genExpression((SimpleNode) ((SimpleNode) node).jjtGetChild(0).jjtGetChild(0));
          appendLine("  iaload");
          break;
        case JmmTreeConstants.JJTCALL:
          genMethodCall((SimpleNode) node.jjtGetChild(0), node.getActualReturnType());
          break;
        case JmmTreeConstants.JJTLENGTH:
          genLength(node);
      }
    }
    
    /**
     * aload_0
        aload_0
        getfield foo/y I
        aload_0
        getfield foo/z I
        iadd 
        putfield foo/x
     */
  }

  public void genLength(SimpleNode node) {
    appendLine("  arraylength");
  }

  public void genNot(SimpleNode node) {
    genExpression((SimpleNode) node.jjtGetChild(0));
    appendLine("  iconst_1");
    appendLine("  ixor");
  }

  public void genThis(SimpleNode node) {
    appendLine("  aload_0");
  }

  public void genNestedExp(SimpleNode node) {
    genExpression((SimpleNode) node.jjtGetChild(0));
    switch(((SimpleNode) node.jjtGetChild(1)).getId()) {
      case JmmTreeConstants.JJTCALL:
        genMethodCall((SimpleNode) node.jjtGetChild(1), ((SimpleNode) node.jjtGetChild(0)).getReturnType());
        break;
      case JmmTreeConstants.JJTLENGTH:
        genLength((SimpleNode) node.jjtGetChild(1));
        break;
      case JmmTreeConstants.JJTARRAYINDEX:
        genExpression(((SimpleNode) ((SimpleNode) node.jjtGetChild(1)).jjtGetChild(0)));
    }
  }
  
  public void genIf(SimpleNode node) {
    SimpleNode condition = (SimpleNode) ((SimpleNode) node.jjtGetChild(0)).jjtGetChild(0);
    SimpleNode thenStatement = ((SimpleNode) node.jjtGetChild(1));
    SimpleNode elseStatement = null;
    
    if (((SimpleNode) node.jjtGetChild(0)).jjtGetNumChildren() > 0) {
      elseStatement = ((SimpleNode) node.jjtGetChild(2));
    }
    genExpression(condition);
    System.out.println(condition.getId());
    appendLine("  ifne ELSE_"+((ASTIf) node).getLabelId()); 
    SimpleNode child;
    for(int i = 0; i < thenStatement.jjtGetNumChildren(); i++) {
      child = (SimpleNode) thenStatement.jjtGetChild(i);
      genStatement(child);
    }
    appendLine("  goto NEXT_"+((ASTIf) node).getLabelId());
    appendLine("  ELSE_" + +((ASTIf) node).getLabelId() +":");
    if (elseStatement != null) {
      for(int i = 0; i < elseStatement.jjtGetNumChildren(); i++) {
        child = (SimpleNode) elseStatement.jjtGetChild(i);
        genStatement(child);
      }
    }
    appendLine("  NEXT_" + ((ASTIf) node).getLabelId() + ":");
  }

  public void genWhile(SimpleNode node) {
    SimpleNode condition = (SimpleNode) node.jjtGetChild(0);

    appendLine("  WHILE_" + ((ASTWhile) node).getLabelId() + ":");
    genExpression(condition);
    appendLine("  ifeq WHILE_NEXT_" + ((ASTWhile) node).getLabelId()); 
    for(int i = 1; i < node.jjtGetNumChildren(); i++) {
      genStatement((SimpleNode) node.jjtGetChild(i));
    }
    appendLine("  goto WHILE_" + ((ASTWhile) node).getLabelId());
    appendLine("  WHILE_NEXT_" + ((ASTWhile) node).getLabelId() + ":");
  }

  public String parseReturnType(String returnType) {
    switch(returnType) {
      case "int":
        return "I";
      case "int[]":
        return "[I";
      case "boolean":
        return "Z";
      default:
        return "L" + returnType + ";";
    }
  }

  public SimpleNode getRoot(){
    return this.root;
  }


}