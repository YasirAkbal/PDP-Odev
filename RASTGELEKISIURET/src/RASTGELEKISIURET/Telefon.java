/**
*
* @author Ahmet Yasir Akbal
* @since 25.03.2018
* <p>
* Türkiyedeki telefon numarası kalıbına uygun şekilde telefon no üreten ve tutan sınıf
* </p>
*/

package RASTGELEKISIURET;


import java.util.Random;


public class Telefon {
    
    String telNo; //telefon numarası freindly
    private static Random rnd = new Random();
    IMEINo imeiNo = new IMEINo(); //Telefon olmadan IMEI no olmayacağı için IMEIyi Telefon sınıfında oluşturdum
    
    public void telNoUret() //Rastgele telefon numarası üret.(Türkiye'ye uygun)
    {
        telNo = "+905"; //Hepsinin başında bu olacak
        for(int i=0;i<9;i++) //9 tane rastgele hane ekle(0,10 arası)
        {
            telNo += rnd.nextInt(10);
        }
    }
    
    public final String telNoDondur() //Telefon numarasını döndüren sabit fonksiyon
    {
        return telNo;
    }
    
}
