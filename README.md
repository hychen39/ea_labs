# ea_labs
Demo codes for the course of Enterprise Application Development

Contact Info: hychen39@gm.cyut.edu.tw

# Directory Structures

- `./` demo codes for each unit
- `./0Assignments/`  semi-finished codes for doing the assignments
- `./1Hands-on-labs/` completed hands-on labs

# Development environment
JDK 8
Netbeans 8.2 (Only support up to Java 8)
Glassfish 5


# List of Netbeans Projects

- ea_unit01_demo: Hello JSF.

- ea_unit02_demo: Unit 02 - Creating JSF Pages using Facelets Technology.
  - `h:graphicImage`
  - `h:selectionXXX`
  - `h:commandXXX`
  - `f:param` and `f:attribute`

- ea_unit03_demo: Unit 03 - Developing with CDI beans
- 
- ea_unit04_demo: Unit 04 - Working with the navigation

- ea_unit05_demo: Unit 05 - Introduction to Enterprise JavaBean (EJB). Demo how to inject EJB component to CDI bean in the JSF application.

- ea_unit06_demo: 單個 Entity 的資料庫 CRUD 操作

- ea_unit07_demo: uni-directional and bi-directional one-to-one, one-to-many, and many-to-many.

- ea_unit08_demo: Use EntityManager Factory to create the EntityManager. Create and execute JPQL, including: dynamic, named, typed named queries. 

- sample_database.sql: SQL statements to create the sample database for ea_unit08_1.

<!-- - ea_unit09_demo: Demo JPQL. Use the sample database in the Derby to demo the JPQL codes and use the JUnit to test them. -->
  
- ea_unit09_demo: Converter and Validator in the JSF framework.

- ea_unit11_demo
  - ea_unit11_demo/unit11_lab1: Use JSF templates.
  - ea_unit11_demo/unit11_lab2: Ajax and Phase listener

  
<!-- - ea_unit11_demo: Handling application events in the JSF Framework. --> 

<!-- ea_unitXX_demo: 使用 Facade Pattern 實作資料庫的 CRUD. -->

## 1Hands-on-labs directory

- unit12
  - unit12/secureApp-base: Project for practicing securing configuration for the JSF application.
  - unit12/secureApp-complete: Completed project.


# 使用 Payara 5 時開發 JSF 專案時要做的設定

將 `jakarta.faces.jar` 加入專案的 library.

`jakarta.faces.jar` 位置在 `[payara_root]/glassfishmodules/`

原因: Payara Server 5.193.1 is Jakarta EE 8 Full Profile compatible!

