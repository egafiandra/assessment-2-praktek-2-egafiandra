import java.util.ArrayList;
import java.util.Scanner;

public class TokoBuku {
    
    private static String[] bukuNama = {
        "Sherlock Holmes",
        "Arsene Lupin", 
        "Game of Throne",
        "Psychology of Money"
    };
    
   
    private static int[] bukuHarga = {
        350000,
        450000,
        500000,
        95000
    };
    
    
    public static void tampilkanDaftarBuku() {
        System.out.println("Daftar Buku:");
        for (int i = 0; i < bukuNama.length; i++) {
            System.out.println((i+1) + ". " + bukuNama[i] + " " + bukuHarga[i]);
        }
    }
    
    
    public static int hitungTotalHarga(ArrayList<Integer> keranjang) {
        int totalHarga = 0;
        for (int indexBuku : keranjang) {
            totalHarga += bukuHarga[indexBuku - 1];
        }
        return totalHarga;
    }
    
   
    public static int hitungVoucher(int totalHarga) {
        int voucher = 0;
        
        if (totalHarga >= 200000 && totalHarga < 500000) {
            voucher = 50000;
        } else if (totalHarga >= 500000 && totalHarga < 750000) {
            voucher = 100000;
        } else if (totalHarga >= 750000 && totalHarga < 1000000) {
            voucher = 150000;
        } else if (totalHarga >= 1000000) {
            voucher = 200000;
        }
        
        return voucher;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> keranjang = new ArrayList<>();
        
       
        tampilkanDaftarBuku();
        
     
        while (true) {
            System.out.print("Masukan pilihan buku [1/2/3/4]: ");
            int pilihanBuku = scanner.nextInt();
            
            
            if (pilihanBuku < 1 || pilihanBuku > bukuNama.length) {
                System.out.println("Pilihan buku tidak valid!");
                continue;
            }
            
         
            keranjang.add(pilihanBuku);
            
         
            System.out.print("Input lagi (Y/N)?: ");
            String inputLagi = scanner.next();
            
            if (!inputLagi.equalsIgnoreCase("Y")) {
                break;
            }
        }
        
       
        int totalHarga = hitungTotalHarga(keranjang);
        
       
        int voucher = hitungVoucher(totalHarga);
        
      
        System.out.println("Total voucher belanja = " + voucher);
        System.out.println("Total yang harus dibayar = " + (totalHarga - voucher));
        
        scanner.close();
    }
}
