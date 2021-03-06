package org.personal.mason.common.code;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by mason on 12/1/14.
 */
public class Main {
    private static final String NAME_SPILITOR = "----------------";
    private static final String FILE_SPILITOR = "============================================================";

    public static void main(String[] args) throws IOException {
        String string = IOUtils.toString(new FileInputStream("/Volumes/BACKUP/Mac/SCM/AddressBook/common/target/temp.txt"));
        String[] split = string.split(FILE_SPILITOR);
        for (String str : split) {
            String[] strings = str.split(NAME_SPILITOR, 2);
            File outputFile = new File("/Volumes/BACKUP/Mac/SCM/AddressBook/common/target/output/" + strings[0]);
            FileUtils.writeStringToFile(outputFile, strings[1]);
        }
    }

    private static final String OUTPUT_BASE = "/Volumes/BACKUP/Mac/SCM/AddressBook/common/target/output/";
    private static final String FILE = "/Volumes/BACKUP/Mac/SCM/AddressBook/common/target/temp.txt";

    public static void readFromFile() throws IOException {
        String string = IOUtils.toString(new FileInputStream(FILE));
        String[] split = string.split(FILE_SPILITOR);
        for (String str : split) {
            String[] strings = str.split(NAME_SPILITOR, 2);
//            int indexOf = strings[0].lastIndexOf("/");
            File outputFile = new File(OUTPUT_BASE + strings[0]);
            FileUtils.writeStringToFile(outputFile, strings[1]);
        }
    }
}
