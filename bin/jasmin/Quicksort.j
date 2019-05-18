.class public Quicksort
.super java/lang/Object


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public static main([Ljava/lang/String;)V
  .limit stack 8
  .limit locals 4
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
  new Quicksort
  dup
  invokespecial Quicksort/<init>()V
  astore_3
  aload_3
  aload_1
  invokevirtual Quicksort/quicksort([I)Z
  aload_3
  aload_1
  invokevirtual Quicksort/printL([I)Z
  return
.end method



.method public printL([I)Z
  .limit stack 4
  .limit locals 3
  iconst_0
  istore_2
  WHILE_1:
  iload_2
  aload_1
  arraylength
  isub
  ifge LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq WHILE_NEXT_1
  aload_1
  iload_2
  iaload
  invokestatic io/println(I)V
  iload_2
  iconst_1
  iadd
  istore_2
  goto WHILE_1
  WHILE_NEXT_1:
  iconst_1
  ireturn
.end method



.method public quicksort([I)Z
  .limit stack 5
  .limit locals 2
  aload_0
  aload_1
  iconst_0
  aload_1
  arraylength
  iconst_1
  isub
  invokevirtual this/quicksort([III)Z
  ireturn
.end method



.method public quicksort([III)Z
  .limit stack 6
  .limit locals 5
  iload_2
  iload_3
  isub
  ifge LT_ELSE_2
  iconst_1
  goto LT_NEXT_2
  LT_ELSE_2:
  iconst_0
  LT_NEXT_2:
  ifeq ELSE_0
  aload_0
  aload_1
  iload_2
  iload_3
  invokevirtual this/partition([III)I
  istore 4
  goto NEXT_0
  ELSE_0:
  NEXT_0:
  iconst_1
  ireturn
.end method



.method public partition([III)I
  .limit stack 8
  .limit locals 8
  aload_1
  iload_3
  iaload
  istore 4
  iload_2
  istore 5
  iload_2
  istore 6
  WHILE_2:
  iload 6
  iload_3
  isub
  ifge LT_ELSE_3
  iconst_1
  goto LT_NEXT_3
  LT_ELSE_3:
  iconst_0
  LT_NEXT_3:
  ifeq WHILE_NEXT_2
  aload_1
  iload 6
  iaload
  iload 4
  isub
  ifge LT_ELSE_4
  iconst_1
  goto LT_NEXT_4
  LT_ELSE_4:
  iconst_0
  LT_NEXT_4:
  ifeq ELSE_1
  aload_1
  iload 5
  iaload
  istore 7
  aload_1
  iload 5
  aload_1
  iload 6
  iaload
  iastore
  aload_1
  iload 6
  iload 7
  iastore
  iload 5
  iconst_1
  iadd
  istore 5
  goto NEXT_1
  ELSE_1:
  NEXT_1:
  iload 6
  iconst_1
  iadd
  istore 6
  goto WHILE_2
  WHILE_NEXT_2:
  aload_1
  iload 5
  iaload
  istore 7
  aload_1
  iload 5
  aload_1
  iload_3
  iaload
  iastore
  aload_1
  iload_3
  iload 7
  iastore
  iload 5
  ireturn
.end method


