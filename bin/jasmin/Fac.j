.class public Fac
.super java/lang/Object


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public ComputeFac(I)I
  .limit stack 6
  .limit locals 3
  iload_1
  iconst_1
  isub
  ifge LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifeq ELSE_0
  iconst_1
  istore_2
  goto NEXT_0
  ELSE_0:
  iload_1
  aload_0
  iload_1
  iconst_1
  isub
  invokevirtual Fac/ComputeFac(I)I
  imul
  istore_2
  NEXT_0:
  iload_2
  ireturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 4
  .limit locals 1
  new Fac
  dup
  invokespecial Fac/<init>()V
  bipush 10
  invokevirtual Fac/ComputeFac(I)I
  invokestatic io/println(I)V
  return
.end method


