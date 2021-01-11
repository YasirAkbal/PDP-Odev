/**
*
* @author Ahmet Yasir Akbal
* @since 25.03.2018
* <p>
* Dosya okuma/yazma, Kisi nesnesine rastgele değerler atayan(IMEI ve TC algoritmaya uygun olacak şekilde) sınıf
* </p>
*/

package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class RastgeleKisi {
    
    /*Kisiler.txt dosyası sabit olduğu için sabit bir dizi kullandım fakat ArrayList de kullanabilirdim.
    Bu ödev için gerekmedi*/
    private static final int toplamKisi = 3000; //Kisiler.txt dosyasındaki toplam kişi sayısı
    private static String[][] kisiler = oku(); //Kisiler.txt dosyasındaki tüm isim soyisimleri tutan kisiler değişkeni
    private static Random rnd = new Random(); //Rastgelelik için
    private static int randomTemp; //Random() fonksiyonu ile oluşturulan sayıyı tutmak için
    
    
    public static String[][] oku() //Kisiler.txt dosyasındaki tüm isim soyisimleri okuyup döndüren metot
    {   
        String[][] temp = new String[toplamKisi][2]; //Okunan isim ve soyisimleri döndürmek için geçici değişken
        
        try
        {
            File dosya = new File("doc\\random_isimler.txt"); //dosya aç
            FileReader fr = new FileReader(dosya); //dosyadan oku
            BufferedReader br = new BufferedReader(fr);
            
            String okunan; //okunan satırı tutmak için
            int indis = 0; //okunan kişi sayısını tutmak için
            
            while((okunan = br.readLine()) != null) //Dosyanın sonuna gelinmediği sürece satır satır okuma yap
            {
                temp[indis++] = okunan.split(" "); //Okunan satırı boşluk ayracına göre böl
            }
            
            br.close(); //Dosyayı kapat
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return temp; //2 boyutlu temp dizisini döndür
    }
    
    
    public static void yaz(Kisi kisi) //Paremetre olarak aldığı kisi nesnesini dosyaya yazan metot
    {
        try
        {
            File dosya = new File("doc\\Kisiler.txt"); //dosya aç
            FileWriter fw = new FileWriter(dosya, true); //dosyaya ekle üstüne yazma
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(kisi.kimlikNo.tcNoDondur() + " " + kisi.isimDondur() + " " + kisi.soyIsimDondur() //dosyaya yaz
            + " " + kisi.yasDondur() + " " + kisi.telefon.telNoDondur() + " (" 
                    + kisi.telefon.imeiNo.imeiNoDondur() + ")");
            bw.newLine(); //alt satıra geç
            
            bw.close(); //dosya akapat
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    
    public static void rastgeleKisiUret(Kisi kisi)
    {
        randomTemp = rnd.nextInt(toplamKisi); //Rastgele sayı üret ve randomTemp değişkenine ata
        kisi.isimAta(kisiler[randomTemp][0]); //isim ata
        kisi.soyIsimAta(kisiler[randomTemp][1]); //soyisim ata
        kisi.yasAta((byte)rnd.nextInt(100)); //yas üret ve ata
        kisi.kimlikNo.tcNoUret(); //tcno üret ve ata
        kisi.telefon.telNoUret(); //telefon no üret ve ata
        kisi.telefon.imeiNo.IMEINoUret(); //IMEI no üret ve ata
    }
    
       
}
