.class public MonteCarloPi
.super java/lang/Object


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public performSingleEstimate()Z
  .limit stack 3
  .limit locals 5
  iconst_0
  bipush 100
  isub
  bipush 100
  invokestatic MathUtils/random(II)I
  istore_1
  iconst_0
  bipush 100
  isub
  bipush 100
  invokestatic MathUtils/random(II)I
  istore_2
  iload_1
  iload_1
  imul
  iload_2
  iload_2
  imul
  iadd
  bipush 100
  idiv
  istore 4
  iload 4
  bipush 100
  isub
  ifge LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifeq ELSE_0
  iconst_1
  istore_3
  goto NEXT_0
  ELSE_0:
  iconst_0
  istore_3
  NEXT_0:
  iload_3
  ireturn
.end method



.method public estimatePi100(I)I
  .limit stack 5
  .limit locals 5
  iconst_0
  istore_3
  iconst_0
  istore_2
  WHILE_0:
  iload_3
  iload_1
  isub
  ifge LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq WHILE_NEXT_0
  aload_0
  invokevirtual MonteCarloPi/performSingleEstimate()Z
  ifeq ELSE_1
  iload_2
  iconst_1
  iadd
  istore_2
  goto NEXT_1
  ELSE_1:
  NEXT_1:
  iload_3
  iconst_1
  iadd
  istore_3
  goto WHILE_0
  WHILE_NEXT_0:
  sipush 400
  iload_2
  imul
  iload_1
  idiv
  istore 4
  iload 4
  ireturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 3
  .limit locals 3
  invokestatic ioPlus/requestNumber()I
  istore_2
  new MonteCarloPi
  dup
  invokespecial MonteCarloPi/<init>()V
  iload_2
  invokevirtual MonteCarloPi/estimatePi100(I)I
  istore_1
  iload_1
  invokestatic ioPlus/printResult(I)V
  return
.end method


