import java.util.ArrayList;
import java.util.Scanner;

public class TokoKomputer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransaksiKomputer hansel = new TransaksiKomputer();
        ListKomputer listKomputer = new ListKomputer();
        ArrayList<String> detailPesanan = new ArrayList<>();

        listKomputer.List();

        String[] namaKomputerArray = {"HP Pavilion Gaming Desktop", "Dell OptiPlex 3070", "ASUS ROG Zephyrus G14",
                "Lenovo IdeaPad S340", "Apple iMac 21.5-inch", "HP All-in-One 24-df1036d",
                "MSI GF63 Thin", "Acer Predator Helios 300"};
        int[] hargaKomputerArray = {9000000, 6500000, 20000000, 10000000, 22000000, 14000000, 12000000, 19000000};

        int totalHargaSemuaPesanan = 0;

        System.out.print("Masukkan bulan pembelian (1-12): ");
        int bulanPembelian = scanner.nextInt();
        scanner.nextLine();

        boolean adaDiskon = (bulanPembelian == 8);
        double diskon = adaDiskon ? 0.1 : 0.0;

        do {
            System.out.print("Masukkan nomor komputer yang ingin dibeli: ");
            hansel.nomorKomputer = scanner.nextInt();
            scanner.nextLine();

            if (hansel.nomorKomputer >= 1 && hansel.nomorKomputer <= namaKomputerArray.length) {
                hansel.namaKomputer = namaKomputerArray[hansel.nomorKomputer - 1];
                hansel.harga = hargaKomputerArray[hansel.nomorKomputer - 1];
            } else {
                System.out.println("Nomor komputer tidak valid.");
                continue;
            }

            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            hansel.jumlah = scanner.nextInt();
            scanner.nextLine();

            hansel.totalHarga = hansel.harga * hansel.jumlah;
            totalHargaSemuaPesanan += hansel.totalHarga;

            detailPesanan.add(hansel.jumlah + " x " + hansel.namaKomputer + " : Rp" + String.format("%,.2f", (double) hansel.totalHarga));

            System.out.println("Total harga sementara: Rp" + String.format("%,.2f", (double) totalHargaSemuaPesanan));

            System.out.print("Apakah Anda ingin menambah pesanan? [Y/N]: ");
        } while (!scanner.nextLine().equalsIgnoreCase("N"));

        double totalHargaSetelahDiskon = totalHargaSemuaPesanan * (1 - diskon);

        System.out.println("Total harga : Rp" + String.format("%,.2f", (double) totalHargaSemuaPesanan));
        if (adaDiskon) {
            System.out.println("Diskon 10% untuk semua pembelian spesial bulan kemerdekaan Indonesia");
        } else {
            System.out.println("Tidak mendapatkan diskon karena user tidak membeli ketika bulan kemerdekaan Indonesia (Agustus).");
        }
        System.out.println("Total harga : Rp" + String.format("%,.2f", totalHargaSetelahDiskon));

        System.out.println("");

        System.out.print("Apakah Anda ingin membayar melalui Mobile Banking? [Y/N]: ");
        boolean menggunakanMobileBanking = scanner.nextLine().equalsIgnoreCase("Y");
        String namaBank = "";

        if (menggunakanMobileBanking) {
            Bank bank = new Bank();
            bank.listBank();

            System.out.print("Masukkan kode bank: ");
            int kodeBank = scanner.nextInt();
            scanner.nextLine(); 

            if (!bank.validasiBank(kodeBank)) {
                System.out.println("Kode bank tidak valid. Pembayaran dibatalkan.");
                scanner.close();
                return;
            }
            namaBank = bank.getNamaBank(kodeBank);
            System.out.println("Anda memilih bank: " + namaBank);
        }

        do {
            System.out.print("Masukkan jumlah uang yang dibayarkan: ");
            hansel.jumlahBayar = scanner.nextInt();

            hansel.kembalian = hansel.jumlahBayar - (int) totalHargaSetelahDiskon;
            if (hansel.kembalian >= 0) {
                System.out.println("Terima kasih telah melakukan pembelian.");
                System.out.println("Kembalian Anda: Rp" + String.format("%,.2f", (double) hansel.kembalian));
                break;
            } else {
                System.out.println("Maaf, uang yang Anda bayarkan tidak mencukupi. Silakan coba lagi.");
            }
        } while (true);

        if (menggunakanMobileBanking) {
            hansel.strukMobileBanking(totalHargaSemuaPesanan, diskon, totalHargaSetelahDiskon, hansel.jumlahBayar, hansel.kembalian, detailPesanan, namaBank);
        } else {
            hansel.struk(totalHargaSemuaPesanan, diskon, totalHargaSetelahDiskon, hansel.jumlahBayar, hansel.kembalian, detailPesanan);
        }

        scanner.close();
    }
}
