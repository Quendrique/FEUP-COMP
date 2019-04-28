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
  

  //Generator Functions

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
        genVarDeclaration((ASTVarDeclaration) childRoot);
		}
  }

  public void genVarDeclaration(ASTVarDeclaration dec){
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

    //invokevirtual (class name).(method name)(args all together)(return type)

  }

  public void genVarDeclarations(ASTVarDeclaration var) {
    String identifier, type, value = "";
    
  }


  public void genMethodBody(SimpleNode method) {
    appendLine(".limit stack 20"); //TODO
    String methodName = "";
    if (method instanceof ASTMethodDeclaration) {
      methodName = ((ASTMethodDeclaration) method).getName();
    } else {
      methodName = "main";
    }

    STFunction function = SimpleNode.getSymbolTable().doesFunctionExist(methodName);
    appendLine(".limit locals " + function.getNumLocals());
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