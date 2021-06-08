# repoo
add departments
http://localhost:8080/api/departments
[
  {
        "departmentName": "java",
        "managerID": 2,
        "noEmployee": 10
  },
  {
     "departmentName": "HR",
        "managerID": 2,
        "noEmployee": 10
  }
  
]


add employee
http://localhost:8080/api/employees
 [
  {
        "id": 1,
        "name": "hagar",
        "jobTitle": "hr",
        "salary": 1000.0,
        "deptartment": {
            "id": 1
        }
    },
    {
        "id": 2,
        "name": "youmna",
        "jobTitle": "manager",
        "salary": 20000.0,
        "deptartment": {
            "id": 1
        }
    }
    ]
