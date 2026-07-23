package EditorTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ArchivoTexto {
    private String ruta;
    private String[] lineas;

    public ArchivoTexto() {
        this.ruta = "";
        this.lineas = new String[500];
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean abrir(File archivo) {
        if (archivo == null) {
            return false;
        }

        for (int i = 0; i < 500; i++) {
            lineas[i] = null;
        }

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            int i = 0;

            while (linea != null && i < 500) {
                lineas[i] = linea;
                i = i + 1;
                linea = br.readLine();
            }

            br.close();
            fr.close();

            this.ruta = archivo.getAbsolutePath();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean guardar(File archivo, String textoCompleto) {
        if (archivo == null) {
            return false;
        }

        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(textoCompleto);

            bw.close();
            fw.close();

            this.ruta = archivo.getAbsolutePath();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerTextoUnido() {
        String texto = "";
        for (int i = 0; i < 500; i++) {
            if (lineas[i] != null) {
                texto = texto + lineas[i] + "\n";
            }
        }
        return texto;
    }
}