package com.sleepy4k.sales.laptop.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class HandleFile {
  private static final String TMP_FILE_PATH = "src\\com\\sleepy4k\\sales\\laptop\\data\\";

  public static File checkFile(String filePath) {
    File file = new File(filePath);

    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        Helper.printError(e.getMessage());
      }
    }

    return file;
  }

  public static boolean checkDataAlreadyExist(String filePath, RandomAccessFile raf, String model) {
    boolean isExist = false;

    try {
      String line = null;

      while ((line = raf.readLine()) != null) {
        String[] lineSplit = line.split(",");

        if (lineSplit[2].equals(model)) {
          isExist = true;
          break;
        }
      }
    } catch (IOException e) {
      Helper.printError(e.getMessage());
    }

    return isExist;
  }

  public static String readDataFile(String filePath) {
    String line = null;

    try {
      File file = checkFile(filePath);
      RandomAccessFile raf = new RandomAccessFile(file, "r");

      while ((line = raf.readLine()) == null) {
        raf.close();
        break;
      }

      raf.close();

      return line;
    } catch (IOException e) {
      Helper.printError(e.getMessage());

      return line;
    }
  }

  public static void addDataFile(String filePath, String data) {
    try {
      File file = checkFile(filePath);
      String[] dataSplit = data.split(",");
      RandomAccessFile raf = new RandomAccessFile(file, "rw");

      if (!checkDataAlreadyExist(filePath, raf, dataSplit[2])) {
        raf.seek(file.length());
        raf.writeBytes(data);
        raf.writeBytes(System.lineSeparator());
        raf.close();

        Helper.print("Data added!");
      } else {
        raf.close();
        Helper.print("Data already exist!");
      }
    } catch (IOException e) {
      Helper.printError(e.getMessage());
    }
  }

  public static String findDataFile(String filePath, String model) {
    String line = null;
    String data = null;

    try {
      File file = checkFile(filePath);
      RandomAccessFile raf = new RandomAccessFile(file, "r");

      while ((line = raf.readLine()) != null) {
        String[] lineSplit = line.split(",");

        if (lineSplit[2].equals(model)) {
          data = line;
          break;
        }
      }

      raf.close();

      return data;
    } catch (IOException e) {
      Helper.printError(e.getMessage());

      return data;
    }
  }

  public static void updateDataFile(String filePath, String model, String newData) {
    File file = checkFile(filePath);

    try {
      String line = null;
      boolean isExist = false;
      RandomAccessFile raf = new RandomAccessFile(file, "rw");

      while ((line = raf.readLine()) != null) {
        String[] lineSplit = line.split(",");

        if (lineSplit[2].equals(model)) {
          raf.seek(raf.getFilePointer() - line.length() - 2);
          raf.writeBytes(newData);
          raf.writeBytes(System.lineSeparator());

          Helper.print("Data updated!");
          isExist = true;
          break;
        }
      }

      if (!isExist) {
        Helper.print("Data not found!");
      }

      raf.close();
    } catch (IOException e) {
      Helper.printError(e.getMessage());
    }
  }

  public static void deleteDataFile(String filePath, String model) {
    File file = checkFile(filePath);

    try {
      String line = null;
      boolean isExist = false;
      RandomAccessFile raf = new RandomAccessFile(file, "rw");

      while ((line = raf.readLine()) != null) {
        if (line.split(",")[2].equals(model)) {
          isExist = true;
          File tmpFile = checkFile(TMP_FILE_PATH + Helper.generateUUID() + ".txt");
          RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile, "rw");

          raf.seek(0);

          while ((line = raf.readLine()) != null) {
            if (line.split(",")[2].equals(model)) {
              continue;
            }

            tmpRaf.writeBytes(line);
            tmpRaf.writeBytes(System.lineSeparator());
          }

          raf.close();
          tmpRaf.close();

          file.delete();
          tmpFile.renameTo(file);

          Helper.print("Data deleted!");
          break;
        }
      }

      if (!isExist) {
        Helper.print("Data not found!");
      }

      raf.close();
    } catch (IOException e) {
      Helper.printError(e.getMessage());
    }
  }
}
