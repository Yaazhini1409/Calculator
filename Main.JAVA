import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons=new JButton[10];
	JButton[] funcButtons=new JButton[9];
	JButton add,sub,mul,div;
	JButton dec,equal,clr,del,neg;
	JPanel panel;
	
	Font myFont =new Font("Ink Free",Font.BOLD,30);
	double num1=0;
	double num2=0;
	double result=0;
	char operator;
    Main()
    {
    	frame= new JFrame("Calculator");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(420,550);
    	frame.setLayout(null);
    	textfield=new JTextField();
    	textfield.setBounds(50,25,300,50 );
    	textfield.setFont(myFont);
    	textfield.setEditable(false);
    	neg=new JButton("(-)");
    	add=new JButton("+");
    	sub=new JButton("-");
    	mul=new JButton("*");
    	div=new JButton("/");
    	dec=new JButton(".");
    	equal=new JButton("=");
    	del=new  JButton("Del");
    	clr=new JButton("Clr");
    	funcButtons[0]=add;
    	funcButtons[1]=sub;
    	funcButtons[2]=mul;
    	funcButtons[3]=div;
    	funcButtons[4]=dec;
    	funcButtons[5]=equal;
    	funcButtons[6]=del;
    	funcButtons[7]=clr;
    	funcButtons[8]=neg;
    	for(int i=0;i<9;i++)
    	{
    		funcButtons[i].addActionListener(this);
    		funcButtons[i].setFont(myFont);
    		funcButtons[i].setFocusable(false);
    	}
    	for(int i=0;i<10;i++)
    	{
    		numberButtons[i]=new JButton(String.valueOf(i));
    		numberButtons[i].addActionListener(this);
    		numberButtons[i].setFont(myFont);
    		numberButtons[i].setFocusable(false);
    	}
    	neg.setBounds(50,430,100,50);
    	del.setBounds(150, 430, 100, 50);
    	clr.setBounds(250, 430, 100, 50);
    	panel=new JPanel();
    	panel.setBounds(50,100,300,300);
    	panel.setLayout(new GridLayout(4,4,10,10));
    	panel.add(numberButtons[1]);
    	panel.add(numberButtons[2]);
    	panel.add(numberButtons[3]);
    	panel.add(add);
    	panel.add(numberButtons[4]);
    	panel.add(numberButtons[5]);
    	panel.add(numberButtons[6]);
    	panel.add(sub);
    	panel.add(numberButtons[7]);
    	panel.add(numberButtons[8]);
    	panel.add(numberButtons[9]);
    	panel.add(mul);
    	panel.add(dec);
    	panel.add(numberButtons[0]);
    	panel.add(equal);
    	panel.add(div);
    	
    	
    	
    	
    	frame.add(panel);
    	frame.add(neg);
    	frame.add(clr);
    	frame.add(del);
    	frame.add(textfield);
    	frame.setVisible(true);
    }
	public static void main(String[] args) {
		Main ma=new Main();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==numberButtons[i])
			{
				textfield.setText(textfield.getText().concat(toString().valueOf(i)));
			}
		}
		if(e.getSource()==dec)
		{
			textfield.setText(textfield.getText().concat(toString().valueOf(".")));
		}
		if(e.getSource()==add)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='+';
			textfield.setText("");
			
		}
		if(e.getSource()==sub)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='-';
			textfield.setText("");
			
		}
		if(e.getSource()==mul)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='*';
			textfield.setText("");
			
		}
		if(e.getSource()==div)
		{
			num1=Double.parseDouble(textfield.getText());
			operator='/';
			textfield.setText("");
			
		}
		if(e.getSource()==equal)
		{
			num2=Double.parseDouble(textfield.getText());
			switch(operator)
			{
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case '*':
				result=num1*num2;
				break;
			case '/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clr)
		{
			textfield.setText("");
		}
		if(e.getSource()==del)
		{
			String string=textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++)
			{
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==neg)
		{
			double temp=Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}

}
