call ParseJson("{"total":4,"contents":[{"Index":"1","Value":"Accenture"},{"Index":"2","Value":"IBM"},{"Index":"3","Value":"Aflac"}]}")
Sub ParseJson(str)
    Dim sc
    Set sc = CreateObject("MSScriptControl.ScriptControl")
    sc.Language = "JScript"
    sc.AddCode "var o = " & str & ";"
    a =  sc.Eval("o.a")
    b =  sc.Eval("o.b")
    c =  sc.Eval("o.c")
    d =  sc.Eval("o.d")
    e =  sc.Eval("o.e")
    WScript.Echo a, b, c, d, e
End Sub