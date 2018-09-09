

![Halo-logo](/halo-docs/logo/logo.png)
================
[![Build Status](https://api.travis-ci.org/softwareking/halo.svg?branch=master)](https://api.travis-ci.org/softwareking/halo)
[!Maven Central Repo](https://img.shields.io/maven-central/v/org.xujin.halo/halo.svg)(https://mvnrepository.com/artifact/org.xujin.halo)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codebeat badge](https://codebeat.co/badges/edb89c5e-9a43-4323-8e2f-0d3ca486dbb7)](https://codebeat.co/projects/github-com-softwareking-halo-master)

## 1.Halo Framework

   Halo, 发音美 [ˈheɪloʊ]，和hello发音基本一致，中文名光环。Halo是Hallo的简写，是德语你好/develop/code/book/spring-cloud-code/README.md
的意思。
Halo框架名寓意是赋能于业务应用开发，业务方使用者自带光环，脚踏七彩祥云，为业务开发造福，为业务架构治理和防腐提供统一的方法论。
Halo框架是基于CQRS+扩展点+流程编排的应用框架，致力于采用领域驱动的设计思想，规范控制程序员的随心所欲，从而解决软件的复杂性问题。
架构原则很简单，即在高内聚，低耦合，可扩展，易理解大的指导思想下，尽可能的贯彻OO的设计思想和原则。

如果你觉得Halo不错，让你很爽，烦请拨冗**“Star”**。

>Halo站在巨人COPA的肩膀上进行重构增强，向阿里开源精神致敬，感谢原作者开源了这么优秀的项目！

>Halo Framework,光环框架是基于DDD+CQRS+扩展点+业务中间件，业务系统使用之自带光环!


## Halo框架的设计

### 2.1 Halo 模块

| 模块名 | 描述 | 备注 |
| --- | --- | --- |
| halo-base | base层注解 |  |
| halo-collection | 采集能力图 |  |
| halo-common | 框架公共部分 |  |
| halo-core | 框架核心 |  |
| halo-test | 框架测试模块 | todo 待重构 |
| halo-utils | 框架工具类用于各种DTO对象之间快速复制 |  |
| halo-feign | feign与Halo整合 |feign与Halo整合  |

### 2.2 Halo框架设计

#### 2.2.1 Convertor设计

在Halo中有三类主要的对象：

* ClientObject: 也就是二方库中的数据对象，主要承担DTO的职责。
* Entity/ValueObject: 也就是既有属性又有行为的领域实体。
* DataObeject：是用来获取数据用的，主要是DAO使用。

![](/halo-docs/image/convertor.png)

Convertor在上面三个对象之间的转换起到了至关重要的作用，然而Convertor里面的逻辑应该是简单的，大部分都是setter/getter, 如果属性重复度很高的话，也可以使用BeanUtils.copyProperties让代码变得更简洁。

但事实情况是，现在系统中很多的Convertor逻辑并没有在Convertor里面。


## 3.使用

### 3.1 maven 依赖

目前安装到中央仓库,版本1.0.4

```pom
<halo.framework.version>1.0.4</halo.framework.version>

<!-- Halo框架核心 -->
<dependency>
    <groupId>org.xujin.halo</groupId>
    <artifactId>halo-core</artifactId>
    <version>${halo.framework.version}</version>
</dependency>

<!-- Halo测试组件可选-->
<dependency>
    <groupId>org.xujin.halo</groupId>
    <artifactId>halo-test</artifactId>
    <version>${halo.framework.version}</version>
    <scope>test</scope>
</dependency>


<!-- Halo能力采集图-->
<dependency>
    <groupId>org.xujin.halo</groupId>
    <artifactId>halo-collection</artifactId>
    <version>${halo.framework.version}</version>
</dependency>
```

案例:[crm-sales](https://github.com/SoftwareKing/crm-sales)


