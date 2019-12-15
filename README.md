# spring-boot-demo

国际化步骤：
1、在resources下新建文件夹i18n
2、在i18n下新建文件login.properties、login_en_US.properties、login_zh_CN.properties
3、在文件login.properties、login_en_US.properties、login_zh_CN.properties中编写资源
4、在application.properties修改spring.messages.basename=i18n.login
5、在页面获取国际化资源，用#{}方式获取
