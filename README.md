# HuiTong<br />
这是我的第一个Maven + SSM框架项目<br />
项目展示：www.wochi.xin/huitong<br />
部署环境：jdk1.7 + tomcat7 + mysql5.6<br />

实现功能：由maven管理，利用spring框架整合springmvc与mybatis实现部门管理，用户管理，角色管理等基本模块信息及其中的嵌套关系；<br />
项目结构：<br />
pro.sunhao.ht.pro包：为项目提供需要对象的类；<br />
pro.sunhao.ht.contoller包：项目控制层；<br />
pro.sunhao.ht.service包：项目的服务层；<br />
pro.sunhao.ht.mapper包：项目的dao层；<br />
pro.sunhao.ht.tool包：为项目提供所需要的工具类；<br />

数据库表结构：<br />
部门表dept_p，<br />
用户表user_p，用户详情表user_info_p，<br />
角色表role_p，角色-用户关系表role_user_p，<br />
