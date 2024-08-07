import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    JLabel display;
    JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,plus,sub,div,mul,point,equals,clear,back;


    SimpleCalculator(){
        display = new JLabel("0");
        display.setBounds(30,20,230,30);
        display.setOpaque(true);
        display.setBackground(Color.WHITE);
        display.setForeground(Color.BLACK);


        btn7 = new JButton("7");
        btn7.setBounds(30,60,50,50);
        btn7.addActionListener(this);

        btn8 = new JButton("8");
        btn8.setBounds(90,60,50,50);
        btn8.addActionListener(this);

        btn9 = new JButton("9");
        btn9.setBounds(150,60,50,50);
        btn9.addActionListener(this);

        div = new JButton("/");
        div.setBounds(210,60,50,50);
        div.addActionListener(this);

        btn4 = new JButton("4");
        btn4.setBounds(30,120,50,50);
        btn4.addActionListener(this);

        btn5 = new JButton("5");
        btn5.setBounds(90,120,50,50);
        btn5.addActionListener(this);

        btn6 = new JButton("6");
        btn6.setBounds(150,120,50,50);
        btn6.addActionListener(this);

        mul = new JButton("*");
        mul.setBounds(210,120,50,50);
        mul.addActionListener(this);

        btn1 = new JButton("1");
        btn1.setBounds(30,180,50,50);
        btn1.addActionListener(this);

        btn2 = new JButton("2");
        btn2.setBounds(90,180,50,50);
        btn2.addActionListener(this);

        btn3 = new JButton("3");
        btn3.setBounds(150,180,50,50);
        btn3.addActionListener(this);

        sub = new JButton("-");
        sub.setBounds(210,180,50,50);
        sub.addActionListener(this);

        btn0 = new JButton("0");
        btn0.setBounds(30,240,50,50);
        btn0.addActionListener(this);

        point = new JButton(".");
        point.setBounds(90,240,50,50);
        point.addActionListener(this);

        equals = new JButton("=");
        equals.setBounds(150,240,50,50);
        equals.addActionListener(this);

        plus = new JButton("+");
        plus.setBounds(210,240,50,50);
        plus.addActionListener(this);

        clear = new JButton("AC");
        clear.setBounds(70,310,70,30);
        clear.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(170,310,70,30);
        back.addActionListener(this);

        add(display);
        add(btn0);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(plus);
        add(sub);
        add(div);
        add(mul);
        add(point);
        add(equals);
        add(clear);
        add(back);

        setSize(320,400);
        setLayout(null);
        setTitle("Calculator");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = display.getText();
        if(e.getSource() == btn0){
            expression += "0";
            display.setText(expression);
        }
        else if(e.getSource() == btn1){
            expression += "1";
            display.setText(expression);
        }
        else if(e.getSource() == btn2){
            expression += "2";
            display.setText(expression);
        }
        else if(e.getSource() == btn3){
            expression += "3";
            display.setText(expression);
        }
        else if(e.getSource() == btn4){
            expression += "4";
            display.setText(expression);
        }
        else if(e.getSource() == btn5){
            expression += "5";
            display.setText(expression);
        }
        else if(e.getSource() == btn6){
            expression += "6";
            display.setText(expression);
        }
        else if(e.getSource() == btn7){
            expression += "7";
            display.setText(expression);
        }
        else if(e.getSource() == btn8){
            expression += "8";
            display.setText(expression);
        }
        else if(e.getSource() == btn9){
            expression += "9";
            display.setText(expression);
        }
        else if(e.getSource() == plus){
            expression += "+";
            display.setText(expression);
        }
        else if(e.getSource() == sub){
            expression += "-";
            display.setText(expression);
        }
        else if(e.getSource() == mul){
            expression += "*";
            display.setText(expression);
        }
        else if(e.getSource() == div){
            expression += "/";
            display.setText(expression);
        }
        else if(e.getSource() == point) {
            expression += ".";
            display.setText(expression);
        }
        else if(e.getSource() == equals){
            int i = 0;
            String tempNum1 = "";
            String tempNum2 = "";
            float num1, num2;
            char operator = '+';
            for(i=0;i<expression.length();i++){
                if(expression.charAt(i)=='.' || Character.isDigit(expression.charAt(i))){
                    tempNum1 += expression.charAt(i);
                }
                else{
                    operator = expression.charAt(i);
                    break;
                }
            }
            tempNum2 = expression.substring(i+1);
            num1 = Float.parseFloat(tempNum1);
            num2 = Float.parseFloat(tempNum2);
            float result = 0;
            boolean flag = false;
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if(num2!=0) {
                        result = num1 / num2;
                    }
                    else{
                        flag = true;
                    }
                    break;
            }

            if(flag){
                display.setText("Can't divide by zero");
            }
            else {
                boolean isDecimal = false;

                String strResult = String.valueOf(result);
                String[] exp = strResult.split("\\.");
                String afterDecimal = exp[1];

                for(int j=0;j<afterDecimal.length();j++){
                    if(afterDecimal.charAt(j)>'0'){
                        isDecimal = true;
                        break;
                    }
                }
                if(isDecimal){
                    display.setText(String.valueOf(result));
                }
                else {
                    int res = Integer.parseInt(exp[0]);
                    display.setText(String.valueOf(res));
                }
            }

        }
        else if(e.getSource() == clear){
            display.setText("0");
        }
        else if(e.getSource() == back){
            String exp = display.getText();
            exp = exp.substring(0,exp.length()-1);
            display.setText(exp);
        }

    }


}
