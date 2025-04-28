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

 | 💼 | Kitap Yönetim Sistemi (BookManagement) - GitHub Proje Detayları  |
| ------------ | ------------ |
| 1. Kullanıcı Kaydı (User Registration)  | Açıklama: Kullanıcılar sisteme kaydolmak için gerekli bilgileri (ad, soyad, e-posta, şifre) girer. Şifreler güvenli bir şekilde saklanır (örn. bcrypt ile şifreleme).

Gerekli Özellikler:

Kullanıcı adı, e-posta, şifre gibi alanlar zorunludur.

Şifreler hash'lenerek veritabanına kaydedilir.

E-posta doğrulama işlemi (opsiyonel).

E-posta adresi ve kullanıcı adı gibi bilgilerin benzersiz olması sağlanır.

Kayıt başarılı olduktan sonra kullanıcıya hoş geldiniz mesajı gösterilir.  |

 | 🔐 | Kullanıcı Girişi User Login  |
| ------------ | ------------ |
|2. Kullanıcı Girişi (User Login) |Açıklama: Kullanıcılar sisteme giriş yapmak için e-posta ve şifrelerini kullanır. Giriş başarılı olursa, kullanıcıya bir erişim token'ı (JWT - JSON Web Token) verilir.

Gerekli Özellikler:

Giriş yapan kullanıcıya bir JWT token'ı verilir.

Hatalı giriş denemesi durumunda kullanıcıya hata mesajı döndürülür.

Oturum açma süresi belirlenir (token süresi).

Kullanıcı girişi başarılı olduğunda ana sayfaya yönlendirilir.|

| ❌ |  Kullanıcı Olmayan Kişiler İçin Hata Mesajı  |
| ------------ | ------------ |
|3.Açıklama: Sistemde kaydı olmayan bir kullanıcı giriş yapmaya çalıştığında, kullanıcıya "Hesap bulunamadı" gibi bir hata mesajı gösterilir.

Gerekli Özellikler:

Kayıtsız kullanıcılar için uygun hata mesajı (örneğin, "Kullanıcı bulunamadı" veya "Yanlış e-posta/şifre").

Sistemdeki kullanıcılar veritabanı üzerinden kontrol edilir.|

| ➕ |  Kitap Ekleme (Add Book) |
| ------------ | ------------ |
|4. Kitap Ekleme (Add Book)
Açıklama: Sisteme yeni bir kitap eklemek isteyen kullanıcı, kitap adı, yazar, açıklama gibi bilgileri girer. Kitap, veritabanına kaydedilir.

Gerekli Özellikler:

Kullanıcılar sadece kendi ekledikleri kitapları ekleyebilir.

Kitap bilgileri (ad, yazar, açıklama, kategori, vb.) zorunlu alanlar.

Kitap ekleme işlemi başarılı olduğunda, kullanıcıya onay mesajı gösterilir.|

| 🗑️ |Kitap Silme (Delete Book)|
| ------------ | ------------ |
|5. Kitap Silme (Delete Book)
Açıklama: Kullanıcılar sadece kendi ekledikleri kitapları silebilir. Diğer kullanıcıların kitaplarına müdahale edemezler.

Gerekli Özellikler:

Kitap, yalnızca kitap sahibinin izni ile silinebilir.

Kitap silme işlemi sonrası kullanıcıya onay mesajı gösterilir.

Kitap silme işlemi için uygun API endpoint'leri sağlanır.|

| 🔄 |Kitap Güncelleme (Update Book)|
| ------------ | ------------ |
|6. Kitap Güncelleme (Update Book)
Açıklama: Kullanıcılar sadece kendi ekledikleri kitapları güncelleyebilir. Kitap adı, yazar, açıklama gibi bilgiler güncellenebilir.

Gerekli Özellikler:

Güncelleme işlemi sadece kitabın sahibi tarafından yapılabilir.

Kitap bilgileri (ad, yazar, açıklama, kategori) güncellenebilir.

Kitap güncellenmesi sonrası kullanıcıya onay mesajı gösterilir.|

| 📝 |Kitap Listeleme (List Books)|
| ------------ | ------------ |
|7. Kitap Listeleme (List Books)
Açıklama: Sistemdeki tüm kitaplar, kullanıcılar tarafından listelenebilir.

Gerekli Özellikler:

Kullanıcılar, tüm kitapları görebilir ancak sadece kendi kitaplarını düzenleyebilir.

Listeleme filtreleme ve sıralama seçenekleri (örneğin, kitap ismine göre arama).

Kullanıcıya her kitap için ayrıntılı bilgi sağlanabilir (yazar, açıklama, kategori, ekleyen kullanıcı vb.).

| 🔎 |Kitap Arama (Search Books)|
| ------------ | ------------ |
|8. Kitap Arama (Search Books)
Açıklama: Kullanıcılar, kitapları başlık, yazar veya kategori gibi filtrelerle arayabilirler.

Gerekli Özellikler:

Arama kriterlerine göre kitaplar filtrelenebilir (örneğin, kitap adı, yazar adı).

Kullanıcılar arama sonuçlarını sıralayabilir ve filtreleyebilir.

Arama sonuçları hızlı ve etkili bir şekilde döndürülür.|
 
 
 


 
 

