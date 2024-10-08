import java.util.Scanner;

public class TechSupportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Selamat Datang di Aplikasi Bantuan Teknis ===");
        
        // Inisialisasi Pusat Bantuan Teknis
        TechSupportCenter center = new TechSupportCenter();
        center.populateFAQs();  // Mengisi dengan masalah dan solusi
        
        boolean running = true;
        while (running) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Ajukan masalah teknis");
            System.out.println("2. Lihat masalah dan solusi terbaru");
            System.out.println("3. Keluar");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Untuk menangani newline character
            
            switch (choice) {
                case 1:
                    System.out.println("Silakan ketik deskripsi masalah Anda:");
                    String problem = scanner.nextLine();
                    String solution = center.solveProblem(problem);
                    if (solution != null) {
                        System.out.println("Solusi: " + solution);
                    } else {
                        System.out.println("Maaf, kami belum memiliki solusi untuk masalah tersebut.");
                    }
                    break;
                    
                case 2:
                    center.showFAQs();
                    break;
                    
                case 3:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi bantuan teknis kami!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
}

class TechSupportCenter {
    private String[][] faqs;

    // Mengisi daftar masalah umum dan solusinya
    public void populateFAQs() {
        faqs = new String[][] {
            {"Komputer tidak menyala", "Periksa kabel daya dan pastikan komputer tersambung ke sumber listrik."},
            {"Layar tidak menampilkan gambar", "Pastikan monitor terhubung ke komputer dan sumber listrik dengan benar."},
            {"Wi-Fi tidak terhubung", "Coba restart router atau pastikan perangkat Wi-Fi dalam jangkauan."},
            {"Aplikasi crash", "Coba restart aplikasi atau perbarui ke versi terbaru."}
        };
    }
    
    // Mencari solusi berdasarkan deskripsi masalah
    public String solveProblem(String problem) {
        for (int i = 0; i < faqs.length; i++) {
            if (problem.toLowerCase().contains(faqs[i][0].toLowerCase())) {
                return faqs[i][1];
            }
        }
        return null;
    }
    
    // Menampilkan semua masalah umum dan solusi
    public void showFAQs() {
        System.out.println("=== Masalah dan Solusi yang Tersedia ===");
        for (int i = 0; i < faqs.length; i++) {
            System.out.println((i + 1) + ". Masalah: " + faqs[i][0]);
            System.out.println("   Solusi: " + faqs[i][1]);
        }
    }
}
