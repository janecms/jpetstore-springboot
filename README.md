# spring-jpetstore

------------

fock from [spring-jpetstore](https://github.com/making/spring-jpetstore)

## 说明文档
[docs](http://www.mybatis.org/jpetstore-6/)

## 技术选型
- Spring MVC, 

- MyBatis 3

- Spring Security

- logback
## 数据库设计
![jpetstore_database](docs/images/jpetstore_database.png)
  > | table_name   | Description |
  > | --------- | ----------- |
  > | supplier  | 供应商|
  > | signon  | 登录sso|
  > | account  | 用户账户|
  > | profile  | 用户设置|
  > | bannerdata  | 签名页面底部|
  > | orders  | 订单信息|
  > | orderstatus  | 订单跟踪记录|
  > | lineitem  | 订单子项|
  > | category  | 产品目录|
  > | product  | 产品基本信息|
  > | item  | 产品扩展信息(购买单位)|
  > | inventory  | 库存|
  > | sequence  | order seq|

------------------------
## 分支介绍

- master : mvc XML配置

- mvc-annotation:mvc annotation配置

- distribute :分布式拆分多个模块

- springboot:springboot+mybatis+springmvc

- springboot-redis:持久层采用redis

-------------------------
## Spring BOOT
- http://projects.spring.io/spring-boot/
- https://git.oschina.net/didispace
- http://blog.didispace.com/

### Thymeleaf
- http://www.thymeleaf.org/
- http://www.thymeleaf.org/documentation.html
- https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/

