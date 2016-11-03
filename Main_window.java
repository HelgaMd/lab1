package calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Main_window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_window frame = new Main_window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Summ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String enter_data = textField_1.getText();
				String []str = enter_data.split("\\\\n");
			    char []ch = str[0].toCharArray();
			    String [] delimeters = {" "," "," "," "," "};
			    int cnt = 3;
			    int i = 0;
			    if ((ch[0]=='/')&&(ch[1]=='/'))
			    {
			    	if (ch[2]=='[')
			    	{
			    		while ((cnt != str[0].length()-1))
			    		{
			    			if (ch[cnt] == ']')
			    			{
			    				i++;
			    				cnt = cnt+2;
			    			}
			    			delimeters[i] = delimeters[i]+ch[cnt];
			    			cnt++;		    			
			    		}
			    		Pattern p = Pattern.compile("\\[([^\\]]*)\\]");
			    		Matcher m = p.matcher (enter_data);
			    		String str1="";
			    		 if (m.find ())
			    		 {
			    			 str1 = m.group(1);
			    			 while (m.find()) str1 +="|"+m.group(1);
			    		 }
			    	        //  System.out.println(str1);
			    		 
			    		 int sum = add(str[1],str1);
					    	String data_out = Integer.toString(sum);
							textField.setText(data_out);
			    		
			    	}
			    	else
			    	{
			    	String long_delim = str[0].substring(2);
			    	int sum = add(str[1],long_delim);
			    	String data_out = Integer.toString(sum);
					textField.setText(data_out);
			    	}
			    }
			    else
			    {
				int sum = add(enter_data);
				String data_out = Integer.toString(sum);
				textField.setText(data_out);
			    }
				
			}
		});
		contentPane.add(btnNewButton, BorderLayout.EAST);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, BorderLayout.WEST);
		textField_1.setColumns(10);
	}
	public int add(String numbers)
	{
		int sum = 0;
        if (numbers.length()==0)
        {
        	return 0;
        }
	   
		else 
		{
	    String [] arr=numbers.split(",|\\\\n");
	    
		for (int i = 0;i<arr.length;i++)
		{
			
			sum = sum +Integer.parseInt(arr[i]);
		}
		}
		return sum;
	}
	public int add(String numbers,String long_delim)
	{
		int sum = 0;
	    String [] arr=numbers.split(long_delim);
	    ArrayList<Integer> negativeList=new ArrayList<Integer>();
		for (int i = 0;i<arr.length;i++)
		{
			int num = Integer.parseInt(arr[i]);
			if (num < 0)
            negativeList.add(num);
			if (num>1000)
				continue;
			sum = sum +Integer.parseInt(arr[i]);
		}
		 if (negativeList.size() > 0) {
			  throw new RuntimeException("Negatives not allowed: " + negativeList.toString());
		   } 
		return sum;
	}

}
class MyException extends Exception {
	         MyException(String msg){
	         super(msg);
	     }
	 }
