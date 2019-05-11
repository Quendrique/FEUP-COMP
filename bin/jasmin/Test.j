.class public Test
.super java/lang/Object
.field static t I
.field static b Z
.field static p [I


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
  return
.end method



.method public getArray()[I
  .limit stack 20
  .limit locals 2
  iconst_3
  newarray int
  astore_1
  aload_1
  areturn
.end method


