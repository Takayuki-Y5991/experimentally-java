# experimentally-java

---

## Running the application

Docker-compose.yml内に起動に必要となるコンテナイメージを記載しています。

- アプリケーションの設定情報：[Settings](src/main/resources/application-prod.yaml)
- DockerComposeファイル: [Docker](./docker-compose.yaml)

```shell
docker-compose up --build
```

## Implementing

- SwaggerUI
- 認証機能(RedisとSpringSecurityを利用)
- DDL自動生成(Local環境のみ有効)
- mybatis dynamic sql導入
- MapStructカスタム
- Passwordハッシュ化

## How to Use

1. ユーザを作成してください。

```
[POST]http://localhost:9000/api/v1/member
```

2. APIリソースを利用するためのトークンを生成してください。
   ※トークンの有効期限は2時間で設定しています。

```
[POST]http://localhost:9000/api/v1/auth
```

3. 各APIを実行できます。実行の際は、headersにトークンを付与してください。

```
Header    
 - Authorization: Bearer [トークン]
```

※ [トークン]を記載されている場所に2で発行したトークンを転記することを忘れずに。

APIの確認をGUIで行う場合は、下記を参照ください。  
[SwaggerUI](http://localhost:9000/swagger-ui/index.html#/)