package org.example;

import java.util.*;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static final List<Menu> menuList = new ArrayList<>();
    public static final List<Pesanan> pesananList = new ArrayList<>();
    private static final Pembayaran pembayaran = new Pembayaran(); // Object untuk melakukan pembayaran
    public static void main(String[] args) {
        menuList.add(new Menu(1, "Nasi Goreng", 15000));
        menuList.add(new Menu(2, "Mie Goreng", 13000));
        menuList.add(new Menu(3, "Nasi + Ayam", 18000));
        menuList.add(new Menu(4, "Es Teh Manis", 3000));
        menuList.add(new Menu(5, "Es Jeruk", 5000));

        tampilkanMenu(); // Memanggil method tampilkanMenu
    }

    public static void tampilkanMenu(){ // Membuat method dengan nama tampilkanMenu tanpa parameter
        System.out.println("=================================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("=================================");
        System.out.println();

        //pemanggilan list menu menggunakan optional class
        menuList.stream()
                .forEach(menu -> Optional.ofNullable(menu)
                        .ifPresent(System.out::println));

        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");

        pilihMenu(); // Memanggil method pilihMenu
    }

    public static void pilihMenu() { // Membuat method dengan nama pilihMenu tanpa parameter
        System.out.print("qrt => ");
        int userInput = input.nextInt(); // Sebuah inputan dari user

        if (userInput >= 1 && userInput <= 5) { // Pengecekan kondisi inputan dari user
            Menu menu = menuList.get(userInput - 1); // Mendapatkan object menu dari list berdasarkan inputan user

            System.out.println("\n\n\n================================");
            System.out.println("Berapa pesanan Anda");
            System.out.println("================================");
            System.out.println();

            System.out.println(menu); // Menampilkan informasi menu
            System.out.println("\n(input 0 untuk kembali)");
            masukanJumlah(menu); // Memanggil method masukanJumlah dengan parameter menu
        } else if (userInput == 99) {
            // Memproses pembayaran
            pesanDanBayar();
        } else if (userInput == 0) {
            // Keluar dari aplikasi
            System.out.println("Terima kasih telah menggunakan BinarFud.\n");
            System.exit(0);
        } else {
            System.out.println("Pilihan tidak valid.\n");
            tampilkanMenu();
        }
    }

    public static void masukanJumlah(Menu menu) { // Membuat method dengan nama masukanJumlah dengan parameter menu
        System.out.print("Masukkan jumlah pesanan: ");
        int jumlah = input.nextInt(); // Inputan user
        System.out.print("\n\n");

        Optional<Pesanan> pesananOptional = Optional.empty();
        if (jumlah > 0) {
            Pesanan pesanan = new Pesanan(menu, jumlah); // Membuat object pesanan dengan parameter menu dan jumlah
            pesananList.add(pesanan); // Menambahkan object pesanan ke list
            pesananOptional = Optional.of(pesanan);
        }
        tampilkanMenu(); // Memanggil method tampilkanMenu
    }

    public static void pesanDanBayar() { // Membuat method dengan nama pesanDanBayar tanpa parameter
        int totalPembelian = pesananList.stream()
                .filter(pesanan -> pesanan.getQty() > 0)
                .mapToInt(Pesanan::getQty)
                .sum();

        int totalHarga = pesananList.stream()
                .filter(pesanan -> pesanan.getQty() > 0)
                .mapToInt(Pesanan::getPrice)
                .sum();

        if (totalPembelian == 0) {
            System.out.println("\n\nAnda belum memesan apapun.\n");  // Kondisi ini akan keluar jika user belum pesan apapun
            System.out.println("\n\nKamu harus pesan minimal 1 makanan dulu yaaa....");
            tampilkanMenu();
        } else {
            System.out.println("\n\n================================");
            System.out.println("Konfirmasi dan Pembayaran");
            System.out.println("================================\n");

            // memanggil list pesanan dengan mengimplementasikan stream
            pesananList.stream()
                    .filter(pesanan -> pesanan.getQty() > 0)
                    .forEach(pesanan -> System.out.println(pesanan));

            System.out.println("-------------------------------");

            System.out.println("Total Harga: " + "\t" + totalPembelian + "\t" +   totalHarga);  // Mengembalikan nilai total harga
            System.out.println("\n1. Konfirmasi dan Bayar");
            System.out.println("2. Kembali ke menu utama");
            System.out.println("0. Keluar aplikasi");
            System.out.print("Pilihan => ");
            int kembali = input.nextInt();

            switch (kembali) {
                case 1:
                    pembayaran.bayar(totalHarga); // Memanggil method bayar dari object pembayaran
                    break;
                case 2:
                    System.out.print("\n");
                    tampilkanMenu(); // Memanggil method tampilkanMenu
                    break;
                case 0:
                    System.exit(0); // Keluar dari program
                    break;
                default:
                    tampilkanMenu(); // Memanggil method tampilkanMenu
                    break;
            }
        }
    }
}