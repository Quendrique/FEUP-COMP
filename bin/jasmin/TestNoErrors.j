.class public TestNoErrors
.super java/lang/Object
.field static global_int I
.field static global_boolean Z
.field static global_array [I
.field static global_external LTest;
.field static global_internal LTestNoErrors;


.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public getArray()[I
  .limit stack 20
  .limit locals 2
  iconst_5
  newarray int
  astore_1
  aload_1
  areturn
.end method



.method public static main([Ljava/lang/String;)V
  .limit stack 20
  .limit locals 4
  iconst_0
  istore_2
  iconst_1
  istore_3
  iconst_2
  putstatic TestNoErrors/global_int I
  iconst_5
  newarray int
  putstatic TestNoErrors/global_array [I
  iload_2
  iconst_1
  iadd
  iload_2
  iload_2
  iadd
  iconst_1
  iconst_1
  iconst_2
  imul
  iadd
  iconst_2
  iadd
  getstatic TestNoErrors/global_array [I
  iconst_1
  iaload
  getstatic TestNoErrors/global_array [I
  iconst_1
  iaload
  iadd
  getstatic TestNoErrors/global_array [I
  iconst_1
  iaload
  getstatic TestNoErrors/global_array [I
  iconst_1
  iaload
  iadd
  new TestNoErrors
  dup
  invokespecial TestNoErrors/<init>()V
  putstatic TestNoErrors/global_internal LTestNoErrors;
  getstatic TestNoErrors/global_internal LTestNoErrors;
  invokevirtual TestNoErrors/getArray()[I
  new Test
  dup
  invokespecial Test/<init>()V
  putstatic TestNoErrors/global_external LTest;
  getstatic TestNoErrors/global_external LTest;
  invokevirtual Test/getArray()[I
  iconst_1
  iconst_2
  isub
  iflt LT_ELSE_0
  iconst_1
  goto LT_NEXT_0
  LT_ELSE_0:
  iconst_0
  LT_NEXT_0:
  ifne ELSE_0
  iconst_1
  istore_2
  goto NEXT_0
  ELSE_0:
  iconst_2
  istore_2
  NEXT_0:
  iconst_0
  istore_2
  WHILE_0:
  iload_2
  bipush 6
  isub
  iflt LT_ELSE_1
  iconst_1
  goto LT_NEXT_1
  LT_ELSE_1:
  iconst_0
  LT_NEXT_1:
  ifeq WHILE_NEXT_0
  iload_2
  iconst_1
  iadd
  istore_2
  getstatic TestNoErrors/global_array [I
  bipush 9
  iaload
  putstatic TestNoErrors/global_int I
  goto WHILE_0
  WHILE_NEXT_0:
  return
.end method


