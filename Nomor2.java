import java.util.ArrayList;
import java.util.Scanner;

public class Nomor2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] namaBuku = {"Sherlock Holmes", "Arsene Lupin", "Game of Throne", "Psychology of Money"};
        int[] hargaBuku = {350000, 450000, 500000, 95000};
        
        System.out.println("Daftar Buku:");
        for (int i = 0; i < namaBuku.length; i++) {
            System.out.println((i + 1) + ". " + namaBuku[i] + " - Rp " + hargaBuku[i]);
        }
        
        ArrayList<Integer> hargaBelanja = new ArrayList<>();
        
        while (true) {
            System.out.print("Masukan pilihan buku [1/2/3/4]: ");
            int pilihan = input.nextInt();
            
            // Validasi input pilihan buku
            if (pilihan < 1 || pilihan > namaBuku.length) {
                System.out.println("Pilihan buku tidak valid!");
                continue;
            }
        
            hargaBelanja.add(hargaBuku[pilihan - 1]);
            
            System.out.print("Input lagi (Y/N)?: ");
            String jawaban = input.next();
            
            if (jawaban.equalsIgnoreCase("N")) {
                break;
            }
        }
        
        int totalHarga = hitungTotalHarga(hargaBelanja);
        int voucherBelanja = hitungVoucherBelanja(totalHarga);
        
        System.out.println("Total voucher belanja = Rp " + voucherBelanja);
        System.out.println("Total yang harus dibayar = Rp " + (totalHarga - voucherBelanja));
        
        input.close();
    }
    
    public static int hitungTotalHarga(ArrayList<Integer> hargaBelanja) {
        int totalHarga = 0;
        for (int harga : hargaBelanja) {
            totalHarga += harga;
        }
        return totalHarga;
    }
    
    public static int hitungVoucherBelanja(int totalHarga) {
        if (totalHarga < 200000) {
            return 0;
        } else if (totalHarga >= 200000 && totalHarga <= 500000) {
            return 50000;
        } else if (totalHarga > 500000 && totalHarga <= 750000) {
            return 100000;
        } else if (totalHarga > 750000 && totalHarga <= 1000000) {
            return 150000;
        } else {
            return 200000;
        }
    }
}
