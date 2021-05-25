U can replace ___localhost___ to ___tonydomain.ddns.net___

# Account

Link: http://localhost:8080/api/accounts/signup

Or: http://localhost:8080/giftapp/api/accounts/signup

## POST:

### Request

Body:

```json
{
	"username": "catuser",
	"password": "123meow"
}
```

### Response

Status code:

+ 400 (Bad Request): Invalid input or username was exist
+ 201 (Created): Successfully

---

Link: http://localhost:8080/api/accounts/signin

Or: http://localhost:8080/giftapp/api/accounts/signin

## POST

### Request

Body:

```json
{
	"username": "catuser",
	"password": "123meow",
    	"accountType": 1
}
```

accountType

+ 1: normal user
+ 0: admin user

### Response

Status code:

+ 400 (Bad Request): Invalid input
+ 200 (OK): Successfully

# Nhóm 15
# Mô tả phiên bản 1.1

# API: AccountInfos
link: http://localhost:8080/api/accountinfos
## POST
<!---
     * 
     * POST
     * Lưu accountInfo vào database
     * @param accountInfoModel
     * @return
     * @throws URISyntaxException
     * Use for add acountinfos into database
     * NOTE: "phonenum" don't have zero in beginning 
     * 
-->
link: http://localhost:8080/api/accountinfos
### Request
```
{
    "uname" : "khangtest2",
    "disname" : "khangtest2",
    "uaddress" : "daylaaddresss",
    "phonenum" : 919910266
}
```

### Response
#### Successes
Status: 201
Lưu thành công accountInforService

#### Failure
Status: 404

## PUT
<!---
     * PUT
     * update accountInfo
     * @param uname
     * @param accountInfoModel
     * @return
     * @throws URISyntaxException
     * Use for update accountinfos
     * NOTE: "phonenum" don't have zero in beginning 
-->
link: http://localhost:8080/api/accountinfos/khangtest1
### Request
```
{
    "disname" : "khangtest3",
    "uaddress" : "daylaaddresss",
    "phonenum" : 919910266
}
```

### Response
#### Successes
Status:200
AccountInfo đã được update

#### Failure
Status:404

## GET
<!---
    * Lấy tất cả AccountInfos
    * GET
    * Note: API for get all accountinfos
-->
### Request
link: http://localhost:8080/api/accountinfos
### Response
#### Successes
```
[
    {
        "uname": "khangtest1",
        "disname": "khangtest",
        "uaddress": "daylaaddress",
        "phonenum": 919910266
    }
]
```
#### Failure
Status:404

## GET
<!---
    * Lấy một accountInfo
    * GET
    * Note: Use this API for get one accountinfo by using uname
-->
link: http://localhost:8080/api/accountinfos/khangtest1

### Request

### Response
#### Successes
Status:200
```
{
    "uname": "khangtest2",
    "disname": "khangtest2",
    "uaddress": "daylaaddresss",
    "phonenum": 919910266
}
```
#### Failure
Status: 404

## DELETE
<!---
    * Xóa một accountInfo
    * DELETE
    * Using for admin to delete by using uname
-->

link: http://localhost:8080/api/accountinfos/khangtest1
### Request

### Response
#### Successes:
Status:200
Xóa accountInfo thành công
#### Failure:
Status:404




# API: GOrderAddOnUserRest
<!---
    * Use this API for managing order&addon
-->
link: http://localhost:8080/api/gorderaddon

## POST
<!---
    * POST
    * thêm gorderaddon vào database
    * Note: this method incomplete, you just can add each order & addon
-->
### Request
```
{

    "gorderId": 2,
    "addonId": 2,
    "content":"day la lan thu dau hai"
    
}
```

### Response
#### Successes
Status: 201
Lưu thành công gOrderAddOn

#### Failure
Status: 404

## PUT
<!---
    * UPDATE
    * chỉnh sửa gorderaddon
    * Use can update gorderaddon by using cid of this gOrderAddOns table
    * Note: 2 in below link is cid of gOrderAddOns table
    * gOderId can get by using 2 API below
-->
link: http://localhost:8080/api/gorderaddon/2
### Request
```
{
    "gorderId": 15,
    "addonId": 3,
    "content":"Muon sua thanh addon thu ba"
}
```
### Response
#### Successes
Status: 200
GOrderAddOn update thành công

#### Failure
Status: 400

## GET
<!---
    * GET
    * Lấy tất cả gOrderAddOn
    * Get all gorderaddon in database
    * 
-->
link: http://localhost:8080/api/gorderaddon
### Request

### Response
#### Successes
```
[
    {
        "cid": 1,
        "gorderId": null,
        "addonId": 2,
        "content": "sua cai content khac",
        "aname": null,
        "adescription": null,
        "price": null
    },
    {
        "cid": 2,
        "gorderId": null,
        "addonId": 2,
        "content": "sua cai content khac",
        "aname": null,
        "adescription": null,
        "price": null
    },
    {
        "cid": 3,
        "gorderId": null,
        "addonId": 2,
        "content": "sua cai content khac",
        "aname": null,
        "adescription": null,
        "price": null
    },
    {
        "cid": 5,
        "gorderId": 2,
        "addonId": 2,
        "content": "day la lan thu dau hai",
        "aname": null,
        "adescription": null,
        "price": null
    }
]
```
#### Failure
Status: 404

## GET

<!---
    * GET
    * Lấy một gOrderAddOn
    * Get gorderaddon by using gorderid
    * Note: 15 in below link is gorderid
    *  
-->
link: http://localhost:8080/api/gorderaddon/15
### Request

### Response
#### Successes
Status:200
```
[
    {
        "cid": 17,
        "gorderId": 15,
        "addonId": 1,
        "content": "cái nơ màu xanh",
        "aname": "test1",
        "adescription": "dung de test",
        "price": 10000
    },
    {
        "cid": 18,
        "gorderId": 15,
        "addonId": 5,
        "content": "Muon sua thanh addon thu ba",
        "aname": "fakeAddOn1",
        "adescription": "Đây là addOnFake",
        "price": 30000
    }
]
```
#### Failure
Status: 404

## DELETE
<!---
    * DELETE
    * Xóa một gOrderAddOn
    * You can delete gOrderAddOn by using cid of it
    * Note: 2 in below link is cid of gOrderAddOn id
-->

link: http://localhost:8080/api/gorderaddon/2
### Request

### Response
#### Successes
Status: 200
Ğã xóa thành công addon

#### Failure
Status: 404



# Mô tả phiên bản 2.0

# API: Order

## POST
<!---
    * Using this API for add one order into database
    * You can add so many addon and get content with it
    * Note: it send a mail so you can wait a minute
    * Note: you can choose your date you want us to delivery
-->
link: http://localhost:8080/api/user/order

### Request
```
{
    "uname" : "khangtest1",
    "giftpackId": 1,
    "receiveAddress" : "123/dada/tp.HCM",
    "phoneNumber" : 919910266,
    "dateArrive" : "23-05-2021",
    "greetingCardContent" : "Happy birthday",
    "addonId": [1,2],
    "content" : ["cái nơ màu xanh", "cái thiệp màu hồng"]
}
```

### Response

#### Success

Status: 200
Đã tạo đơn hàng thành công
Location: /api/user/order/id/16 
#### Failure

Status: 404

## GET
<!---
    * Using this API to getting order by orderid
    * Use can get orderid by watch location in header or it send with a mail for you
    * Note: 16 is orderid
-->
link: http://localhost:8080/api/user/order/id/16

#### Request

#### Response
```
{
    "cid": 16,
    "uname": "khangtest1",
    "giftpackId": 1,
    "receiveAddress": "123/dada/tp.HCM",
    "phoneNumber": 919910266,
    "dateOrder": "17-05-2021",
    "dateArrive": "23-05-2021",
    "greetingCardContent": "Happy birthday",
    "addonId": [
        1,
        2
    ],
    "content": [
        "cái nơ màu xanh",
        "cái thiệp màu hồng"
    ],
    "status": "Đang xử lý",
    "cost": 140000
}
```

## GET

<!---
    * Using API to getting order by using uname
    * this return a list of order
    * 
-->
link: http://localhost:8080/api/user/order/uname/khangtest1

### Request

### Response

#### Success

Status: 200
```
[
    {
        "cid": 1,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": [
            1
        ],
        "content": [
            "cái nơ màu xanh"
        ],
        "status": "Đang chờ xử lý",
        "cost": 110000
    },
    {
        "cid": 4,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": null,
        "content": null,
        "status": "Đang chờ xử lý",
        "cost": 100000
    },
    {
        "cid": 12,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": [
            1,
            2
        ],
        "content": [
            "cái nơ màu xanh",
            "cai thiep mau hong"
        ],
        "status": "Đang chờ xử lý",
        "cost": 140000
    },
    {
        "cid": 13,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": [
            2
        ],
        "content": [
            "cai thiep mau hong"
        ],
        "status": "Đang chờ xử lý",
        "cost": 130000
    },
    {
        "cid": 14,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": [
            1,
            2
        ],
        "content": [
            "cái nơ màu xanh",
            "cai thiep mau hong"
        ],
        "status": "Đang chờ xử lý",
        "cost": 140000
    }
]
```

#### Failure
Status: 404

## GET
<!---
    * Get all orders
    * Using API to get all orders from database
    * this return list of orderUsermodel
    * 
-->

link: http://localhost:8080/api/user/order

### Request

### Response
Status: 200
```
[
    {
        "cid": 1,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": [
            1
        ],
        "content": [
            "cái nơ màu xanh"
        ],
        "status": "Đang chờ xử lý",
        "cost": 110000
    },
    {
        "cid": 4,
        "uname": "khangtest1",
        "giftpackId": 1,
        "receiveAddress": "123/dada/tp.HCM",
        "phoneNumber": 919910266,
        "dateOrder": "17-05-2021",
        "dateArrive": "23-05-2021",
        "greetingCardContent": "Happy birthday",
        "addonId": null,
        "content": null,
        "status": "Đang chờ xử lý",
        "cost": 100000
    }
]
```
### API OrdeProcess

## GET
<!--
Get all OrderProcess from database
-->
link:http://localhost:8080/api/delivery
## Request:
## Response:
Status.200
[
    {
        "gorderId": 5,
        "pstate": "Canceled",
        "pdelivered": 1,
        "pcanceled": 1
    },
    {
        "gorderId": 8,
        "pstate": "done",
        "pdelivered": 1,
        "pcanceled": 0
    },
    {
        "gorderId": 10,
        "pstate": "cancel",
        "pdelivered": 0,
        "pcanceled": 1
    }
]
## Fail:
 Status.400
## GET
<!--
Get all OrderProcess deliveried
-->
link:http://localhost:8080/api/delivery/Listdeliveried
## Request
## Response
Status.200
[
    {
        "gorderId": 5,
        "pstate": "Canceled",
        "pdelivered": 1,
        "pcanceled": 1
    },
    {
        "gorderId": 8,
        "pstate": "done",
        "pdelivered": 1,
        "pcanceled": 0
    }
]
## Fail:
 Status.400

## POST
<!--
Add orderProcess.
You can set state of order such as waiting, done.
Addition,you can set pdeliveried and pcanceled by 0. 
-->
link:http://localhost:8080/api/delivery/addOrderProcess
## Request
    {
        "gorderId": 5,
        "pstate": "process",
        "pdelivered": 0,
        "pcanceled": 0
    }
## Response
Status.200
Add success

## PUT
<!--
Update orderProcess.
You can change state of order such as waiting, done.
Addition,you can set pdeliveried and pcanceled by 0 or 1.
Mention:end of link is orderProcess id. 
-->
link:http://localhost:8080/api/delivery/update/5
## Request
    {
        "gorderId": 5,
        "pstate": "done",
        "pdelivered": 1,
        "pcanceled": 0
    }
## Response
Status.200
Update success


## DELETE
<!--
Delete using orderID in database. 
Change number in last link to chose orderProcess to delete.
-->
link:http://localhost:8080/api/delivery/delete/5
## Request

## Response
Status.200
Delete success


## API GiftPackComments

## GET
<!--
Get all list Comment in database comments.
-->
link:http://localhost:8080/comments/listComments
## Request

# Response
## Success
Status.200

[
    {
        "cid": 4,
        "giftpackId": 2,
        "uname": "catuser",
        "content": "Fail"
    }
]
## Fail:
 Status.400

## GET
<!--
Get all list Comment by Uname.
Last link you need to change uname to find.
-->
link:http://localhost:8080/comments/getCommentsByUname/catuser
## Request

# Response
## Success
Status.200

[
    {
        "cid": 4,
        "giftpackId": 2,
        "uname": "catuser",
        "content": "Fail"
    }
]
## Fail:
 Status.400
## GET
<!--
Get Comment by CommentID.
Note:you change number commentID in last link
 -->
 link: http://localhost:8080/comments/getCommentsBygiftID/1
 ## Request

 ## Response
 ## Success
 Status.200
 {
    "cid": 10,
    "giftpackId": 1,
    "uname": "catuser",
    "content": "Failed"
}

## Fail:
 Status.400
## POST
<!--
Insert comment.
 -->
 ## Request
 {
    "cid": 10,
    "giftpackId": 1,
    "uname": "catuser",
    "content": "Failed"
}

## Response
## Success
Add Comment sucess
## Fail:
 Status.400
## PUT
<!--
Update comment.
 -->
 ## Request
     {
        "giftpackId": 2,
        "uname": "catuser",
        "content": "Fail"
    }
 ## Response
 Status.200
 Update success
## Fail:
 Status.400
 Update unsuccess

## DELETE
<!--
Delete comment by commentID.
Change last number in link to chose comment to delete.
 -->

 link:http://localhost:8080/comments/delete/10
 ## Request
 ## Response

 ## Sucess:
 Status.200
 Delete success
 ## Fail:
 Status.400
Delete unsuccess


## POST
link:http://localhost:8080/comments/resolveComment
## Request:
{
    "email":"18110092@student.hcmute.edu.vn",
    "content":"Gift very good",
    "commentResolve":"Thanks you for buy Gift",
    "giftpackId":2

}
## Response

## Success
Status.200
Mail sent.
## Fail
Mail unsent

# API: Items

Link: http://localhost:8080/api/items

## GET

