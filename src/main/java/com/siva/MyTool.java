import javax.swing.*;

/**
 * This is very simple tool to convert String to and from UPPER or LOWER Case.
 * A simple showInputDialog example.
 * @auther Siva Kalidasan (pkt.siva@gmail.com)
 */
public class MyTool
{
  public static final String[] options = { "ToLowerCase", "ToUpperCase", "ToCamelCase"};

  public static void main(String[] args)
  {
    JFrame frame = new JFrame("MyTools");

	JTextArea toConvertTa = new JTextArea(5, 20);
	toConvertTa.setText("");
	toConvertTa.setLineWrap(true);
	toConvertTa.setEditable(true);
	   
	JOptionPane.showMessageDialog(frame, new JScrollPane(toConvertTa),"Enter the String to convert to Upper or Lover case?", JOptionPane.INFORMATION_MESSAGE);
	
	String toBeConverted = toConvertTa.getText();
	String option = (String) JOptionPane.showInputDialog(frame, 
        "Convert the value ",
        "Convert",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        options, 
        options[0]);
		
	String converterStr = "Cannot be converted.";
	
	if(option != null && "ToUpperCase".equals(option)){
		converterStr = toBeConverted.toUpperCase();
	} else if(option != null && "ToLowerCase".equals(option)){
		converterStr = toBeConverted.toLowerCase();
	} else if(option != null && "ToCamelCase".equals(option)){
		converterStr = toBeConverted;
	}	
	
	JLabel jl = new JLabel();
	jl.setText(toBeConverted);
	
	JTextArea from = new JTextArea(10, 10);
	from.setText(toBeConverted);
	from.setLineWrap(true);
	from.setEditable(false);
	
	JTextArea to = new JTextArea(10, 10);
	to.setText(converterStr);
	to.setLineWrap(true);
	to.setEditable(false);
	
	JTextField jt = new JTextField();
	jt.setText(converterStr);
	jt.setEditable(false);
	
	JLabel jl2 = new JLabel();
	jl2.setText(option);
	
	JPanel pContainer = new JPanel();
	pContainer.add(from);
	pContainer.add(jl2);
	pContainer.add(to);
	
    JOptionPane.showMessageDialog(frame, new JScrollPane(pContainer), option + " as ", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0); 
  }
}
