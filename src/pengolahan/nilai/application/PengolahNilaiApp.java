package pengolahan.nilai.application;

import pengolahan.nilai.data.HitungAction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PengolahNilaiApp {
    public static void main(String[] args) {

        String lokasiFile1 = "/home/rizalmohamad/Downloads/data_sekolah.csv";
        String lokasiFileSoal1 = "/home/rizalmohamad/Documents/Binar/soal1.txt";
        String lokasiFileSoal2 = "/home/rizalmohamad/Documents/Binar/soal2.txt";
        ArrayList<Integer> nilai = new ArrayList<>();



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

                  try {
                      nilai = readFile(lokasiFile1);

                      System.out.println("File Telah di generate di "+ lokasiFileSoal1);
                      System.out.println();
                      soal1(nilai, lokasiFileSoal1);
                  }catch (IOException e){
                  System.out.println("Data tidak ditemukan");
                  }
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
                try {
                    nilai = readFile(lokasiFile1);

                    System.out.println("File Telah di generate di "+ lokasiFileSoal2);
                    System.out.println();
                    soal2( nilai, lokasiFileSoal2);
                }catch (IOException e){
                    System.out.println("Data tidak ditemukan");
                }
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
                try {
                    nilai = readFile(lokasiFile1);
                    System.out.println("File Telah di generate di "+ lokasiFileSoal2);
                    System.out.println();
                    soal1(nilai, lokasiFileSoal1);
                    soal2(nilai, lokasiFileSoal2);
                }catch (IOException e){
                    System.out.println("Data tidak ditemukan");
                }

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

    public static ArrayList  readFile(String lokasiFile1) throws IOException{
        ArrayList<String> arr = new ArrayList<String>();

            File file = new File(lokasiFile1);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(";");
                for (int i = 1;i<tempArr.length;i++) {

                        arr.add(tempArr[i]);

                }
            }
            br.close();


        ArrayList<Integer> nilai = new ArrayList<>();
        for (String s : arr) {
            nilai.add(Integer.valueOf(s));
        }

       nilai = sort(nilai);




        return nilai;
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> list){

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j - 1) > list.get(j)) {

                    int tmp = list.get(j - 1);
                    list.set(j -1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

     return list;
    }

    public static void soal1(ArrayList<Integer> nilai,String lokasi){

        HitungAction hn = new HitungAction();
        hn.setNilai(nilai);



        HashMap<Integer, Integer> map =hn.modusSoal1();
        System.out.println(map);
        try{
            File file = new File(lokasi);

            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);
            bwr.write("Berikut Hasil Pengolahan Nilai:");
            bwr.newLine();
            bwr.write("Nilai \t\t\t\t|\t\t frekuensi");
            bwr.newLine();
            for(Integer i: map.keySet()){
                if(i < 6){
                    bwr.write("Kurang dari 6 \t\t\t|\t\t "+map.get(i));
                    bwr.newLine();
                }else {
                    bwr.write(i+"\t\t\t\t |\t\t "+map.get(i));
                    bwr.newLine();
                }
            }
            bwr.flush();
            bwr.close();


        }catch (IOException e){
            System.out.println("File Tidak DI temukan"+e.getMessage());
            e.printStackTrace();

        }

    }
    public static void soal2(ArrayList<Integer> nilai, String lokasi){
        HitungAction hn = new HitungAction();
        hn.setNilai(nilai);

        try{
            File file = new File(lokasi);
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);
            bwr.write("Berikut Hasil Pengolahan Nilai:");
            bwr.newLine();
            bwr.write("Berikut hasil sebaran data nilai");
            bwr.newLine();
            bwr.write("Mean :"+hn.mean());
            bwr.newLine();
//            bwr.write("Meansss :"+hn.modusSoal1());
//            bwr.newLine();
            bwr.write("Median :"+hn.median());
            bwr.newLine();
            bwr.write("Modus :"+ hn.modusSoal2());
            bwr.flush();
            bwr.close();

        }catch (IOException e){
            System.out.println("An Error occurred. *");
            e.printStackTrace();
        }
    }
}
