/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author nicholasjournet
 */
public class RequeteCitationJCVD {
    public static String getCitation() {
        String ur="http://147.210.240.40/java/seance11/JCVD.php";//ton URL
        String post="";//
        try{
        URL url = new URL(ur);
        URLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        writer.write(post);
        writer.flush();
//recuperation du code html
        String reponse=null;
        String ligne = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((ligne = reader.readLine()) != null) {
            //reponse+= ligne.trim()+"\n";
            reponse= ligne.trim();
        }
        return reponse;
        }
        catch (IOException e) {
            System.out.println("system serveur erreur");
        }
    return "";
    }
}
