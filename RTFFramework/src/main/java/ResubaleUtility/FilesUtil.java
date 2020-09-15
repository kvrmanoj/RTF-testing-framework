package ResubaleUtility;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class FilesUtil {

	public static InputStream getInputStream(String file) {
		 
		InputStream inputstream=null;
		
		try {
	    	Path f= Paths.get(file);
		    if(Files.exists(f)) {
		    	inputstream=Files.newInputStream(f);
		    }
		    else {
		    	URL url=ClassLoader.getSystemResource(file);
		    	if(url!=null)
		    	{
		    		inputstream=Files.newInputStream(Paths.get(url.toURI()));
		    	}
		    	else {
		    		return new URL(file).openStream();
		    	}
		    }
		}
		
		catch(IOException e) {
			
		}
		catch(URISyntaxException e) {
			
		}
		return  inputstream;
	}
}
