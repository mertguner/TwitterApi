# Twitter Api Notlarım

**Postman** ve **Java** ile Twitter api kullanımı sırasında yaşadığım bazı zorlukları ve yaptığım geliştirmeleri dederlemek istedim.

Twitter apisini kullanabilmek için öncelikle onaylanmış bir developer hesabınız olmalı. 
## Twitter Developer Ayarları
 - [Twitter Developer](https://developer.twitter.com/)'a twitter hesabınız ile login olmalısınız.
- Yeni bir uygulama kaydetmek için App sekmesine girip.
![03](https://github.com/mertguner/TwitterApi/raw/master/Images/03%20-%20Twitter%20Api%20Add.PNG)
- **Create an App** tuşuna basarak Yeni bir uygulama yaratılmalı.
![04](https://github.com/mertguner/TwitterApi/raw/master/Images/04%20-%20Create%20an%20App.PNG)
  - Yeni bir uygulama yaratırken ***(required)*** yazan bütün alanların doldurulması özellikle önemli.
  - Güvenlik için **Enable Sign in with Twitter** işaretlenir ve **Callback URLs** linkleri girlmelidir. Kullandığımız uygulamada twitter api tanımı yapılan endpoint ile webhook tanımı yapıldı.
![05](https://github.com/mertguner/TwitterApi/raw/master/Images/05%20-%20CallbackUrl.PNG)
- 1 gün içerisinde Twitter'dan mail ile ya ekstra bilgi istenir yada developer hesabınız onaylanır.
- Sonraki adım uygulamamızın yetki ayarları. **Permissions** ben full yetki vererek "*Read, write, and Direct Messages*" seçtim. 
![06](https://github.com/mertguner/TwitterApi/raw/master/Images/06%20-%20Permission.PNG)
-Tokenlarımızı alarak artık Postman üzerinden kullanmaya başlayabiliriz. Bu aşamada dikkat edilmesi gereken nokta Access tokenlar bir kere gösterilir. Kenara not almayı unutmayın.
![07](https://github.com/mertguner/TwitterApi/raw/master/Images/07%20-%20Token.PNG)
- Webhook kaydedebilmek için bir environment yaratmak gerekiyor. Bunun için **Dev Environment**'a girip. ***Account Activity API*** 'ye sandbox tanımlamak ve bir Environment Adı vermemiz gerekiyor. Webhook kaydederken bu *Environment Name* işimize yarayacak.
![03](https://github.com/mertguner/TwitterApi/raw/master/Images/03%20-%20Twitter%20Api%20Add.PNG)
  - ben bütün uygulamalara aynı ismi verdim. Sandbox bedava kullanım için yapıldığından 1 webhook'a izin veriyor. O yüzden hepsini aynı isimle verdim.
![08](https://github.com/mertguner/TwitterApi/raw/master/Images/08%20-%20Dev%20Environments.PNG)

## Postman Ayarları
- Api tokenlarını yönetmek için Postman üzerinden bir environment tanımı yaptım. 
  - [Download Postman Environments](https://raw.githubusercontent.com/mertguner/TwitterApi/master/Postman/Twitter%20API.postman_environment.json)
 ![01](https://github.com/mertguner/TwitterApi/raw/master/Images/01%20-%20Add%20Environment.PNG)
- İhtiyacım olan Api referanslarını da aşağıdaki collection'da topladım.
  - [Download Twitter Postman Collection](https://raw.githubusercontent.com/mertguner/TwitterApi/master/Postman/TwitterApi.postman_collection.json)
 ![02](https://github.com/mertguner/TwitterApi/raw/master/Images/02%20-%20Twitter%20Apis.PNG)
 
 ## Twitter API
- Tweet Göndermek için 
  - Servis tipi = **POST** 
  - URL Parametre = **status**
> https://api.twitter.com/1.1/statuses/update.json?status=Hello

- Tweet Silmek için
  - Servis tipi = POST 
> https://api.twitter.com/1.1/statuses/destroy/1216630397913718784.json

- Timeline'ınızı Almak için (Tweitter'a girdiğinizde ana sayfada karşınıza çıkan başkasının yolladığı tweetleri görmek için)
  - Servis tipi = **GET** 
> https://api.twitter.com/1.1/statuses/home_timeline.json

- DM Göndermek için
  - Servis tipi = POST 
  - Body Örneği :
    - **recipient_id** parametresi DM gönderilmek istenen user'ın ID'si
    - **text** ise gönderilecek mesaj içeriği
  ```json
  {
    "event": {
      "type": "message_create",
      "message_create": {
        "target": {
          "recipient_id": "78054600"
        },
        "message_data": {
          "text": "Api ile DM Başlatma Testi"
        }
      }
    }
  }
  ```
  - Content-Type : **application/json**
> https://api.twitter.com/1.1/direct_messages/events/new.json

**Temel Apiler bunlar eğerki biri beni etiketleyerek tweet attığı an haberim olsun. Biri bana DM'den yazdığım an haberim olsun derseniz Webhook burda devreye giriyor.**

### Webhook Kullanımı
- Twitter sizin verdiğiniz bir link'e POST isteği atarak sizi anlık bilgiler gönderir.
- İlk olarak Webhook'unuzu kaydetmeden önde **Twitter** verdiğiniz link'e **GET** isteği ile bir token yollar ve sizden o token'ı tekrar şifreleyerek ResponseToken üretmenizi bekler. Eğer bunu yapmazsanız kaydetmek istedğinizide sürekli hata alırsınız.

## Java Örnekleri
 
- Tweet, Direct message atma veya silme, Timeline üzerinde ki tweetleri görme veya hashtag ile arama yapmak için gerekli olan istekleri yönetmek için kullanılan **Twitter API** standart rest servis mantığını bilen biri için kullanması çok zor olmayan bir sistem. Benim twitter api kullanırken en çok zorlandığım kısım webhook kullanmak oldu. Webhook için twitter'ın birkaç tane özel isteği var.
 