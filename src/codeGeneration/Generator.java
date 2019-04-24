package codeGeneration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import parser.*;

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

  public void generate() {
    System.out.println("File Name: " + this.root.getName());
    genClass(this.root.getName());
    genGlobals();

    out.println(builder);
    out.close();
  }

  private void appendLine(String line) {
		builder.append(line + "\n");
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

    System.out.println("Type: " + dec.getType());

    

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



  public void genMethod(SimpleNode method) {

    genMethodSignature(method);
    genMethodBody();
    this.out.println(".end method\n");

  }
  
  public void genMethodSignature(SimpleNode method) {
    /*
    
    String identifier, type;
    if (method instanceof ASTMainDeclaration) {
      type = "static void"; identifier = "main";
    } else if (method instanceof ASTMethodDeclaration) {
      type = ((ASTethodDeclaration) method).getType(); identifier = ((ASTMainDeclaration) method).getName();
    }

    this.out.print(".method public " + (identifier.equals("main") ? "static " : "") + identifier);
    if (method.jjtGetChild(0) instanceof ASTMethodArguments) {
      genMethodArguments(method.jjtGetChild(0));
    }
    String returnType;
    switch(type) {
      case "int":
        returnType = "I";
        break;
      case "int[]":
        returnType = "[I";
        break;
      case "void":
        returnType = "V";
        break;
      default:
      //boolean -> Z 
      // ?? dont know how to deal with other types
      // identifier -> L[path];
    }
    this.out.println(returnType);
    */
    
  }

  public void genMethodArguments(SimpleNode args) {
    //for(int i = 0; i < args.jjtGetNumChildren(); i++) {
      // ?? :) 
    //}
    //this.out.print(")");
  }

  public void genMethodBody() {

  }


  public SimpleNode getRoot(){
    return this.root;
  }


}