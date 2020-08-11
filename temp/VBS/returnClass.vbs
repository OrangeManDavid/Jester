
' 定义一个有多个变量成员的类
Class MultiValue
    Dim a, b, c
End Class
 
Function ClassMulti(param1, param2, param3)
    Dim oClass
    ' 实例化类  
    Set oClass = New MultiValue
    oClass.a = param1
    oClass.b = param2
    oClass.c = param3
   
    ' 指定函数返回为oClass对象
    Set ClassMulti = oClass
End Function
 
Dim oClass
Set oClass = ClassMulti("value1","" ,"" ,)

WScript.Echo oClass.a
WScript.Echo oClass.b
WScript.Echo oClass.c