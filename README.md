# BTVN_Week3_2 
# 1/. Cấu hình ứng dụng với các thuộc tính sau
[https://github.com/PhamPhucHau/BTVN_Week3_2/blob/master/src/main/resources/application.properties ](https://github.com/PhamPhucHau/BTVN_Week3_2/blob/master/src/main/resources/application.properties)
#### Api để test valid DepartmentDTO
1. [http://localhost:9081/likelion/department/addDepartment](http://localhost:9081/likelion/department/addDepartment)
- 
```
{
	
}
```
- Kết quả 
```
Exeption[Field error in object 'departmentDTO' on field 'deptName': rejected value [null]; codes [NotNull.departmentDTO.deptName,NotNull.deptName,NotNull.java.lang.String,NotNull];
arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [departmentDTO.deptName,deptName]; arguments []; default message [deptName]]; default message [Department Name is not allowed null]]
```
2. 

```
{
	"departmentId":1,
	"deptName": "Human Resource",
	"employeeDTOlist":
	[
	{
	"employeeId": 1,
	"name":"Nguyen van A",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau@gmail.com"
	},
	{
	"employeeId": 2,
	"name":"Nguyen van B",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau2@gmail.com"
	}

	]
	
}
```
- Kết quả 
```
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 25
< Date: Wed, 07 Sep 2022 08:13:41 GMT
{
Adding department Success
}
```
- Invalid Email for Employee
```
{
	"departmentId":1,
	"deptName": "Human Resource",
	"employeeDTOlist":
	[
	{
	"employeeId": 1,
	"name":"Nguyen van A",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau@gmail.com"
	},
	{
	"employeeId": 2,
	"name":"Nguyen van B",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau2gmail.com"
	}

	]
	
}
```
- Kết quả 
```
Exeption[Field error in object 'departmentDTO' on field 'employeeDTOlist[1].email': rejected value [phamphuchau2gmail.com]; codes [Email.departmentDTO.employeeDTOlist[1].email,Email.departmentDTO.employeeDTOlist.email,Email.employeeDTOlist[1].email,Email.employeeDTOlist.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [departmentDTO.employeeDTOlist[1].email,employeeDTOlist[1].email]; arguments []; default message [employeeDTOlist[1].email],[Ljavax.validation.constraints.Pattern$Flag;@6bd4238,.*]; default message [Format email is not valid]]
```

# Validation in EmployeeDTO
1. [http://localhost:9081/likelion/employee/addEmployee](http://localhost:9081/likelion/employee/addEmployee)
- Dữ liệu hợp lệ
```
{
	"employeeId": 1,
	"name":"Nguyen van A",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau@gmail.com"
}
```
- Kết quả 

```
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 7
< Date: Wed, 07 Sep 2022 08:23:51 GMT
Body{
Success
}

```

- Name nhỏ hơn 10 kí tự 

```
{
	"employeeId": 1,
	"name":"Nguyen",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau@gmail.com"
}
```

- Kết quả
```
{
Exception[Field error in object 'employeeDTO' on field 'name': rejected value [Nguyen]; codes [Length.employeeDTO.name,Length.name,Length.java.lang.String,Length]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employeeDTO.name,name]; arguments []; default message [name],50,10]; default message [length must be between 10 and 50]]
}

```
- Không đúng format email

```
{
	"employeeId": 1,
	"name":"Nguyen Van A",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchaugmail.com"
}
```
- Kết quả 
```
Exception[Field error in object 'employeeDTO' on field 'email': rejected value [phamphuchaugmail.com]; codes [Email.employeeDTO.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employeeDTO.email,email]; arguments []; default message [email],[Ljavax.validation.constraints.Pattern$Flag;@6bd4238,.*]; default message [Format email is not valid]]
```
# Logging Respect
1. logging trước và sau khi gọi method getDepartmentDto
 [http://localhost:9081/likelion/department/getDepartment](http://localhost:9081/likelion/department/getDepartment)
```
{
	"departmentId":1,
	"deptName": "Human Resource",
	"employeeDTOlist":
	[
	{
	"employeeId": 1,
	"name":"Nguyen van A",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau@gmail.com"
	},
	{
	"employeeId": 2,
	"name":"Nguyen van B",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchau2@gmail.com"
	}

	]
	
}
```
-Kết quả
```
{
	"departmentId": 1,
	"deptName": "Human Resource",
	"employeeDTOlist": [
		{
			"employeeId": 1,
			"name": "Nguyen van A",
			"birthDate": "2001-03-28T00:00:00.000+00:00",
			"gender": "Nam",
			"email": "phamphuchau@gmail.com"
		},
		{
			"employeeId": 2,
			"name": "Nguyen van B",
			"birthDate": "2001-03-28T00:00:00.000+00:00",
			"gender": "Nam",
			"email": "phamphuchau2@gmail.com"
		}
	]
}
```
- Kết quả logging
```
07-Sep-2022 15:49:10.246 INFO  c.e.B.S.DepartmentDTOService -before called service get DepartmentDTOexecution(DepartmentDTO com.example.BTVN_Week3_2.Service.Implement.DepartmentDTOServiceImplement.getDepartmentDTO(DepartmentDTO))
07-Sep-2022 15:49:10.250 INFO  c.e.B.S.DepartmentDTOService -***LoggingAspect.Log after called service get DepartmentDTOexecution(DepartmentDTO com.example.BTVN_Week3_2.Service.Implement.DepartmentDTOServiceImplement.getDepartmentDTO(DepartmentDTO))

```
-logging sau khi gọi method getEmployeeDto khôg thành công 
 [http://localhost:9081/likelion/employee/getEmployee](http://localhost:9081/likelion/employee/getEmployee) 
 - ID khong hợp lệ 
 ```
{
	
	"employeeId": 0,
	"name":"Nguyen van A",
	"birthDate": "2001-03-28",
	"gender":"Nam",
	"email":"phamphuchaugmail.com"
}
 ```
 - Kết quả 
 ```
 Exception
 ```
 - Logging
 ```
 07-Sep-2022 16:26:45.185 ERROR c.e.B.S.EmployeeDTOService -***LoggingAspect.Log after throwing called service get EmployeeDTOEmployeeDTO com.example.BTVN_Week3_2.Service.Implement.EmployeeDTOServiceImplement.getEmployeeDTO(EmployeeDTO)Exception isjava.lang.Exception: Lỗi invalid ID

 ```


