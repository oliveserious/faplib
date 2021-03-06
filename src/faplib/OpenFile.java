/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faplib;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class OpenFile {

  public static void main(String[] a) {
    JFileChooser fileChooser = new JFileChooser(".");
    FileFilter filter1 = new ExtensionFileFilter("JPG and JPEG", new String[] { "JPG", "JPEG" });
    fileChooser.setFileFilter(filter1);
    int status = fileChooser.showOpenDialog(null);
    if (status == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      System.out.println(selectedFile.getParent());
      System.out.println(selectedFile.getName());
    } else if (status == JFileChooser.CANCEL_OPTION) {
      System.out.println(JFileChooser.CANCEL_OPTION);
    }
  }
}

class ExtensionFileFilter extends FileFilter {
  String description;

  String extensions[];

  public ExtensionFileFilter(String description, String extension) {
    this(description, new String[] { extension });
  }

  public ExtensionFileFilter(String description, String extensions[]) {
    if (description == null) {
      this.description = extensions[0];
    } else {
      this.description = description;
    }
    this.extensions = (String[]) extensions.clone();
    toLower(this.extensions);
  }

  private void toLower(String array[]) {
    for (int i = 0, n = array.length; i < n; i++) {
      array[i] = array[i].toLowerCase();
    }
  }

  public String getDescription() {
    return description;
  }

  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    } else {
      String path = file.getAbsolutePath().toLowerCase();
      for (int i = 0, n = extensions.length; i < n; i++) {
        String extension = extensions[i];
        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
          return true;
        }
      }
    }
    return false;
  }
}
