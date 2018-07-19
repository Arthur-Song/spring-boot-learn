define({ "api": [
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
    "groupTitle": "Users"
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
    "groupTitle": "Users"
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
            "type": "json",
            "optional": false,
            "field": "user",
            "description": "<p>用户</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "{\n    \"username\":\"arthursong\",\n    \"email\":\"arthurdev@163.com\",\n    \"password\":\"123456\",\n    \"age\":18\n}",
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
    "groupTitle": "Users"
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
    "groupTitle": "Users"
  }
] });
