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
  <li>正常にログインできた時は、登録された作業一覧ページを表示します。</li>
  <li>ログインページ以外の各ページにログアウトボタンを表示します。</li>
</ul>

![TodoListログイン](https://user-images.githubusercontent.com/113958600/231671890-a535f0fd-93fc-4a8a-b2a7-d55cf1ab5dfc.png)

### 一覧表示機能

<ul>
  <li>Todoリストに登録された作業一覧を表示します。</li>
  <li>未削除の項目を、期限日の古いものから表示します。</li>
  <li>期限日が過ぎている項目は目立つ色で表示します。</li>
</ul>

### 検索機能

<ul>
  <li>検索ワードが「項目名」「担当者」で一致した項目を表示します。</li>
</ul>

### 新規登録機能

以下のバリデーションを行います。

<ul>
  <li>項目名が空白でないこと。</li>
  <li>項目名が100文字以内であること</li>
  <li>期限日がnullでないこと。</li>
  <li>期限日がyyyy-MM-dd形式であること。</li>
</ul>

![TodoList新規登録](https://user-images.githubusercontent.com/113958600/231667401-31961e22-3e4e-40f7-8fa0-d51ffeac20fb.png)

### 更新機能

![TodoList更新](https://user-images.githubusercontent.com/113958600/231669257-19b7e134-da3b-420b-864b-eeff0b75e5c5.png)

### 削除機能

![TodoList削除](https://user-images.githubusercontent.com/113958600/231669035-05e11f40-7555-479c-a70a-0b26c0092f4a.png)


