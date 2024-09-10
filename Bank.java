class Bank {
    private final String[] namaBankArray = {"BANK MANDIRI", "BANK BCA", "BANK BRI"};
    private final int[] kodeBankArray = {101, 102, 103};

    void listBank() {
        System.out.println("Daftar bank yang tersedia untuk Mobile Banking:");
        for (int i = 0; i < namaBankArray.length; i++) {
            System.out.println(kodeBankArray[i] + ". " + namaBankArray[i]);
        }
    }

    boolean validasiBank(int kodeBank) {
        for (int kode : kodeBankArray) {
            if (kode == kodeBank) {
                return true;
            }
        }
        return false;
    }

    String getNamaBank(int kodeBank) {
        for (int i = 0; i < kodeBankArray.length; i++) {
            if (kodeBankArray[i] == kodeBank) {
                return namaBankArray[i];
            }
        }
        return null;
    }
}