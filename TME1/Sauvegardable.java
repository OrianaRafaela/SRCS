package srcs.persistance;

import java.io.InputStream;
import java.io.OutputStream;

public interface Sauvegardable {
	public abstract void save(OutputStream out) ;
}
