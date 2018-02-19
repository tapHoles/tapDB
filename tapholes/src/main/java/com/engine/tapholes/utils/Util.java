package com.engine.tapholes.utils;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    private String PRIVACY_POLICY_FOLDER = "../PrivacyPolicy/";
    private String PRIVACY_POLICY_PATH = ".com.html";

    public String GetTextFromHTML(String file) {
        try {
            if (StringUtil.isBlank(file)) {
                return file;
            }
            return Jsoup.parse(readFileAsString(PRIVACY_POLICY_FOLDER + file + PRIVACY_POLICY_PATH)).text();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private String readFileAsStringLineByLine(String file)
            throws FileNotFoundException, IOException{
        InputStream is = new FileInputStream(PRIVACY_POLICY_FOLDER + file + PRIVACY_POLICY_PATH);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
        return fileAsString;
    }

    String readFileAsString(String path)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }

}
