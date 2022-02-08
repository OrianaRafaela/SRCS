package srcs.banque;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Compte {

	
	
	private final String id;
	private double solde;
	

	public Compte(String id) {
		this.id=id;	
		this.solde=0.0;
	}
		
	public String getId() {
		return id;
	}

	public double getSolde() {
		return solde;
	}

	public void crediter(double montant) {
		solde += montant;
	}

	public void debiter(double montant) {
		solde -= montant;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Compte)) return false;
		Compte other= (Compte) o;
		return other.id.equals(id);
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	public void save(OutputStream out) throws IOException{
		DataOutputStream dout = new DataOutputStream(out);
		dout.writeInt(this.id.length());
		dout.writeChars(this.id);
		dout.writeDouble(this.solde);
		dout.flush();
		dout.close();
	}
	
	public Compte(InputStream in) throws IOException{
		DataInputStream din = new DataInputStream(in);
		int length = din.readInt();
		String id2 ="";
		for(int i=0; i<length; i++) {
			id2 = id2 + din.readChar();
		}
		this.id = id2;
		this.solde = din.readDouble();
	}
	
}
