import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args){
		/*try{
			String s;
			String[] cmdline = {"sh", "-c", "echo $((2+3))"};
			Process p = Runtime.getRuntime().exec(cmdline);
			
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			while( (s = br.readLine()) != null)
				System.out.println(s);
			p.waitFor();
			p.destroy();
		} catch (Exception e) {}*/
		
		runSSH("c133-25", "echo $((2+3))");
	}
	
	public static void runSSH(String machine, String cmd){
		String s = null;
        try{
          String[] cmdline = {"sh", "-c", "ssh " + machine + " '" + cmd + "'"};
          Process p = Runtime.getRuntime().exec(cmdline);
          BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

          BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
          while ((s = stdInput.readLine()) != null) {
              System.out.println(s);
          }
          while ((s = stdError.readLine()) != null) {
              System.out.println(s);
          }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
	}

}
