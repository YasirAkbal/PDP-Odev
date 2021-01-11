/**
*
* @author Ahmet Yasir Akbal
* @since 25.03.2018
* <p>
* TC kimlik no algoritmasına uygun rastgele bir TC no üreten ve bunu kaydeden sınıf
* </p>
*/

package RASTGELEKISIURET;


import java.util.Random;

public class KimlikNo {
    
    String tcNo = ""; //Bu paket dışındakilerin direkt olarak erişememesi için friendly
    private static Random rnd = new Random();
    
    public void tcNoUret() //TC No algoritmasına göre rastgele TC numarısı üreten metot
    {   
        int tekler = 0; //Tc numarasındaki soldan tek haneli basamaklardaki rakamların toplamını tutan değişken
        int ciftler = 0; //Tc numarasındaki soldan çift haneli basamaklardaki rakamların toplamını tutan değişken
        int temp; //Atamalar ve kontroller yaparken kolaylık sağlaması için geçici değişken
        
        temp = 1 + rnd.nextInt(9); //0dan büyük 10dan küçük bir tamsayıyı temp değişkenine ata.
        tcNo += temp; //temp değişkenindeki sayıyı TC numarasının ilk hanesine ata
        tekler += temp;//İlk hane tek haneli bir basamak olduğu için bu hanedeki rakamı tekler değişkinine ekle
        
        for(int i=0;i<8;i++) //2-9 arası(9 dahil) haneleri rastgele üreten döngü
        {   
            temp = rnd.nextInt(10); //0-10 arasında bir sayı üretip bunu tempe ata
            tcNo += temp; //temp değişkenindeki sayıyı TC numarasının bir sonraki hanesi olarak ekle
            if(i%2 == 0) //Eğer okunan hane çift ise bu haneyi ciftler değişkenine ekle
                ciftler += temp;
            else //Eğer okunan hane çift ise bu haneyi tekler değişkenine ekle
                tekler += temp;   
        }
        
        temp = (7*tekler - ciftler)%10; //Tek hanedeki rakamların toplamının 7 katından çift hanedeki rakamları çıkart ve çıkan sonucun 10 ile modunu al
        tcNo += temp; //temp değişkenindeki sayıyı tcNo'ya ata
        
        tcNo += (tekler + ciftler + temp)%10; //10 hanedeki tüm rakamları toplayıp modunu al ve bu sayıyı TC No'nun 11. hanesi olarak ata  
    }
    
    public final String tcNoDondur() //Tc noyu döndüren sabit bir fonksiyon
    {
        return tcNo;
    }
    
    public static boolean tcKontrol(String tc) //Paremetre olarak alınan tc nosunun doğruluğunu kontrol eden metot
    {
        byte temp = Byte.parseByte("" + tc.charAt(0)); //temp değişkenini tanımla ve Tc nosunun ilk hanesini temp değişkenine ata
        int tekler; //TC nosundaki tek hanedeki rakamların toplamını tutmak için
        int ciftler = 0;  //TC nosundaki çift hanedeki rakamların toplamını tutmak için
        
        if(temp == 0) //TC numarısının ilk hanesi 0 olmamlı. 0 ise false döndür.
            return false;
        
        tekler = temp; //İlk hane tek haneli olduğu için tekler değişkenine ata
        
        for(int i=1;i<9;i++) //Soldan 2. basamaktan 9. basamağa kadar(9. dahil)
        {
            if(i%2 == 1) //Okunan basamak cift ise
                ciftler += Byte.parseByte("" + tc.charAt(i));
            else //Okunan basamak tek ise
                tekler += Byte.parseByte("" + tc.charAt(i));
        }
        
        temp = Byte.parseByte("" + tc.charAt(9)); //temp değişkenine Tc nosunun 10. hanesini ata
        
        if(temp != (7*tekler - ciftler)%10) //temp eşitliğin sağ tarafına eşit değilse false döndür
            return false;
        
        //Tc nosunun son(11.) hanesi ilk 10 hanenin toplamının 10 ile moduna eşitse true değilse false dondur
        return (Byte.parseByte("" + tc.charAt(10)) == (tekler + ciftler + temp)%10);
    }
    
}
