package faplib;

import static faplib.frmStage.jTableStage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 * <b>code permettant la sauvegarde d'une jtable dans un fichier</b> 
 * @see save
 * @author LoliveSerious
 * @version 1.0 
 */
public class Save {
    public static void Save() throws IOException{
        try{
        File file = new File("BDD.csv");
        FileWriter fr = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fr);
        //bw.write("qsmdlfkjmlqksdf");
        
        DefaultTableModel mode = (DefaultTableModel) jTableStage.getModel();
        for (int i = 0; i < mode.getRowCount();i++){
            for(int j = 0; j < mode.getColumnCount(); j++){
                bw.append(mode.getValueAt(i, j).toString()+";");
            }
            bw.append("\n");
        }
        
        //String[] fe = te.split(",");  // {   "[1",   " fda",   " f",   " dz]"   }
        //String writing = "";
//        for (String var : fe){
//            writing+= var + ";";
//        }
//        bw.write(writing);
        
        //bw.write("");
        bw.close();
        fr.close();
        
        }
        catch(FileNotFoundException e){
        e.printStackTrace();
        }
        catch(IOException ev){
        ev.printStackTrace();
        }
    }
    
    public static void main(String args[]) throws IOException {
        Save();
    }
}
