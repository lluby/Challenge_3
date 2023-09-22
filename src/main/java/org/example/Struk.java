package org.example;

public class Struk {
    private int TotalPrice;
    private String date;

    // membuat konstruktor dengan parameter
    public Struk(int TotalPrice){
        this.TotalPrice = TotalPrice;
        this.date = java.time.LocalDate.now().toString();
    }

    public int getTotalPrice(){
        return TotalPrice;
    }

    public String getDate(){
        return date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Object untuk membangun string
        sb.append("======================================\n");
        sb.append("BinarFud\n");
        sb.append("======================================\n\n\n");
        sb.append("======================================\n");
        sb.append("Terima kasih sudah memesan \ndi BinarFud\n");
        sb.append("======================================\n");
        sb.append("\nDibawah ini adalah pesanan Anda \n\n");

        for (Pesanan pesanan : Main.pesananList) { // Memanggil list pesanan dari class Main
            if (pesanan.getQty() > 0) {
                sb.append(pesanan); // Menambahkan informasi pesanan ke string
                sb.append("\n");
            }
        }
        sb.append("\n-------------------------------\n");

        sb.append("Total Harga: " + "\t" +   TotalPrice);  // Menambahkan nilai total harga ke string
        sb.append("\nTanggal: " + date); // Menambahkan tanggal pembayaran ke string

        return sb.toString(); // Mengembalikan string yang dibangun
    }
}
