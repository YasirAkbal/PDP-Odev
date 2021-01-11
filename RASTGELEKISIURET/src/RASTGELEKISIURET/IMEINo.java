/**
*
* @author Ahmet Yasir Akbal
* @since 25.03.2018
* <p>
* Lunh algoritmasına uygun rastgele bir IMEI no üreten ve bunu kaydeden sınıf
* </p>
*/

package RASTGELEKISIURET;


import java.util.Random;


public class IMEINo {
    
    String imeiNo = ""; //Bu paket dışındakilerin direkt olarak erişememesi için friendly
    private static Random rnd = new Random();
    
    public void IMEINoUret() //Luhn algoritmasına göre IMEI üreten metot
    {   
        int toplam = 0; //IMEI'deki rakamların toplamını tutan değişken
        byte temp; //Rakamları tutan geçici değişken
        
        for(int i=1;i<15;i++) //İlk 14 basamağı oluştur
        {   
            temp = (byte)rnd.nextInt(10);
            imeiNo += temp;
            if(i%2 == 1)//Eğer soldan tek basamak ise rakamı 2 ile çarp ve basamak değerlerini topla
            {
                toplam += (temp*2)%10 + (temp*2)/10;
            }
            else //Soldan çift basamak ise direkt rakamı topla
            {
                toplam += temp;
            }
        }
        
        if(toplam%10 != 0)//toplamın son hanesi 0 değilse, toplandığında onu kendisinden büyük en küçük 10 ile tam bölünen sayı yapan sayıyı bul
            imeiNo += 10 - toplam%10;
        else //toplamın son hanesi 0 ise IMEI'nin 15.hanesini 0 yap
            imeiNo += 0;
    }
    
    public final String imeiNoDondur() //IMEI'yi döndüren sabit fonksiyon
    {
        return imeiNo;
    }
    
    public static boolean imeiKontrol(String imei)//IMEI numarasının doğruluğunu kontrol eden fonksiyon
    {   
        int toplam = 0; //IMEI'deki rakamların toplamını tutan değişken
        byte temp; //Rakamları tutan geçici değişken
        
        for(int i=1;i<15;i++) //İlk 14 basamağa kadar oku ve toplam değişkenlerine bazı eklemeler yap
        {   
            temp = Byte.parseByte("" + imei.charAt(i-1));
            if(i%2 == 1) //Eğer okunan basamak soldan tek haneli ise, o basamaktaki rakamı 2 ile çarpıp çıkan sayının rakamlarını topla
                toplam += (temp*2)%10 + (temp*2)/10;
            else//Eğer okunan basamak soldan çift haneli ise direkt rakamları topla
                toplam += temp;
        }
        
        if(toplam%10 != 0) //toplam değişkeni 10a tam bölünmüyorsa ona eklendiğinde 10 tam bölünebilecek sayıyı bul ve tempe ata
            temp = (byte)(10-toplam%10);
        else //toplam değişkeni 10a tam bölünüyorsa tempi 0 yap
            temp = 0;
        
        //temp, IMEInin 15.basamağına eşitse true değilse false döndür
        return (temp == Byte.parseByte("" + imei.charAt(14))); 
    }
    
}
