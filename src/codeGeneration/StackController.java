package codeGeneration;

import java.util.HashMap;

public class StackController {

  public static enum Instructions {
    ILOAD,
    ICONST,
    ALOAD,
    GETSTATIC,
    ISTORE,
    ASTORE,
    IALOAD,
    IASTORE,
    PUTSTATIC,
    BIPUSH,
    SIPUSH,
    LDC,
  }
  private static HashMap<Instructions, Integer> stackCosts;

  static {
    stackCosts = new HashMap<Instructions, Integer>();
    stackCosts.put(Instructions.ILOAD, 1);
    stackCosts.put(Instructions.ALOAD, 1);
    stackCosts.put(Instructions.ICONST, 1);
    stackCosts.put(Instructions.GETSTATIC, 1);
    stackCosts.put(Instructions.ISTORE, -1);
    stackCosts.put(Instructions.IASTORE, -3);
    stackCosts.put(Instructions.ASTORE, -1);
    stackCosts.put(Instructions.IALOAD, -1);
    stackCosts.put(Instructions.PUTSTATIC, -1);
    stackCosts.put(Instructions.BIPUSH, 1);
    stackCosts.put(Instructions.SIPUSH, 1);
    stackCosts.put(Instructions.LDC, 1);
  }

  private int maxStack;
  private int currentSize;

  public StackController() {
    this.maxStack = 0;
    this.currentSize = 0;
  }

  public void addInstruction(Instructions instruction) {
    this.currentSize += stackCosts.get(instruction);

    if(this.currentSize < 0) {
      this.currentSize = 0;
    }

    if(this.currentSize > this.maxStack) {
      this.maxStack = this.currentSize;
    }
  }

  public int getMaxStack() {
    return this.maxStack;
  }

}