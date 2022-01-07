# DeployTest
Deploy のテストをするためのソースコード

バックエンドはSpring、フロントエンドはReactで作ってある


## 起動

###ローカルでの起動

```
cd front
yarn build
cd ../backend
 ./gradlew build

java -jar -Dspring.profiles.active=local build/libs/backend-0.0.1-SNAPSHOT.jar
```

`http://localhost:8080` で一覧が出ればOK

バックエンドは`GET http://localhost:8080/api/players`  のみ有効


### Dockerでの起動
```
docker-compose up -d
```

