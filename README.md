# 📚 BookManagement -
# Book Management !

**BookManagement**, Kullanıcı Kaydı ile ile birlikte, Kullanıcıların Giriş Yapabildiği Kaydı Olmayan Kullanıcılarda 
Hata Mesajı Dönderen, Kitap Ekleme,Silme,Güncelleme,Listeleme yapabildiğimiz,
Kullanıcıların sadece kendi ekledikleri Kitaplar üzerinden işlemler Silme Güncelleme yapabildiği Arama ve Listeleme
Tüm Kullanıcıların erişim sağladığı Kitap Uygulaması.

## 🚀 Özellikler

- 🔐​🗝️ Kullanıcı Kayıt ve Giriş Sistemi (Session tabanlı)
- 📘➕​➖​💱​Kitap Ekleme, Silme,Güncelleme
- 🎩​🔍 Başlığa Göre Kitap Arama
- 📚​📖 Sayfalama (Pageble) desteği
- 🧑‍💻​🗝️ Kullanıcıların Kayıtla birikte işlem gerçekleştirir.

## 🛠️ Kullanılan Teknolojiler
- ** 🍃Spring Boot**
- ** ☘️Spring Data JPA (H2 veritabanı ile)**
- ** 👮🔑Security (Session Tabanlı)**
- ** ✅Validaitons**
- ** Ⓜ️Maven**
- ** 📬Postman**
- # Jpa-Query-Methodlar

 | ⚠️ | Kitap Yönetim Sistemi (BookManagement) - GitHub Proje Detayları  |
| ------------ | ------------ |
| 1. Kullanıcı Kaydı (User Registration)  | Açıklama: Kullanıcılar sisteme kaydolmak için gerekli bilgileri (ad, soyad, e-posta, şifre) girer. Şifreler güvenli bir şekilde saklanır (örn. bcrypt ile şifreleme).

Gerekli Özellikler:

Kullanıcı adı, e-posta, şifre gibi alanlar zorunludur.

Şifreler hash'lenerek veritabanına kaydedilir.

E-posta doğrulama işlemi (opsiyonel).

E-posta adresi ve kullanıcı adı gibi bilgilerin benzersiz olması sağlanır.

Kayıt başarılı olduktan sonra kullanıcıya hoş geldiniz mesajı gösterilir.  |

| ------------ | ------------ |
|2. Kullanıcı Girişi (User Login) |Açıklama: Kullanıcılar sisteme giriş yapmak için e-posta ve şifrelerini kullanır. Giriş başarılı olursa, kullanıcıya bir erişim token'ı (JWT - JSON Web Token) verilir.

Gerekli Özellikler:

Giriş yapan kullanıcıya bir JWT token'ı verilir.

Hatalı giriş denemesi durumunda kullanıcıya hata mesajı döndürülür.

Oturum açma süresi belirlenir (token süresi).

Kullanıcı girişi başarılı olduğunda ana sayfaya yönlendirilir.|
 


 
 

