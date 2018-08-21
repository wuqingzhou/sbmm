这是一行测试文本：${testTxt}

list字符串循环
<#list myStrList as tempStr>
    ${tempStr}
</#list>

list对象循环
<#list myObjList as tempObj>
    ${tempObj.name}    ${tempObj.age}
</#list>
