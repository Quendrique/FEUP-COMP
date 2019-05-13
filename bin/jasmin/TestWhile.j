.class public TestWhile
.super java/lang/Object


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public static main([Ljava/lang/String;)V
  .limit stack 20
  .limit locals 3
  iconst_0
  istore_2
  bipush 6
  newarray int
  astore_1
  iconst_0
  ifne AND_0
  iconst_0
  goto AND_NEXT_0
  AND_0:
  iconst_1
  iconst_1
  iand
  AND_NEXT_0:
  ifne ELSE_0
  iconst_0
  istore_2
  goto NEXT_0
  ELSE_0:
  iconst_0
  istore_2
  NEXT_0:
  WHILE_0:
  iload_2
  bipush 10
  isub
  ifgt LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifeq WHILE_NEXT_0
  iload_2
  iconst_1
  iadd
  istore_2
  goto WHILE_0
  WHILE_NEXT_0:
  return
.end method


