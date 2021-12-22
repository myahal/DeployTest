# DeployTest
Deploy のテストをするためのソースコード

バックエンドはSpring、フロントエンドはReactで作ってある
DBはPostgreSQLを使用

createdb playerdb
createdb playerdb-test

## バックエンドの起動
環境変数としてDB_HOST, DB_PORT, DB_USERが必要


起動すると自動でスキーマと初期データが投入される（２件）

`GET http://localhost:8080/api/players`  のみ有効

# フロントエンドの起動
バックエンドサーバを環境変数で指定して起動する。

`REACT_APP_SERVER_NAME=localhost yarn start`