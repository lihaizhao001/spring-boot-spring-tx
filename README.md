# spring-boot-spring-tx
spring-tx 最高级别的类是AbstractPlatformTransactionManager，所以没有办法单独测试，所以这里要结合spring-jdbc，在spring-jdbc中有AbstractPlatformTransactionManager的子类DataSourceTransactionManager.

带来主要来自spring-boot-spring-jdbc

目前用的比较多的是声明式事务是@Transactional注解.

这里没有用@Transactional，而是用的TransactionInceptor和Advisor.
