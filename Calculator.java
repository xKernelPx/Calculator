package cal;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener{
	private JButton delBtn, clearBtn;
	private JButton NumberBtn[];
	private JButton functionBtn[];
	private JButton Add_btn, Sub_btn, Mul_btn, Div_btn, equalBtn, decBtn;
	private JPanel panel;
	private JTextField text;

	private double number, result = 0, current, temp = 0;
	private char operator = ' ', double_equal_operator = ' ';
	private int x = 0;
	private String del= "", str = "";
	private boolean double_equal = false, number_entered = false;
	public static String removeSuffix(String str, String suffix)
	{
		return str.endsWith(suffix) ? str.substring(0, str.length() - suffix.length()) : str;
	}
	public Calculator(){
		initialize();
	}

	private void initialize(){
		this.setSize(new Dimension(300, 420));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		text = new JTextField();
		text.setSize(new Dimension(250, 40));
		text.setLocation(new Point(20, 20));
		text.setFont(new Font("Orbitron", Font.PLAIN, 20));
		text.setEditable(false);
		text.setForeground(Color.black);
		text.setHorizontalAlignment(JTextField.RIGHT);

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		panel.setSize(new Dimension(250, 250));
		panel.setLocation(new Point(20, 70));

		Add_btn = new JButton("+");
		Sub_btn = new JButton("-");
		Mul_btn = new JButton("*");
		Div_btn = new JButton("/");
		equalBtn = new JButton("=");
		decBtn = new JButton(".");

		clearBtn = new JButton("CE");
		clearBtn.setLocation(new Point(20, 330));

		functionBtn = new JButton[8];

		functionBtn[0] = Add_btn;
		functionBtn[1] = Sub_btn;
		functionBtn[2] = Mul_btn;
		functionBtn[3] = Div_btn;
		functionBtn[4] = equalBtn;
		functionBtn[5] = clearBtn;
		functionBtn[6] = decBtn;

		for(int i = 0; i < 7; i++){
			functionBtn[i].setFocusable(false);
			functionBtn[i].setVerticalTextPosition(JButton.CENTER);
			functionBtn[i].setHorizontalTextPosition(JButton.CENTER);
			functionBtn[i].setSize(new Dimension(100, 30));
			functionBtn[i].addActionListener(this);
			functionBtn[i].setForeground(Color.black);
		}

		NumberBtn = new JButton[10];

		for(int i= 0; i < 10; i++){
			NumberBtn[i] = new JButton(String.valueOf(i));
			NumberBtn[i].setFocusable(false);
			NumberBtn[i].setSize(new Dimension(10, 10));
			NumberBtn[i].setVerticalTextPosition(JButton.CENTER);
			NumberBtn[i].setHorizontalTextPosition(JButton.CENTER);
			NumberBtn[i].addActionListener(this);
			NumberBtn[i].setForeground(Color.black);
		}

		panel.add(NumberBtn[7]);
		panel.add(NumberBtn[8]);
		panel.add(NumberBtn[9]);
		panel.add(functionBtn[0]);

		panel.add(NumberBtn[4]);
		panel.add(NumberBtn[5]);
		panel.add(NumberBtn[6]);
		panel.add(functionBtn[1]);

		panel.add(NumberBtn[1]);
		panel.add(NumberBtn[2]);
		panel.add(NumberBtn[3]);
		panel.add(functionBtn[2]);

		panel.add(functionBtn[6]);
		panel.add(NumberBtn[0]);
		panel.add(functionBtn[4]);
		panel.add(functionBtn[3]);

		this.add(functionBtn[5]);
		this.add(text);
		this.add(panel);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	private void operation(char opt, double curr){		
			switch(opt){
				case '+':
					result = number + curr;
					break;

				case '-':
					result = number - curr;
					break;

				case '*':
					result = number * curr;
					break;

				case '/':
					result = number / curr;
					break;
			}
			text.setText(removeSuffix(String.valueOf(result), ".0"));
			number_entered = false;
			temp = result;
			x = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		//flag = false;		

		if(e.getSource() == functionBtn[0]){//addition
			if (!text.getText().isEmpty()) {
				current = Double.valueOf(text.getText());
				if(operator != ' ' && operator != '+' && !double_equal && number_entered){
					operation(operator, current);
					operator = ' ';
				}

				current = Double.valueOf(text.getText());

				if(x == 0){
					temp = current;
					number = temp;
					operator = '+';
					x = 1;
				}
				else if (number_entered) {
					number = temp;				
					result = number + current;
					text.setText(removeSuffix(String.valueOf(result), ".0"));
					temp = result;
					x = 1;
				}
				else
				{
					operator = '+';
				}
				number_entered = false;
			}			
		}

		if(e.getSource() == functionBtn[1]){//substration
			if(!text.getText().isEmpty()){
				current = Double.valueOf(text.getText());
				if(operator != ' ' && operator != '-' && !double_equal && number_entered){
					operation(operator, current);
					operator = ' ';
				}

				current = Double.valueOf(text.getText());

				if(x == 0){
					temp = current;
					number = temp;
					operator = '-';
					x = 1;

				}
				else if (number_entered) {
					number = temp;				
					result = number - current;
					text.setText(removeSuffix(String.valueOf(result), ".0"));
					temp = result;
					x = 1;
				}
				else
				{
					operator = '-';
				}
				number_entered = false;
			}			
		}

		if(e.getSource() == functionBtn[2]){//multiplication
			if(!text.getText().isEmpty()){
				current = Double.valueOf(text.getText());
				if(operator != ' ' && operator != '*' && !double_equal && number_entered){
					operation(operator, current);
					operator = ' ';
				}

				current = Double.valueOf(text.getText());

				if(x == 0){
					temp = current;
					number = temp;
					operator = '*';
					x = 1;
				}
				else if (number_entered) {
					number = temp;				
					result = number * current;
					text.setText(removeSuffix(String.valueOf(result), ".0"));
					temp = result;
					x = 1;
				}
				else
				{
					operator = '*';
				}
				number_entered = false;
			}			
		}

		if(e.getSource() == functionBtn[3]){//division
			if(!text.getText().isEmpty()){
				current = Double.valueOf(text.getText());
				if(operator != ' ' && operator != '/' && !double_equal && number_entered){
					operation(operator, current);
					operator = ' ';
				}

				current = Double.valueOf(text.getText());

				if(x == 0){
					temp = current;
					number = temp;
					operator = '/';
					x = 1;
				}
				else if (number_entered) {
					number = temp;				
					result = number / current;
					text.setText(removeSuffix(String.valueOf(result), ".0"));
					temp = result;
					x = 1;
				}
				else
				{
					operator = '/';
				}
				number_entered = false;
			}		
		}

		if(e.getSource() == functionBtn[4]){// equals operation	
			if(!text.getText().isEmpty()){
				if (!double_equal)
				{
					current = Double.valueOf(text.getText());
					operation(operator, current);
					double_equal_operator = operator;
					operator = ' ';
					number = temp;
					double_equal = true;
				}
				else
				{
					operation(double_equal_operator, current);
					number = temp;
				}
			}			
		}
		else {
			double_equal = false;
		}

		if(e.getSource() == functionBtn[5]){// clear function
			result = 0;
			x = 0;
			temp = 0;
			number = 0;
			operator = ' ';
			number_entered = false;
			text.setText("");
		}

		if(e.getSource() == functionBtn[6]){ // decimal function
				if(x == 1){
					text.setText("");

					if(!text.getText().contains(".")){
						text.setText(text.getText().concat("."));
					}

					x = 0;
				}else{
					if(!text.getText().contains(".")){
						text.setText(text.getText().concat("."));
					}
				}
			
		}

		for(int i = 0; i < 10; i++){ // number button
			if(e.getSource() == NumberBtn[i]){
				if(x == 1){
					text.setText("");
					text.setText(text.getText().concat(String.valueOf(i)));
					x = 2;
				}else{
					text.setText(text.getText().concat(String.valueOf(i)));
				}
				number_entered = true;
				
			}
		}

	}

	public static void main(String args[]){
		new Calculator();
	}

}