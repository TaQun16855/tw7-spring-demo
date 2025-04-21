# Spring Demo Project

This public repository hosts a simple Spring Boot demo application that our team is using to share code samples, configurations, and best practices internally.  

# 事前条件
* PostgreSQLのインストール : [PostgreSQLのインストール](https://www.postgresql.org/download/windows/)
  * dockerを利用するなら、PostgreSQLのインストールは不要
  
* Dockerを利用する場合(慣れると楽)
  * Docker Desktopのインストール後、./app/docker-compose.ymlを利用してコンテナを起動
    > docker compose up -d \
  * アプリケーションを実行する方法
    > docker exec -it springboot bash \
    > コンテナ> ./mvnw spring-boot:run -X 
  * Spring Bootのテストを実行する方法
    > コンテナ> ./mvnw test -X  


# Eclipseへインポート
* リポジトリを*zip*でインストールするか*git clone*でインストール

## zipを利用する場合
* ダウンロードした後、展開しておく

## git cloneを利用する場合
> git clone https://github.com/TaQun16855/tw7-spring-demo.git 

## Eclipseのインポート方法
* パッケージ -> インポート -> maven -> 既存のmavenプロジェクトをインポート -> 展開後のフォルダから"./app/demo"を選ぶ(pom.xmlと同じ階層)


# エディタなしで実行する方法(windows)
* ./app/start_script.batをダブルクリックすると起動してくれる