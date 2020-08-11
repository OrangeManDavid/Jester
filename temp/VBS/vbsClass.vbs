


Class User
  Private Str_Name '声明变量Str_Name
  Private Int_Age '声明变量Int_Age
  
  'Property Get语句，获取属性值或对象引用，Default只与Public一起使用，表示该属性为类的默认属性
  Public Property Get Myname
    Myname = Str_Name
  End Property
  
  Public Property Get MyAge
    MyAge = Int_Age
  End Property
  
  'Property Let语句，设置属性值
  Public Property Let Myname(New_Name)
    Str_Name = New_Name
  End Property 
  
  Public Property Let MyAge(New_Age)
    Int_Age = new_age
  End Property
  
  '类方法
  
  Public Function ToString()
    ToString = Myname + "----" + MyAge
  End Function
End Class

Set MyUser = New User
MyUser.MyAge = "22"
MyUser.Myname = "john"
MyUser.ToString
WScript.Echo MyUser.ToString





Function DictionaryMulti(param1, param2, param3)
    Dim oDict
    ' 创建字典对象
    Set oDict = CreateObject("Scripting.Dictionary")
    ' 增加键名和键值
    oDict("a") = param1
    oDict("b") = param2
    oDict("c") = param3
  
   ' 指定函数返回为Dictionary对象
   Set DictionaryMulti = oDict
End Function
 
Dim oDict, sMsg
Set oDict = DictionaryMulti("value1", "value2", "value3")
 
 
' 遍历返回的Dictionary中的键
For Each vKey In oDict
    sMsg = sMsg & oDict.Item(vKey) & vbCrlf
Next
 
Msgbox sMsg
