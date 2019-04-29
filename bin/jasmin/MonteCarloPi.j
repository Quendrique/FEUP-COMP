.class public MonteCarloPi
.super java/lang/Object


.method public static performSingleEstimate()Z
  .limit stack 20
  .limit locals 4
  invokestatic MathUtils/random()V
  istore_1
  invokestatic MathUtils/random()V
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
  ireturn
.end method



.method public static estimatePi100(I)I
  .limit stack 20
  .limit locals 3
  iconst_0
  istore 3
  iconst_0
  istore_2
  sipush 400
  iload_2
  imul
  iload_1
  idiv
  istore 4
  ireturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 20
  .limit locals 2
  invokestatic ioPlus/requestNumber()V
  istore_2
  istore_1
  iload_1
  invokestatic ioPlus/printResult(I)V
  return
.end method


