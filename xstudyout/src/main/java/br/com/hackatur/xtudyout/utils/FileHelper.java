package br.com.hackatur.xtudyout.utils;

import java.io.InputStream;

public class FileHelper {

        public static InputStream getFireBaseCredentialStream() {
            return ClassLoader.getSystemClassLoader().getResourceAsStream("resource-firebase.json");



        }

}
