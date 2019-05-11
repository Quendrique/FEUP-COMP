.class public TestNoErrors
.super java/lang/Object
.field static global_int I 
.field static global_boolean Z 
.field static global_array [I 
.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method


.method public static getArray()[I
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
  istore_1
  iconst_1
  istore_2
  iconst_2
  putfield TestNoErrors/global_int I
  iconst_5
  newarray int
  putfield TestNoErrors/global_array [I
  iconst_1
  iconst_1
  iadd
  iconst_1
  iconst_1
  iand
  iload_1
  iconst_1
  iadd
  iload_1
  iload_1
  iadd
  iconst_1
  iconst_1
  iconst_2
  imul
  iadd
  iconst_2
  iadd
  aload_0
  getfield TestNoErrors/global_array [I
  iconst_1
  iaload
  aload_0
  getfield TestNoErrors/global_array [I
  iconst_1
  iaload
  iadd
  aload_0
  getfield TestNoErrors/global_array [I
  iconst_1
  iaload
  aload_0
  getfield TestNoErrors/global_array [I
  iconst_1
  iaload
  iadd
  aload_0
  getfield TestNoErrors/global_internal LTestNoErrors
  invokevirtual TestNoErrors/getArray()[I
  new Test
  dup
  invokespecial Test/<init>()V
  putfield TestNoErrors/global_external LTest
  aload_0
  getfield TestNoErrors/global_external LTest
  invokevirtual Test/getArray()[I
  return
.end method


