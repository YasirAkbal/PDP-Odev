/**
*
* @author Ahmet Yasir Akbal
* @since 25.03.2018
* <p>
* Rastgele üretilen kisilerin özelliklerini barından sınıf
* </p>
*/

package RASTGELEKISIURET;


public class Kisi {
    
    KimlikNo kimlikNo = new KimlikNo(); //Kisi nesnesi üretildiğinde yeni bir KimlikNo nesnesi üret
    Telefon telefon = new Telefon(); //Telefon nesnesi üretildiğinde yeni bir Telefon nesnesi üret
    private String isim; 
    private String soyIsim;
    private byte yas;
    
    public Kisi()
    {   
        RastgeleKisi.rastgeleKisiUret(this);//Kisi nesnesi üretildiğinde rastgeleKisiÜret fonksiyonuna bu nesneyi gönder
        RastgeleKisi.yaz(this);//Kisi nesnesi üretildiğinde bu nesnenin özelliklerini dosyaya yaz
    }
    
    public void yasAta(byte yas) //Yaş ataması yapmak için
    {
        this.yas = yas;
    }
    
    final public byte yasDondur() //yas degiskenini döndüren sabit bir fonksiyon
    {
        return yas;
    }
    
    public void isimAta(String isim) //İsim ataması yapmak için
    {
        this.isim = isim;
    }
    
    final public String isimDondur() //İsim döndüren sabit bir fonksiyon
    {
       return isim; 
    }
    
    public void soyIsimAta(String soyIsim) //soyisin ataması yapmak için
    {
        this.soyIsim = soyIsim;
    }
    
    final public String soyIsimDondur() //soyisim döndüren sabit bir fonksiyon
    {
        return soyIsim;
    }
    
    public final void bilgileriGoster() //Ödevi yaparken yardımcı oldu. Ödevde istenilen bir şey değil.
    {
        System.out.println("Isim: " + isim);
        System.out.println("Soyisim: " + soyIsim);
        System.out.println("Yas: " + yas);
        System.out.println("TC No: " + kimlikNo.tcNoDondur());
        System.out.println("Telefon: " + telefon.telNoDondur());
        System.out.println("IMEI No: " + telefon.imeiNo.imeiNoDondur());
    }
    
}
