import java.util.ArrayList;
class TransaksiKomputer {
    int nomorKomputer,harga,jumlah,totalHarga,jumlahBayar,kembalian,totalHargaSemuaPesanan;
    String namaKomputer;
    
    void struk(int totalHargaSemuaPesanan,double diskon,double totalHargaSetelahDiskon,int jumlahBayar,int kembalian,ArrayList<String> detailPesanan) {
        System.out.println("---------------------------------------------------------");
        System.out.println("                  Hansel Store Computer                  ");
        System.out.println("                    Jl.Nagala 1 No 12                    ");
        System.out.println("---------------------------------------------------------");
        System.out.println("                     Struk Pembayaran                    ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Detail Produk :");
        for (String detail : detailPesanan) {
            System.out.println(detail);}
        System.out.println("Total harga : Rp" + String.format("%,.2f",(double)totalHargaSemuaPesanan));
        System.out.println("Diskon: " + (diskon * 100) + "%");
        System.out.println("Total Keseluruhan harga : Rp" + String.format("%,.2f", totalHargaSetelahDiskon));
        System.out.println("Jumlah uang yang dibayarkan: Rp" + String.format("%,.2f",(double)jumlahBayar));
        System.out.println("Kembalian: Rp" + String.format("%,.2f",(double)kembalian));
        System.out.println("---------------------------------------------------------");
        System.out.println("           Terimakasih Silahkan Datang Kembali           ");
        System.out.println("---------------------------------------------------------");
    }


        void strukMobileBanking(int totalHargaSemuaPesanan, double diskon, double totalHargaSetelahDiskon, int jumlahBayar, int kembalian, ArrayList<String> detailPesanan, String namaBank) {
            System.out.println("---------------------------------------------------------");
            System.out.println("            Struk Pembayaran Mobile Banking              ");
            System.out.println("---------------------------------------------------------");
            System.out.println("Bank: " + namaBank);
            for (String detail : detailPesanan) {
                System.out.println(detail);
            }
            System.out.println("Total harga : Rp" + String.format("%,.2f", (double) totalHargaSemuaPesanan));
            System.out.println("Diskon: " + (diskon * 100) + "%");
            System.out.println("Total Keseluruhan harga : Rp" + String.format("%,.2f", totalHargaSetelahDiskon));
            System.out.println("Jumlah yang dibayarkan: Rp" + String.format("%,.2f", (double) jumlahBayar));
            System.out.println("Kembalian: Rp" + String.format("%,.2f", (double) kembalian));
    }
}

