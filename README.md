### 简介

为了完成关于设计模式（Design Patterns）的课程项目，我开发了一个基础的学生信息管理系统（Student Information Management System）。根据课程要求，我在设计中采用了三种设计模式：单例模式（Singleton Pattern）、观察者模式（Observer Pattern）和工厂模式（Factory Pattern）。数据库方面，我选择了MySQL 5.5.40作为数据存储后端。整个系统使用Java编程语言实现，图形用户界面（GUI）部分则采用了Swing框架。

* **单例模式**：确保全局只有一个类实例存在，避免了重复创建对象带来的资源浪费，常用于管理全局状态，如数据库连接池、配置管理等（仅在被观察者和注册面板中使用）。
* **观察者模式**：允许对象（被观察者）维护一组依赖于它的对象（观察者），当被观察者的状态发生变化时，所有依赖它的对象都会收到通知并自动更新。在学生信息管理系统中，这可以用于实现如当某个学生的信息更新时，所有关注该学生的界面或功能都能实时反映这种变化（但我只用于在控制台打印操作）。
* **工厂模式**：通过专门的类来创建其他类的实例，而不需要暴露具体的类构造和实现逻辑。在学生信息管理系统中，工厂模式可以用于创建对象，提高了代码的灵活性和可扩展性(本系统只用来生产不同功能的面板)。

### 数据库创建


```sql
CREATE TABLE admin (  
    id VARCHAR(255) NOT NULL,  
    pwd VARCHAR(255),  
    name VARCHAR(255),  
    PRIMARY KEY (id(191))  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE student (  
    id VARCHAR(255) NOT NULL,  
    name VARCHAR(255),  
    age VARCHAR(255),  
		sex VARCHAR(255), 
		major VARCHAR(255), 
    PRIMARY KEY (id(191))  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


```


通过使用这些设计模式，我能够构建一个结构清晰、易于维护和扩展的学生信息管理系统。同时，利用MySQL数据库和Swing框架，系统还具备了良好的数据存储和用户交互能力。
