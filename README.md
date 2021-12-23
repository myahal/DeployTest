# DeployTest
Deploy のテストをするためのソースコード

バックエンドはSpring、フロントエンドはReactで作ってある
DBはPostgreSQLを使用

```
createdb playerdb
createdb playerdb-test
```

## バックエンドの起動
接続先DB情報はprofileで切り替える。
`main/resources/application-xxx.properties`に接続情報を記載の上

```
 ./gradlew bootRun --args='--spring.profiles.active=xxx'
```
か
```
./gradlew build
java  -Dspring.profiles.active=xxx -jar ./build/libs/backend-0.0.1-SNAPSHOT.jar
```
で実行。

IntelliJで実行する場合はRun/Debug ConfigurationsのEnvironemt variablesに `SPRING_PROFILES_ACTIVE=xxx`を設定する


起動すると自動でスキーマと初期データが投入される（２件）

`GET http://localhost:8080/api/players`  のみ有効

# フロントエンドの起動
バックエンドサーバを環境変数で指定して起動する。

`REACT_APP_SERVER_NAME=localhost yarn start`