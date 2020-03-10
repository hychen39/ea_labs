# ea_labs
Demo code for the course of Enterprise Application Development

Contact Info: hychen39@gm.cyut.edu.tw

# Development environment
JDK 8
Netbeans 8.2 (Only support up to Java 8)
Glassfish 5


# List of Netbeans Projects

- ea_unit01_demo: Hello JSF.

- ea_unit02_demo: Unit 03 - Creating JSF Pages using Facelets Technology.
  - `h:graphicImage`
  - `h:selectionXXX`
  - `h:commandXXX`
  - `f:param` and `f:attribute`

- ea_unit04_demo: Unit 04 - Developing with CDI beans

- ea_unit07_demo: 使用 Facade Pattern 實作資料庫的 CRUD.

- ea_unit08_demo

- ea_unit09_demo: Demo JPQL. Use the sample database in the Derby to demo the JPQL codes and use the JUnit to test them.
  
- ea_unit09_demo: Converter and Validator in the JSF framework.
  
- ea_unit11_demo: Handling application events in the JSF Framework.

# 使用 Payara 5 時開發 JSF 專案時要做的設定

將 `jakarta.faces.jar` 加入專案的 library.

`jakarta.faces.jar` 位置在 `[payara_root]/glassfishmodules/`

原因: Payara Server 5.193.1 is Jakarta EE 8 Full Profile compatible!

