define({ "api": [
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "spring-boot-with-apidoc/apidoc/main.js",
    "group": "E__workspace_blog_spring_boot_learn_spring_boot_with_apidoc_apidoc_main_js",
    "groupTitle": "E__workspace_blog_spring_boot_learn_spring_boot_with_apidoc_apidoc_main_js",
    "name": ""
  },
  {
    "type": "DELETE",
    "url": "/user/:id",
    "title": "删除用户",
    "name": "DeleteUser",
    "group": "Users",
    "version": "0.0.1-SNAPSHOT",
    "description": "<p>用于通过主键删除用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": "<p>用户主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "{\n    \"id\":1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"id\":1,\"username\":\"arthursong\",\"email\":\"arthurdev@163.com\",\"password\":\"123456\",\"age\":18}",
          "type": "json"
        }
      ]
    },
    "filename": "spring-boot-with-apidoc/src/main/java/com/arthursong/demo/controller/UserController.java",
    "groupTitle": "Users",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/user/:id"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/user/:id",
    "title": "获取用户",
    "name": "GetUser",
    "group": "Users",
    "version": "0.0.1-SNAPSHOT",
    "description": "<p>用于通过主键查询用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": "<p>用户主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "{\n    \"id\":1\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"id\":1,\"username\":\"arthursong\",\"email\":\"arthurdev@163.com\",\"password\":\"123456\",\"age\":18}",
          "type": "json"
        }
      ]
    },
    "filename": "spring-boot-with-apidoc/src/main/java/com/arthursong/demo/controller/UserController.java",
    "groupTitle": "Users",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/user/:id"
      }
    ]
  },
  {
    "type": "POST",
    "url": "/user",
    "title": "保存用户",
    "name": "SaveUser",
    "group": "Users",
    "version": "0.0.1-SNAPSHOT",
    "description": "<p>用于保存或修改用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>邮箱</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "?username=arthursong&email=arthurdev@163.com&password=123456&age=18",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "int",
            "optional": false,
            "field": "1",
            "description": "<p>1:表示成功</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "1",
          "type": "json"
        }
      ]
    },
    "filename": "spring-boot-with-apidoc/src/main/java/com/arthursong/demo/controller/UserController.java",
    "groupTitle": "Users",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/user"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/users",
    "title": "用户列表",
    "name": "UserList",
    "group": "Users",
    "version": "0.0.1-SNAPSHOT",
    "description": "<p>用于获取所有用户列表</p>",
    "success": {
      "examples": [
        {
          "title": "返回样例:",
          "content": "[{\"id\":1,\"username\":\"arthursong\",\"email\":\"arthurdev@163.com\",\"password\":\"123456\",\"age\":18}]",
          "type": "json"
        }
      ]
    },
    "filename": "spring-boot-with-apidoc/src/main/java/com/arthursong/demo/controller/UserController.java",
    "groupTitle": "Users",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/users"
      }
    ]
  }
] });
