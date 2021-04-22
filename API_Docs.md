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