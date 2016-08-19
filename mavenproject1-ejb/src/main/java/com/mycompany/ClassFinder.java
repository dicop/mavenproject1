/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Diogo
 */
public class ClassFinder {

    private static final char PKG_SEPARATOR = '.';

    private static final char DIR_SEPARATOR = '/';

    private static final String CLASS_FILE_SUFFIX = ".class";

    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    public static List<Class<?>> find(String scannedPackage) throws Exception {
        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }
        File scannedDir = new File(scannedUrl.getFile());

        List<Class<?>> classes = new ArrayList<Class<?>>();

        boolean isArquivoJar = scannedDir.getPath().contains("!");
        String localizacaoJar = scannedDir.getPath().split("!")[0].replaceAll("file:\\\\", "");
        String pacoteClasseJar = scannedDir.getPath().split("!")[1].replaceAll("\\\\", "/").substring(1);

        if (isArquivoJar) {
            URL jar = new File(localizacaoJar).toURI().toURL();
            ZipInputStream zip = new ZipInputStream(jar.openStream());
            while (true) {
                ZipEntry e = zip.getNextEntry();
                if (e == null) {
                    break;
                }
                String name = e.getName();
                //System.out.println(name);
                if (name.contains(pacoteClasseJar) && name.endsWith(".class") && !name.contains("$") ) {
                    if (!name.replaceAll(pacoteClasseJar + "/", "").contains("/")){
                        try{
                            classes.add(Class.forName(name.replaceAll("/", ".").replaceAll(".class", "")));
                        }catch(Exception ex){
                            System.out.println("DIOGO TESTE");
                        }
                    }
                    
                }
            }
        } else {

            for (File file : scannedDir.listFiles()) {
                classes.addAll(find(file, scannedPackage));
            }
        }
        return classes;
    }

    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException ignore) {
            }
        }
        return classes;
    }

}
