/**
*
* @author Ahmet Yasir Akbal
* @since 25.03.2018
* <p>
* Kütüphaneyi test eden ana programın bulunduğu sınıf
* </p>
*/

package b161210074_odev2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class B161210074_Odev2 {

    //Rastgele olarak üretilen kisileri barındıran ArrayList yapısı
    private static ArrayList<RASTGELEKISIURET.Kisi> kisiler = new ArrayList<RASTGELEKISIURET.Kisi>(); 

    public static void main(String[] args) {
       
        //Menü yapısı için gerekli tanımlamalar
        Scanner girdi = new Scanner(System.in);
        byte secim = 0;
        
        int uretilecekKisiSayisi; //Üretilecek kişi sayısını içinde tutan değişken
        
        while(secim != 3)//Kullanıcı klavyeden 3 değerini girmediği sürece devam et
        {
            System.out.println("1- Rastgele Kişi Üret\n"
            + "2- Üretilmiş Dosya Kontrol Et\n"
            + "3- Çıkış");
            
            secim = girdi.nextByte(); 
            
            switch(secim)
            {
                case 1: //Girilen sayı kadar rastgele yeni kişi üret
                    System.out.print("Oluşturalacak kişi sayısınız giriniz: ");
                    uretilecekKisiSayisi = girdi.nextInt();
                    for(int i=0;i<uretilecekKisiSayisi;i++) 
                        kisiler.add(new RASTGELEKISIURET.Kisi());
                    break;
                
                case 2:
                    tcIMEIKontrol(); //Txt dosyasındaki TC ve IMEI nolarının doğruluğunu kontrol et.
                    break;
                    
                case 3: //Girilen değer 3 ise hiçbir şey yapmadan switch yapısından çık
                    break;
                    
                default: //default
                    System.out.println("Yanlış seçim");
                    break;
            }
        }
             
    }
    
    private static void tcIMEIKontrol()
    {   
        
        String okunan; //Txt dosyasından okunan satırı tutan değişken
        String[] temp; //Okunan satırı parçalayan fonksiyonun döndürdüğü String dizisini yakalamak için
        int gecersizTC = 0;
        int gecersizIMEI = 0;
        
        try
        {
            File dosya = new File("doc\\Kisiler.txt");
            FileReader fr = new FileReader(dosya);
            BufferedReader br = new BufferedReader(fr);
       
            while((okunan = br.readLine()) != null) //Dosyanın sonuna gelinmediği sürece
            {
                temp = okunan.split(" "); //temp[0] = tc, temp[5] = IMEI
                if(!RASTGELEKISIURET.KimlikNo.tcKontrol(temp[0])) //TC geçersiz ise
                    gecersizTC++;
                if(!RASTGELEKISIURET.IMEINo.imeiKontrol(temp[5].substring(1, 16))) //IMEI geçersiz ise
                    gecersizIMEI++;
            }
            
            br.close(); //Dosyayı kapat
            
            System.out.println("T.C. Kimlik Kontrol\n" + (kisiler.size()-gecersizTC) + " Geçerli\n"
            + gecersizTC + " Geçersiz");
            System.out.println("IMEI Kontrol\n" + (kisiler.size()-gecersizIMEI) + " Geçerli\n"
            + gecersizIMEI + " Geçersiz\n"); 
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
