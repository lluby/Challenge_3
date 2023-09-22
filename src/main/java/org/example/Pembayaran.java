package org.example;

import java.io.IOException;

public class Pembayaran {
    private Struk struk; // Object untuk membuat struktur pembayaran
    private FileBinar file; // Object untuk menyimpan struk ke file

    // Membuat contructor kosong
    public Pembayaran(){

    }

    public void bayar(int TotalPrice){
        struk = new Struk(TotalPrice); // membuat onject struk dengan parameter
        file = new FileBinar("struk.txt"); // membuat objek file dengan parameter nama file
        try{
            file.write(struk.toString()); // menulis isi struknya
            System.out.println("Struk telah dicetak");
        }catch(IOException e){
            System.out.println("Ups!! Ada kesalahan saat cetak struk");
            e.printStackTrace();
        }
        System.out.println("Terima Kasih telah menggunakan BinarFud.\n"); // pesan terimakasih
        System.exit(0); // keluar dari program
    }

}

