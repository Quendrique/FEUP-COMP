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

  }

  public void genClass(String className) {
    this.out.println(".class public" + className + "\n ..super java/lang/Object\n");
  }

  public void genGlobal() {

  }

  public void genMethod() {

  }

  public void genMethodHeader() {

  }

  public void genMethodBody() {

  }

  public void genMethodFooter() {

  }

}