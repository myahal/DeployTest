# DeployTest
Deploy のテストをするためのソースコード

バックエンドはSpring、フロントエンドはReactで作ってある
DBはPostgreSQLを使用

```
createdb playerdb -O <dbuser>
createdb playerdb-test -O <dbuser>
```

## テーブルの用意

```
% psql -U <dbuser> playerdb

playerdb=> \dt
Did not find any relations.
playerdb=> create table if not exists players (id serial primary key, first_name text, last_name text);
CREATE TABLE
playerdb=> insert into players (first_name, last_name) values ('taro', 'yamada');
insert into players (first_name, last_name) values ('jiro', 'sato');
INSERT 0 1
INSERT 0 1
playerdb=> \q
```

## 起動
DB接続情報は環境変数から取得する

###ローカルでの起動

```
cd front
yarn build
cd ../backend
 ./gradlew build

 DBHOST=<dbhost> DBUSER=<dbuser> DBPASSWORD=<dbpass> java -jar -Dspring.profiles.active=local build/libs/backend-0.0.1-SNAPSHOT.jar
```

`http://localhost:8080` で一覧が出ればOK

バックエンドは`GET http://localhost:8080/api/players`  のみ有効


### Dockerでの起動
```
docker-compose up -d
```

DB接続情報はdocker/variables.envに設定する。
dockerディレクトリの構成は以下の通り

```
.
├── Dockerfile
├── db
│   ├── data
│   └── initdb
│       ├── 1-create-players.sql
│       ├── 2-insert-players.sql
│       └── 3-user.sql
└── variables.env
```
