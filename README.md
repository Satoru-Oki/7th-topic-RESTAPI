#### 概要
REST-APIを実装するにあたってFieldに誕生日、GETメソッドでクエリ文字列を参照、Validationを設定した。
#### 動作確認
GET（全件取得・クエリ文字列からIDで検索）   
<img width="271" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/d304e2c9-039a-4b31-8a1c-180940ff5456"> <img width="293" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/2816c53d-909c-4996-a3bf-5490cf64469c">  

POST・PATCH・DELETE処理   
<img width="270" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/d36642ca-dd26-4763-977d-b29d5368d144">
<img width="249" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/dc5a220a-f5d4-475f-87c9-81460217a995">
<img width="248" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/8a4fafc6-0359-401d-8f6e-f26c282a1dc4">  

Validation(GET 3文字・6文字だがID外）  
<img width="248" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/cf31b88c-6c64-45c4-bbe4-02fb031b68eb">
<img width="251" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/49d115be-703f-4794-afa4-61c858d70b9d">

Validation(POST nameが空文字・classNameが空白）  
<img width="279" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/5fa141ac-c283-43ca-a98e-54af501f6c62">
<img width="271" alt="image" src="https://github.com/Satoru-Oki/7th-topic-RESTAPI/assets/143796169/ac692e53-0f94-4591-99b8-38a84e33d7fd">
