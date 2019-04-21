package codeGeneration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import parser.*;

public class Generator {

  private PrintWriter out;

  public Generator() {

    try {

      File dir = new File("jasmin");
      if (!dir.exists()) {
        dir.mkdirs();
      }

      File file = new File("jasmin/Test.j"); //TEMP
      if (!file.exists()) {
        file.createNewFile();
      }

      this.out = new PrintWriter(file);

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

  }

  public void generate(SimpleNode root) {
    
    SimpleNode classNode = (SimpleNode) root.jjtGetChild(0);
    genClass(((ASTClassDeclaration) classNode).getName());
    this.out.close();
  }

  public void genClass(String className) {
    this.out.print(".class public" + className + "\n ..super java/lang/Object\n");
    this.out.flush();
  }

  public void genGlobal() {

  }

  public void genMethod(SimpleNode method) {

    genMethodSignature(method);
    genMethodBody();
    this.out.println(".end method\n");

  }
  
  public void genMethodSignature(SimpleNode method) {
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
      // ?? dont know how to deal with other types
    }
    this.out.println(returnType);
  }

  public void genMethodArguments(SimpleNode args) {
    for(int i = 0; i < args.jjtGetNumChildren(); i++) {
      // ?? :) 
    }
    this.out.print(")");
  }

  public void genMethodBody() {

  }

}