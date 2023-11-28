# accounting-server
java学习记账api

## 项目结构
```
src
├── main
│   ├── java
│   │   └── com.hcc.accounting
│   │       ├── config(配置相关、bean)
│   │       ├── controller(api层，用于处理所有的http请求和响应、基本参数校验)
│   │       ├── converter(分层数据模型转换)
│   │       ├── manager/service(业务逻辑层，用于编写业务逻辑)
│   │       ├── dao(数据持久层，用于与数据库进行交互)
│   │       ├── mapper(数据持久层，用于与数据库进行交互)
│   │   │       ├── bo(对应manager层使用)
│   │   │       ├── dao(对应数据库表结构)
│   │   │       ├── vo(对应controller层使用)

│   │       ├── external(外部第三方服务集成、或者其他模块)
│   │       ├── model(数据模型)
│   │       ├── exception(异常处理)

