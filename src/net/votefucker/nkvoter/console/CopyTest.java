
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.votefucker.nkvoter.Main;
 
public class CopyTest extends JFrame {
        public static final Main NKVoter = new Main();
 
	JTextArea txt = new JTextArea();
	JScrollPane scrolltxt = new JScrollPane(txt);
 
	public CopyTest() {
 
		setLayout(null);
 
		scrolltxt.setBounds(3, 3, 700, 400);
		add(scrolltxt);		
	}
        
        
 
 
	public static void main(String[] args) {
                
		CopyTest sta = new CopyTest();
                sta.txt.append("BLA");
		sta.setSize(700,400);
		sta.setTitle("Test");
		sta.show();	
      try {
      Main.main();
      } catch (Exception e) {}
	}
 
}