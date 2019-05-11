.class public TestNoErrors
.super java/lang/Object
.field static global_int I 
.field static global_boolean Z 
.field static global_array [I 
.method public <init>()V
  aload_0
  invokenonvirtual java/lang/Object/<init>()V
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
  istore_0
  iconst_5
  newarray int
  astore_2
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
  aload_2
  iconst_1
  iaload
  aload_2
  iconst_1
  iaload
  iadd
  aload_2
  iconst_1
  iaload
  aload_2
  iconst_1
  iaload
  iadd
  return
.end method


