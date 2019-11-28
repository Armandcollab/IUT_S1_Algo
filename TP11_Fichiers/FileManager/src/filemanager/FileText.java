package filemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * TP fichiers.
 */
class FileText {

    int action1(String fileName) {
        int cpt = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                cpt++;
            }
            br.close();
        } catch (IOException e) {
            return -1;
        }
        return cpt;
    }

    int action2(String fileName) {
        int cpt = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                cpt += scanner.nextLine().split(" ").length;
            }
            scanner.close();
        } catch (IOException e) {
            return -1;
        }
        return cpt;
    }

    void action3(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            String tmp = RequeteCitationJCVD.getCitation();
            bw.write(tmp);
        } catch (IOException e) {
            System.out.println("File write error");
        }
    }
}
