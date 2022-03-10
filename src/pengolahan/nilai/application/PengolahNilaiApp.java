package pengolahan.nilai.application;

import pengolahan.nilai.data.HitungAction;
import pengolahan.nilai.data.Modus;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PengolahNilaiApp {
    public static void main(String[] args) {
        String lokasiFile1 = "/home/rizalmohamad/Downloads/data_sekolah.csv";
        String lokasiFileSoal1 = "/home/rizalmohamad/Documents/Binar/soal1.txt";
        String lokasiFileSoal2 = "/home/rizalmohamad/Documents/Binar/soal2.txt";
        ArrayList<String> arr = new ArrayList<String>();
        try {
            File file = new File(lokasiFile1);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(";");
                for (String tempStr : tempArr) {
                    if (tempStr.length() <= 2) {
                        arr.add(tempStr);
                    }
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        ArrayList<Integer> nilai = new ArrayList<>();
        for (String s : arr) {
            nilai.add(Integer.valueOf(s));
        }
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("--------------------------------------------------------");
            System.out.println("Aplikasi Pengolahan Nilai Siswa");
            System.out.println("--------------------------------------------------------");
            System.out.println("Letakan file csv dengan nama file data_sekolah di direktori berikut /home/rizalmohamad/Documents/Binar/");
            System.out.println("Pilih Menu :");
            System.out.println("1. Generate txt untuk menampilkan modus");
            System.out.println("2. Generate txt untuk menampilkan rata-rata,median,modus");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");
            System.out.print("Masukan Pilihan 1/2/3/0");
            int pilihan = input.nextInt();

            if(pilihan == 1){
                System.out.println("--------------------------------------------------------");
                System.out.println("Aplikasi Pengolahan Nilai Siswa");
                System.out.println("--------------------------------------------------------");
                System.out.println("File Telah di generate di "+ lokasiFileSoal1);
                System.out.println();
                soal1(nilai, lokasiFileSoal1);
                System.out.println("0 Exit");
                System.out.println("1 Kembali ke menu utama");
                int input1 = input.nextInt();
                if(input1 == 1){
                    continue;
                }else{
                    break;
                }

            }else if(pilihan == 2){
                System.out.println("--------------------------------------------------------");
                System.out.println("Aplikasi Pengolahan Nilai Siswa");
                System.out.println("--------------------------------------------------------");
                System.out.println("File Telah di generate di "+ lokasiFileSoal2);
                System.out.println();
                soal2(nilai, lokasiFileSoal2);
                System.out.println("0 Exit");
                System.out.println("1 Kembali ke menu utama");
                int input1 = input.nextInt();
                if(input1 == 1){
                    continue;
                }else{
                    break;
                }
            }else if(pilihan == 3){
                System.out.println("--------------------------------------------------------");
                System.out.println("Aplikasi Pengolahan Nilai Siswa");
                System.out.println("--------------------------------------------------------");
                System.out.println("File Telah di generate di "+ lokasiFileSoal1);
                System.out.println();
                soal1(nilai, lokasiFileSoal1);
                soal2(nilai, lokasiFileSoal2);
                System.out.println("0 Exit");
                System.out.println("1 Kembali ke menu utama");
                int input1 = input.nextInt();
                if(input1 == 1){
                    continue;
                }else{
                    break;
                }
            }else if(pilihan == 0){
                break;
            }
        }


    }

    public static void soal1(ArrayList<Integer> nilai,String lokasi){
        Modus ms = new Modus();
        ms.setNilai(nilai);

        try{
            File file = new File(lokasi);
            if(file.createNewFile()){
                System.out.println("New File is Created");
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);
            bwr.write("Berikut Hasil Pengolahan Nilai:");
            bwr.newLine();
            bwr.write("Nilai \t\t\t |\t\trekuensi");
            bwr.newLine();
            bwr.write("Kurang dari 6 \t |\t\t "+ms.modus(0,5));
            bwr.newLine();
            bwr.write("6 \t\t\t\t |\t\t "+ms.modus(6,6));
            bwr.newLine();
            bwr.write("7 \t\t\t\t |\t\t "+ms.modus(7,7));
            bwr.newLine();
            bwr.write("8 \t\t\t\t |\t\t "+ms.modus(8,8));
            bwr.newLine();
            bwr.write("9 \t\t\t\t |\t\t "+ms.modus(9,9));
            bwr.newLine();
            bwr.write("10 \t\t\t\t |\t\t "+ms.modus(10,10));
            bwr.flush();
            bwr.close();
            System.out.println("Successfully writen to a file in directory"+lokasi);

        }catch (IOException e){
            System.out.println("An Error occurred. *");
            e.printStackTrace();
        }

    }
    public static void soal2(ArrayList<Integer> nilai, String lokasi){
        HitungAction hn = new HitungAction();
        hn.setNilai(nilai);

        try{
            File file = new File(lokasi);
            if(file.createNewFile()){
                System.out.println("New File is Created");
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);
            bwr.write("Berikut Hasil Pengolahan Nilai:");
            bwr.newLine();
            bwr.write("Berikut hasil sebaran data nilai");
            bwr.newLine();
            bwr.write("Mean :"+hn.mean());
            bwr.newLine();
            bwr.write("Median :"+hn.median());
            bwr.newLine();
            bwr.write("Modus :"+ hn.modusSoal2());
            bwr.flush();
            bwr.close();
            System.out.println("Successfully writen to a file in directory"+lokasi);

        }catch (IOException e){
            System.out.println("An Error occurred. *");
            e.printStackTrace();
        }
    }
}
