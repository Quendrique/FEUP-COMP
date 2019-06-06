.class public Lazysort
.super Quicksort


.method public <init>()V
  aload_0
  invokespecial Quicksort/<init>()V
  return
.end method


.method public static main([Ljava/lang/String;)V
  .limit stack 6
  .limit locals 6
  iconst_5
  istore 5
  iconst_5
  ldc 611111
  iadd
  istore_2
  bipush 10
  newarray int
  astore_1
  iconst_0
  istore_2
  WHILE_0:
  iload_2
  aload_1
  arraylength
  isub
  ifge LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifeq WHILE_NEXT_0
  aload_1
  iload_2
  aload_1
  arraylength
  iload_2
  isub
  iastore
  iload_2
  iconst_1
  iadd
  istore_2
  goto WHILE_0
  WHILE_NEXT_0:
  new Lazysort
  dup
  invokespecial Lazysort/<init>()V
  astore 4
  aload 4
  aload_1
  invokevirtual Quicksort/quicksort([I)Z
  pop
  aload 4
  aload_1
  invokevirtual Quicksort/printL([I)Z
  istore_3
  return
.end method



.method public quicksort([I)Z
  .limit stack 8
  .limit locals 3
  iconst_0
  iconst_5
  invokestatic MathUtils/random(II)I
  iconst_4
  isub
  ifge LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq ELSE_0
  aload_0
  aload_1
  invokevirtual Lazysort/beLazy([I)Z
  pop
  iconst_1
  istore_2
  goto NEXT_0
  ELSE_0:
  iconst_0
  istore_2
  NEXT_0:
  iload_2
  ifeq ELSE_1
  iload_2
  iconst_1
  ixor
  istore_2
  goto NEXT_1
  ELSE_1:
  aload_0
  aload_1
  iconst_0
  aload_1
  arraylength
  iconst_1
  isub
  invokevirtual Lazysort/quicksort([III)Z
  istore_2
  NEXT_1:
  iload_2
  ireturn
.end method



.method public beLazy([I)Z
  .limit stack 7
  .limit locals 4
  aload_1
  arraylength
  istore_2
  iconst_0
  istore_3
  WHILE_1:
  iload_3
  iload_2
  iconst_2
  idiv
  isub
  ifge LT_ELSE_2
  iconst_1
  goto LT_NEXT_2
  LT_ELSE_2:
  iconst_0
  LT_NEXT_2:
  ifeq WHILE_NEXT_1
  aload_1
  iload_3
  iconst_0
  bipush 10
  invokestatic MathUtils/random(II)I
  iastore
  iload_3
  iconst_1
  iadd
  istore_3
  goto WHILE_1
  WHILE_NEXT_1:
  iload_3
  iload_2
  isub
  ifge LT_ELSE_3
  iconst_1
  goto LT_NEXT_3
  LT_ELSE_3:
  iconst_0
  LT_NEXT_3:
  ifeq WHILE_NEXT_2
  WHILE_2:
  aload_1
  iload_3
  iconst_0
  bipush 10
  invokestatic MathUtils/random(II)I
  iconst_1
  iadd
  iastore
  iload_3
  iconst_1
  iadd
  istore_3
  iload_3
  iload_2
  isub
  ifge LT_ELSE_3
  iconst_1
  goto LT_NEXT_3
  LT_ELSE_3:
  iconst_0
  LT_NEXT_3:
  ifne WHILE_2
  WHILE_NEXT_2:
  iconst_1
  ireturn
.end method


