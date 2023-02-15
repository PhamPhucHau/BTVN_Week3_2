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


#### API get all cart. Method=GET
1. [http://localhost:8080/cart](http://localhost:8080/cart)
- 
```
{
	
}
```
- Kết quả 
```
[
    {
        "id": 1,
        "total": 100000,
        "userId": 1
    },
    {
        "id": 2,
        "total": 200000,
        "userId": 2
    },
    {
        "id": 3,
        "total": 123000,
        "userId": 3
    },
    {
        "id": 4,
        "total": 400000,
        "userId": 4
    },
    {
        "id": 5,
        "total": 1000000,
        "userId": 5
    },
    {
        "id": 6,
        "total": 2000000,
        "userId": 6
    },
    {
        "id": 7,
        "total": 10000000,
        "userId": 7
    },
    {
        "id": 8,
        "total": 10000,
        "userId": 8
    },
    {
        "id": 9,
        "total": 13548125,
        "userId": 9
    },
    {
        "id": 10,
        "total": 15489641,
        "userId": 10
    }
]
```
#### API get all reviews by id product. Method=GET. 
1. [http://localhost:8080/rating/product/1](http://localhost:8080/rating/product/1)
- 
```
{
	
}
```
- Kết quả 
```
[
    {
        "id": 11,
        "comment": "sản phẩm tốt",
        "rateScore": 1.0,
        "userId": 1,
        "productId": 1
    },
    {
        "id": 18,
        "comment": "Comment1",
        "rateScore": 1.0,
        "userId": 1,
        "productId": 1
    },
    {
        "id": 19,
        "comment": "Comment1",
        "rateScore": 1.0,
        "userId": 1,
        "productId": 1
    },
    {
        "id": 20,
        "comment": "Comment1",
        "rateScore": 1.0,
        "userId": 1,
        "productId": 1
    }
]
```
#### API get all coupon. Method=GET. 
1. [http://localhost:8080/coupon](http://localhost:8080/coupon)
- 
```
{
	
}
```
- Kết quả 
```
[
    {
        "id": 1,
        "name": "Khuyến mãi cho khách hàng mới",
        "discount": 0.1,
        "minPrice": 0.0,
        "maxPrice": 50000.0,
        "code": "KMKHM",
        "amount": 50.0
    },
    {
        "id": 2,
        "name": "Giảm 10% Giảm tối đa 50,000đ đơn tối thiểu 99,000đ",
        "discount": 0.1,
        "minPrice": 99000.0,
        "maxPrice": 50000.0,
        "code": "HUJUI",
        "amount": 30.0
    },
    {
        "id": 3,
        "name": "Giảm 20,000đ đơn tối thiểu 199,000đ",
        "discount": 0.0,
        "minPrice": 199000.0,
        "maxPrice": 20000.0,
        "code": "HUYEJ",
        "amount": 30.0
    },
    {
        "id": 4,
        "name": "Giảm 10% Giảm tối đa 300,000đ đơn tối thiểu 499,000đ",
        "discount": 0.1,
        "minPrice": 499000.0,
        "maxPrice": 300000.0,
        "code": "YUITLR",
        "amount": 30.0
    },
    {
        "id": 5,
        "name": "Giảm 50,000đ đơn tối thiểu 0đ",
        "discount": 0.0,
        "minPrice": 0.0,
        "maxPrice": 50000.0,
        "code": "QIEHFU",
        "amount": 30.0
    },
    {
        "id": 6,
        "name": "Giảm 10,000đ đơn tối thiểu 120,000đ",
        "discount": 0.0,
        "minPrice": 120000.0,
        "maxPrice": 10000.0,
        "code": "TEWUYG",
        "amount": 30.0
    },
    {
        "id": 7,
        "name": "Giảm 5% Giảm tối đa 500,000đ đơn tối thiếu 300,000đ",
        "discount": 0.05,
        "minPrice": 300000.0,
        "maxPrice": 500000.0,
        "code": "OIUYTR",
        "amount": 30.0
    },
    {
        "id": 8,
        "name": "Giảm 150,000đ đơn tối thiểu 1,500,000đ",
        "discount": 0.0,
        "minPrice": 1500000.0,
        "maxPrice": 150000.0,
        "code": "RTEGDT",
        "amount": 30.0
    },
    {
        "id": 9,
        "name": "Giảm 10% Giảm tối đa 60,000đ đơn tối thiểu 400,000đ",
        "discount": 0.1,
        "minPrice": 400000.0,
        "maxPrice": 60000.0,
        "code": "YEUWGY",
        "amount": 30.0
    },
    {
        "id": 10,
        "name": "Giảm 10% Giảm tối đa 100,000đ đơn tối thiểu 600,000đ",
        "discount": 0.1,
        "minPrice": 600000.0,
        "maxPrice": 100000.0,
        "code": "EGYFGE",
        "amount": 30.0
    }
]
```
#### API get coupon by coupon id. Method=GET
1. [http://localhost:8080/coupon/1](http://localhost:8080/coupon/1)
- 
```
{
	
}
```
- Kết quả 
```
{
    "id": 1,
    "name": "Khuyến mãi cho khách hàng mới",
    "discount": 0.1,
    "minPrice": 0.0,
    "maxPrice": 50000.0,
    "code": "KMKHM",
    "amount": 50.0
}
```
#### API create new  coupon.  Method=POST
1. [http://localhost:8080/coupon](http://localhost:8080/coupon)
- 
```
{
    "name": "Khuyến mãi cho khách hàng mới",
    "discount": 0.1,
    "minPrice": 0.0,
    "maxPrice": 50000.0,
    "code": "KMKHM",
    "amount": 50.0
}
```
- Kết quả 
```
{
    "id": 11,
    "name": "Khuyến mãi cho khách hàng mới",
    "discount": 0.1,
    "minPrice": 0.0,
    "maxPrice": 50000.0,
    "code": "KMKHM",
    "amount": 50.0
}
```
#### API update a coupon by .  Method:PUT
1. [http://localhost:8080/coupon/11](http://localhost:8080/coupon/11)
- 
```
{
    "name": "Khuyến mãi cho khách hàng mới",
    "discount": 0.1,
    "minPrice": 2000.0,
    "maxPrice": 50000.0,
    "code": "KMKHM",
    "amount": 50.0
}
```
- Kết quả 
```
true
```
#### API update a coupon by .  Method:
1. [http://localhost:8080/coupon/11](http://localhost:8080/coupon/11)
- 
```

```
- Kết quả 
```
true
```
### 🚍 Communication

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192107854-765620d7-f909-4953-a6da-36e1ef69eea6.png"> |      HTTP       | `https://user-images.githubusercontent.com/25181517/192107854-765620d7-f909-4953-a6da-36e1ef69eea6.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192107858-fe19f043-c502-4009-8c47-476fc89718ad.png"> |      REST       | `https://user-images.githubusercontent.com/25181517/192107858-fe19f043-c502-4009-8c47-476fc89718ad.png` |

### 🧰 Version Control

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192108372-f71d70ac-7ae6-4c0d-8395-51d8870c2ef0.png"> |       Git       | `https://user-images.githubusercontent.com/25181517/192108372-f71d70ac-7ae6-4c0d-8395-51d8870c2ef0.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192108374-8da61ba1-99ec-41d7-80b8-fb2f7c0a4948.png"> |     GitHub      | `https://user-images.githubusercontent.com/25181517/192108374-8da61ba1-99ec-41d7-80b8-fb2f7c0a4948.png` |

### 🔨 Tools

|                                                        Technology Icon                                                        |  Technology Name   | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :----------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png"> |      InteliJ       | `https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192108891-d86b6220-e232-423a-bf5f-90903e6887c3.png"> | Visual Studio Code | `https://user-images.githubusercontent.com/25181517/192108891-d86b6220-e232-423a-bf5f-90903e6887c3.png` |


### 🌐 Web Dev

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192158954-f88b5814-d510-4564-b285-dff7d6400dad.png"> |      HTML       | `https://user-images.githubusercontent.com/25181517/192158954-f88b5814-d510-4564-b285-dff7d6400dad.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/183898674-75a4a1b1-f960-4ea9-abcb-637170a00a75.png"> |       CSS       | `https://user-images.githubusercontent.com/25181517/183898674-75a4a1b1-f960-4ea9-abcb-637170a00a75.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192158956-48192682-23d5-4bfc-9dfb-6511ade346bc.png"> |      Sass       | `https://user-images.githubusercontent.com/25181517/192158956-48192682-23d5-4bfc-9dfb-6511ade346bc.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/183898054-b3d693d4-dafb-4808-a509-bab54cf5de34.png"> |    Bootstrap    | `https://user-images.githubusercontent.com/25181517/183898054-b3d693d4-dafb-4808-a509-bab54cf5de34.png` |

### ✨ UI/UX

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/189715289-df3ee512-6eca-463f-a0f4-c10d94a06b2f.png"> |      Figma      | `https://user-images.githubusercontent.com/25181517/189715289-df3ee512-6eca-463f-a0f4-c10d94a06b2f.png` |

### 📜 JavaScript

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117447155-6a868a00-af3d-11eb-9cfe-245df15c9f3f.png"> |   JavaScript    | `https://user-images.githubusercontent.com/25181517/117447155-6a868a00-af3d-11eb-9cfe-245df15c9f3f.png` |

### ☕ Java

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png"> |      Java       | `https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117201470-f6d56780-adec-11eb-8f7c-e70e376cfd07.png"> |     Spring      | `https://user-images.githubusercontent.com/25181517/117201470-f6d56780-adec-11eb-8f7c-e70e376cfd07.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png"> |   Spring Boot   | `https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png"> |      Maven      | `https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png"> |    Hibernate    | `https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117533873-484d4480-afef-11eb-9fad-67c8605e3592.png"> |      JUnit      | `https://user-images.githubusercontent.com/25181517/117533873-484d4480-afef-11eb-9fad-67c8605e3592.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/190229463-87fa862f-ccf0-48da-8023-940d287df610.png"> |     Lombok      | `https://user-images.githubusercontent.com/25181517/190229463-87fa862f-ccf0-48da-8023-940d287df610.png` |



### 💾 Database

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117208736-bdedc080-adf5-11eb-912f-61c7d43705f6.png"> |     Oracle      | `https://user-images.githubusercontent.com/25181517/117208736-bdedc080-adf5-11eb-912f-61c7d43705f6.png` |


### 🤿 DevOps

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/192158606-7c2ef6bd-6e04-47cf-b5bc-da2797cb5bda.png"> |      bash       | `https://user-images.githubusercontent.com/25181517/192158606-7c2ef6bd-6e04-47cf-b5bc-da2797cb5bda.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/117207330-263ba280-adf4-11eb-9b97-0ac5b40bc3be.png"> |     Docker      | `https://user-images.githubusercontent.com/25181517/117207330-263ba280-adf4-11eb-9b97-0ac5b40bc3be.png` |

### ☁️ Cloud

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/183911544-95ad6ba7-09bf-4040-ac44-0adafedb9616.png"> | Microsoft Azure | `https://user-images.githubusercontent.com/25181517/183911544-95ad6ba7-09bf-4040-ac44-0adafedb9616.png` |





### 🖥️ Operating system

|                                                        Technology Icon                                                        | Technology Name | URL                                                                                                     |
| :---------------------------------------------------------------------------------------------------------------------------: | :-------------: | ------------------------------------------------------------------------------------------------------- |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/186884150-05e9ff6d-340e-4802-9533-2c3f02363ee3.png"> |     Windows     | `https://user-images.githubusercontent.com/25181517/186884150-05e9ff6d-340e-4802-9533-2c3f02363ee3.png` |
| <img height="50" src="https://user-images.githubusercontent.com/25181517/186884153-99edc188-e4aa-4c84-91b0-e2df260ebc33.png"> |     Ubuntu      | `https://user-images.githubusercontent.com/25181517/186884153-99edc188-e4aa-4c84-91b0-e2df260ebc33.png` |


