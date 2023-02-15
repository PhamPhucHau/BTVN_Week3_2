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


#### API get all cart
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
#### API get all reviews by id product  
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
