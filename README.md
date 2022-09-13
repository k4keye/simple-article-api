# simple-article-api

## Function
- jwt
- REST api
- TEST code

## api
| 분류 | 기능 | 메소드 | URL | 구현 |
| --- | --- | --- | --- | --- |
| Login | Login | GET | /login | 완료 |
|  | join | POST | /login/join | 완료 |
|  |  |  |  |  |
| member | 전체 조회 | GET | /member | 완료 |
|  | 특정 member 조회 | GET | /member/{id} | 완료 |
|  | 수정 | PATCH | /member/{id} | 완료 |
|  | 비활성화 | DELETE | /member/{id} | 완료 |
|  |  |  |  |  |
| article | 추가 | POST | /atvicle | 완료 |
|  | 전체 조회 | GET | /atvicle | 완료 |
|  | 특정 article 조회 | GET | /atvicle/{id} | 완료 |
|  | 수정 또는 추가 | UPDATE | /atvicle/{id} |  |
|  | 수정 | PATCH | /atvicle/{id} |  |
|  | 비활성화 | DELETE | /atvicle/{id} |  |
|  |  |  |  |  |

## Extend
- docker
- docker-compose
- lombok
- jjwt
- p6spy
- swagger


## setup
```
docker-compose up
```

## ETC
http://localhost:8081/swagger-ui/index.html#/
