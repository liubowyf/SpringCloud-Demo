# SpringCloud-Demo
微服务架构主流整合示例

目录

[1. 整合方案选型](#1-整合方案选型)

[2. 服务安装部署](#2-服务安装部署)

[2.1  Nacos部署](#21--nacos部署)

## 1. 整合方案选型

项目部署：Docker

开发框架：SpringBoot

微服务架构：SpringCloud

注册中心：Nacos , Eureka （分别搭建示例）

网关：Spring Cloud Gateway,zuul （分别搭建示例）

配置中心：Nacos , Spring Cloud Config 分别搭建示例

链路跟踪服务：Spring Cloud Sleuth , Zipkin（使用说明）

服务容错：Hystrix 

负载均衡：Feign

日志收集及管理：ELK (Elasticsearch、Logstash、Kibana)（搭建及配置说明）

 
## 2. 服务安装部署

### 2.1  Nacos部署
1. 在Nacos的github上下载最新文档版本的安装包，也可访问如下地址直接下载：
    https://pan.baidu.com/s/1186nmlqPGows9gUZKAx8Zw 提取码：rest
2. 把安装包放到Linux安装目录下（我安装在/app路径下），解压：
    
    `tar -xvf /app/nacos-server-1.3.0.tar.gz`
3. 启动nacos服务 （standalone代表着单机模式运行，非集群模式）

    `sh /app/nacos/bin/startup.sh -m standalone`

4. 配置Nacos，持久化数据到Mysql数据库

    1. 安装数据库，且确保版本5.6.5+

    2. 使用 conf/nacos-mysql.sql 文件初始化数据库

    3. 修改conf/application.properties文件增加mysql支持

    4. 重启服务

```java
    spring.datasource.platform=mysql
    db.num=1
    db.url.0=jdbc:mysql://localhost:3306/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
    db.user=root
    db.password=123456
```
![CINQa.png](https://wx2.sbimg.cn/2020/07/20/CINQa.png)
