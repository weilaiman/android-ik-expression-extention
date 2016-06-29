在著名的开源表达式解析器IK Expression(http://code.google.com/p/ik-expression/) 基础之上加以修改，使之成为一个Android Library Project，IKExpression.cfg.xml文件源设置更方便

Demo文件：FormularCalculateDemo.java

设置方式：
1，表达式自定义函数描述文件IKExpression.cfg.xml在assert中，使用该文件需要在FunctionLoader类的loadFunctionByXmlDef函数设置FunctionXMLConfig.setXmlInputStreamInAsserts(context, "yourpath/IKExpression.cfg.xml")
若IKExpression.cfg.xml在sd卡路径读取，则需要在FunctionLoader类的loadFunctionByXmlDef函数设置		FunctionXMLConfig.setXmlInputStreamInFile(FILE_NAME);

2，表达式自定义函数如全部为英文也可以在CommonFunctions类中直接定义，如min,max等简单函数
