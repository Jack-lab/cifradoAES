package org.example;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncriptadoAES {

    public static void main(String[] args) {
        try {
            final String claveEncriptacion1 = "Clave-Hiper-Secreta321%$#@";
            final String claveEncriptacion2 = "Clave-Hiper-Secreta567~!@#";
            //String userNAme = "ChawarMan";
            System.out.println("Username a encriptar: ");
            String userNAme = ( new BufferedReader(new InputStreamReader(System.in))).readLine();
            //String passWord = "Hola-Mundo-Soy-Una-Cadena-Para-Encriptar-#%$&";
            System.out.println("Password a encriptar: ");
            String passWord = ( new BufferedReader(new InputStreamReader(System.in))).readLine();

            EncriptadorAES encriptador = new EncriptadorAES();

            String encriptado1 = encriptador.encriptar(userNAme, claveEncriptacion1);
            String encriptado2 = encriptador.encriptar(passWord, claveEncriptacion2);
            String desencriptado1 = encriptador.desencriptar(encriptado1, claveEncriptacion1);
            String desencriptado2 = encriptador.desencriptar(encriptado2, claveEncriptacion2);

            System.out.println("UserName Original       : " + userNAme);
            System.out.println("UserName Encriptado     : " + encriptado1);
            System.out.println("UserName Desencriptado  : " + desencriptado1);
            System.out.println("");
            System.out.println("passWord Original       : " + passWord);
            System.out.println("passWord Encriptado     : " + encriptado2);
            System.out.println("passWord Desencriptado  : " + desencriptado2);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException |
                 NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(EncriptadoAES.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
