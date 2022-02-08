package srcs.persistance;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import srcs.banque.Compte;

public class PersistanceTools {

	public static void saveArrayInt(String f, int[] tab) throws IOException{
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		out.writeInt(tab.length);
		for(int i=0; i<tab.length; i++) {
			out.writeInt(tab[i]);
		}
		out.flush();
		out.close();
	}
	
	public static int[] loadArrayInt(String fichier) throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream(fichier));
		int length = in.readInt();
		int[] tab = new int[length];
		for(int i=0; i<length; i++) {
			int x = in.readInt();
			if(x == -1) {
				in.close();
				return tab;
			}
			tab[i] = x;
		}
		in.close();
		return tab;
	}
	
	public static void saveCompte(String f, Compte e) throws IOException {
		OutputStream out = new FileOutputStream(f);
		e.save(out);
		out.flush();
		out.close();
	}
	
	public static Compte loadCompte(String f) throws IOException {
		InputStream in = new FileInputStream(f);
		Compte c = new Compte(in);
		in.close();
		return c;
	}
}
