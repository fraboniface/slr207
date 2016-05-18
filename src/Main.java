import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args){
		try{
			String s;
			String[] cmdline = {"sh", "-c", "echo $((2+3))"};
			Process p = Runtime.getRuntime().exec(cmdline);
			
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			while( (s = br.readLine()) != null)
				System.out.println(s);
			p.waitFor();
			p.destroy();
		} catch (Exception e) {}
	}

}
