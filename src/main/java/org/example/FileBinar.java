package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileBinar {
        private String name; // Nama file
        private String path; // Lokasi file

        // Membuat constructor dengan parameter name untuk menginisialisasi property
        public FileBinar(String name) {
            this.name = name;
            this.path = System.getProperty("user.dir") + "\\" + name; // Mengambil lokasi direktori saat ini dari sistem dan menambahkan nama file
        }

        // Membuat getter untuk mengakses property
        public String getName() {
            return name;
        }

        public String getPath() {
            return path;
        }

        // Membuat method write dengan parameter content untuk menulis isi file
        public void write(String content) throws IOException {
            java.io.File file = new java.io.File(path); // Membuat object file dari class java.io.File dengan parameter path
            if (file.createNewFile()) { // Mengecek apakah file sudah ada atau belum, jika belum maka membuat file baru
                System.out.println("File telah dibuat");
            }
            FileWriter fw = new FileWriter(file); // Membuat object file writer dengan parameter file
            BufferedWriter bw = new BufferedWriter(fw); // Membuat object buffered writer dengan parameter file writer
            bw.write(content); // Menulis isi file dengan parameter content
            bw.close(); // Menutup buffered writer
        }
}
