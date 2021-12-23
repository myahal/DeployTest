# DeployTest
Deploy のテストをするためのソースコード

バックエンドはSpring、フロントエンドはReactで作ってある
DBはPostgreSQLを使用

```
createdb playerdb
createdb playerdb-test
```

## 起動
接続先DB情報はprofileで切り替える。
`main/resources/application-xxx.properties`に接続情報を記載
起動時にspring.profiles.activeで環境を指定する

ローカルでの起動
```
cd front
yarn build
cd ../backend
 ./gradlew bootRun --args='--spring.profiles.active=local'

 access localhost:8080
```
起動すると自動でスキーマと初期データが投入される（２件）

`GET http://localhost:8080/api/players`  のみ有効
