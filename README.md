# TodoList

## 概要
共有Todoリストです。

Java + Springbootの学習のために作りました。

![TodoList](https://user-images.githubusercontent.com/113958600/231665721-55e7a593-c516-4458-b858-0f75e07c60fc.png)

## 実装環境

言語：Java

フレームワーク：Springboot

テンプレートエンジン：Thymeleaf

CSSフレームワーク：Bootstrap

データベース：MySQL

## 機能

### ログイン／ログアウト機能

<ul>
  <li>未ログイン時はログインページを表示します。</li>
  <li>データベースを検索し一致するユーザーがいれば、ログイン処理を行い作業一覧ページを表示します。</li>
  <li>ログインページ以外の各ページにログアウトボタンを表示します。</li>
  <li>未ログインの場合、必ずログインページを表示します。</li>
</ul>

![TodoListログイン](https://user-images.githubusercontent.com/113958600/232177287-ace2ac56-b441-4c5a-82b1-0cdc25a4ee86.png)

### 一覧表示機能

<ul>
  <li>Todoリストに登録された作業一覧を表示します。</li>
  <li>未削除の項目を、期限日の古いものから表示します。</li>
  <li>期限日が過ぎている項目は赤色で表示します。</li>
  <li>奇数行と偶数行を色分けし、わかりやすく表示します。</li>
</ul>

![TodoList一覧](https://user-images.githubusercontent.com/113958600/232177306-251be1ba-43f9-4279-8733-d592afddeb64.png)

### 検索機能

<ul>
  <li>検索ワードが「項目名」「担当者」で一致した項目を表示します。</li>
</ul>

![TodoList検索](https://user-images.githubusercontent.com/113958600/232177315-02f0c8b7-0ab6-4772-bf04-ebd4a4b57be1.png)

### 新規登録機能

<ul>
  <li>新規作業の登録を行います。</li>
</ul>

![TodoList新規登録](https://user-images.githubusercontent.com/113958600/232177322-df16fc92-c081-49ff-a303-45ad20ef82fd.png)

以下のバリデーションを行います。

<ul>
  <li>項目名が空白でないこと。</li>
  <li>項目名が100文字以内であること</li>
  <li>期限日がnullでないこと。</li>
  <li>期限日がyyyy-MM-dd形式であること。</li>
</ul>

![TodoListバリデーション](https://user-images.githubusercontent.com/113958600/232177500-4b3a7a01-c631-467a-9127-898401ea40f0.png)

### 更新機能

<ul>
  <li>該当する作業項目をデータベースから検索し、登録内容の更新を行います。</li>
  <li>入力値のバリデーションを行いｍす。</li>
</ul>

![TodoList更新](https://user-images.githubusercontent.com/113958600/232177330-07a5fc51-35ac-4550-9f2b-afe739169143.png)

### 削除機能

<ul>
  <li>該当する作業項目をデータベースから検索し、登録内容の削除を行います。</li>
  <li>削除は、削除フラグをON（論理削除）にし、データベースからの削除は行いません。</li>
</ul>

![TodoList削除](https://user-images.githubusercontent.com/113958600/232177333-24847c0b-4947-43cd-ab26-d311d92235ad.png)

