import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.io.*;

public class booking extends JFrame implements ActionListener
{
	JTextField seat, totalcost;
	Choice type, block, time; // Choices for the GUI
	JLabel typelbl, blocklbl, timelbl, lblbl, mblbl, rblbl, inputseatlbl, totallbl, title;
	JButton submitbut, showbut, paybut,BACK;
	String selectedtime, total, selectedseat, selectedblock, tickettype;
	int timechoice, convertedseat1, convertedseat2, totalprice;
	int totaltickets = 0, currenti;

	Seat leftside1[][] = new Seat [4] [4];
	Seat midside1[][] = new Seat [4] [4];
	Seat rightside1[][] = new Seat [4] [4]; // Каждый из них создает массив для каждого блока

	Seat leftside3[][] = new Seat [4] [4];
	Seat midside3[][] = new Seat [4] [4];
	Seat rightside3[][] = new Seat [4] [4];

	Seat leftside5[][] = new Seat [4] [4];
	Seat midside5[][] = new Seat [4] [4];
	Seat rightside5[][] = new Seat [4] [4];

	Seat leftside7[][] = new Seat [4] [4];
	Seat midside7[][] = new Seat [4] [4];
	Seat rightside7[][] = new Seat [4] [4];

	Seat leftside9[][] = new Seat [4] [4];
	Seat midside9[][] = new Seat [4] [4];
	Seat rightside9[][] = new Seat [4] [4];

	Ticket tickets[] = new Ticket[30]; //Массив для хранения забронированных билетов

	public booking()
	{
		setSize(800,500);
		setLocation(200,200);
		setResizable(false);
		setLayout(new FlowLayout());
		ImageIcon imgtitle = new ImageIcon("pass1.png");
		title = new JLabel(imgtitle);
		typelbl = new JLabel("Ticket Type: ");
		typelbl.setFont(new Font("Verdana", Font.BOLD, 22));
		type = new Choice();
		type.add("Adult");
		type.add("Child");
		type.add("OAP");
		blocklbl = new JLabel("Block:");
		blocklbl.setFont(new Font("Verdana", Font.BOLD, 22));
		block = new Choice();
		block.add("Left Block");
		block.add("Middle Block");
		block.add("Right Block");
		timelbl = new JLabel("Time: ");
		timelbl.setFont(new Font("Verdana", Font.BOLD, 22));
		time = new Choice();
		time.add("13:00");
		time.add("15:00");
		time.add("17:00");
		time.add("19:00");
		time.add("21:00");
		paybut = new JButton("Pay");
		paybut.setBackground(Color.white);
		ImageIcon lbimg = new ImageIcon("money.png");
		lblbl = new JLabel (lbimg);
		ImageIcon mbimg = new ImageIcon("screen.png");
		mblbl = new JLabel (mbimg);
		ImageIcon rbimg = new ImageIcon("film1.png");
		rblbl = new JLabel (rbimg);
		inputseatlbl = new JLabel ("Enter Seat Num: ");
		inputseatlbl.setFont(new Font("Verdana", Font.BOLD, 22));
		seat = new JTextField(2);
		seat.setFont(new Font("Verdana", Font.BOLD, 20));
		seat.setHorizontalAlignment(seat.CENTER);
		totallbl = new JLabel ("Total Price: ");
		totallbl.setFont(new Font("Verdana", Font.BOLD, 22));
		totalcost = new JTextField(7);
		totalcost.setFont(new Font("Verdana", Font.BOLD, 22));
		totalcost.setHorizontalAlignment(totalcost.CENTER);
		totalcost.setEditable(false);
		submitbut = new JButton("Submit");
		submitbut.setBackground(Color.white);
		showbut = new JButton("Show");
        showbut.setBackground(Color.white);

		BACK = new JButton("Finish");
        BACK.setBounds(150, 0, 100, 30);
	 BACK.setFont(new Font("Serif", Font.PLAIN, 17));
         BACK.setForeground(Color.WHITE);
	 BACK.setBackground(new Color(39, 48, 57));
	 User user=new User();

	 BACK.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent a) {
			user.setVisible(true);
					
		   dispose();
		}
	});
        
		int xleft = 0;
		int yleft = 0;
		int xmid = 0;
		int ymid = 0;
		int xright = 0;
		int yright = 0;


		xleft = 50;
		yleft = 310; //Начальные позиции
		int totalleftside1 = 0; //«total» - это сумма, которая используется для обозначения мест

		for (int i = 0; i < leftside1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftside1[i][j]=new Seat(totalleftside1, 0, xleft, yleft);
				xleft += 50; //Перемещение следующего сиденья вдоль позиции х на 50
				totalleftside1 ++; //Добавление одного к общему количеству для следующего места
			}
			xleft = 50; //Возвращаясь влево для следующего ряда
			yleft += 30; //Двигаясь вниз для следующего ряда
		}

		xmid = 300;
		ymid = 310; //Начальные позиции
		int totalmidside1 = 0; 
		for (int i = 0; i < midside1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midside1[i][j]=new Seat(totalmidside1, 0, xmid, ymid);
				xmid += 50; //Перемещение следующего сиденья вдоль позиции х на 50
				totalmidside1 ++; //Добавление одного к общему количеству для следующего места
			}
			xmid = 300; //
			ymid += 30;  //
		}

		xright = 550;
		yright = 310; //
		int totalrightside1 = 0; //
		for (int i = 0; i < rightside1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightside1[i][j]=new Seat(totalrightside1, 0, xright, yright);
				xright += 50; //
				totalrightside1 ++; //
			}
			xright = 550; //
			yright += 30; //
		}

		/* Следующие строки кода выполняют те же процессы, что и предыдущие, например, позиции для каждого блока */

		xleft = 50;
		yleft = 310;
		int totalleftside3 = 0;

		for (int i = 0; i < leftside3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftside3[i][j]=new Seat(totalleftside3, 0, xleft, yleft);
				xleft += 50;
				totalleftside3 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalmidside3 = 0;
		for (int i = 0; i < midside3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midside3[i][j]=new Seat(totalmidside3, 0, xmid, ymid);
				xmid += 50;
				totalmidside3 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrightside3 = 0;
		for (int i = 0; i < rightside3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightside3[i][j]=new Seat(totalrightside3, 0, xright, yright);
				xright += 50;
				totalrightside3 ++;
			}
			xright = 550;
			yright += 30;
		}


		xleft = 50;
		yleft = 310;
		int totalleftside5 = 0;

		for (int i = 0; i < leftside5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftside5[i][j]=new Seat(totalleftside5, 0, xleft, yleft);
				xleft += 50;
				totalleftside5 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalmidside5 = 0;
		for (int i = 0; i < midside5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midside5[i][j]=new Seat(totalmidside5, 0, xmid, ymid);
				xmid += 50;
				totalmidside5 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrightside5 = 0;
		for (int i = 0; i < rightside5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightside5[i][j]=new Seat(totalrightside5, 0, xright, yright);
				xright += 50;
				totalrightside5 ++;
			}
			xright = 550;
			yright += 30;
		}


		xleft = 50;
		yleft = 310;
		int totalleftside7 = 0;

		for (int i = 0; i < leftside7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftside7[i][j]=new Seat(totalleftside7, 0, xleft, yleft);
				xleft += 50;
				totalleftside7 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalmidside7 = 0;
		for (int i = 0; i < midside7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midside7[i][j]=new Seat(totalmidside7, 0, xmid, ymid);
				xmid += 50;
				totalmidside7 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrightside7 = 0;
		for (int i = 0; i < rightside7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightside7[i][j]=new Seat(totalrightside7, 0, xright, yright);
				xright += 50;
				totalrightside7 ++;
			}
			xright = 550;
			yright += 30;
		}

		xleft = 50;
		yleft = 310;
		int totalleftside9 = 0;

		for (int i = 0; i < leftside9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftside9[i][j]=new Seat(totalleftside9, 0, xleft, yleft);
				xleft += 50;
				totalleftside9 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalmidside9 = 0;
		for (int i = 0; i < midside9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midside9[i][j]=new Seat(totalmidside9, 0, xmid, ymid);
				xmid += 50;
				totalmidside9 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrightside9 = 0;
		for (int i = 0; i < rightside9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightside9[i][j]=new Seat(totalrightside9, 0, xright, yright);
				xright += 50;
				totalrightside9 ++;
			}
			xright = 550;
			yright += 30;
		}
		/* Добавление меток и текстовых полей на экран */

		setLocationRelativeTo(null);
        setResizable(false);
		getContentPane().add(title);
		getContentPane().add(typelbl);
		getContentPane().add(type);
		getContentPane().add(blocklbl);
		getContentPane().add(block);
		getContentPane().add(timelbl);
		getContentPane().add(time);
		getContentPane().add(showbut);

		getContentPane().add(BACK);

		getContentPane().add(inputseatlbl);
		getContentPane().add(seat);
		getContentPane().add(submitbut);
		getContentPane().add(totallbl);
		getContentPane().add(totalcost);
		getContentPane().add(paybut);
		getContentPane().add(lblbl);
		getContentPane().add(mblbl);
		getContentPane().add(rblbl);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color mycolor = new Color(255,255,255);
		getContentPane().setBackground(mycolor);

		submitbut.addActionListener(this);
		showbut.addActionListener(this); // действиz для каждой отдельной кнопки
		paybut.addActionListener(this);
	}
	public void paint(Graphics graf)
	{
		super.paint(graf);

		switch(timechoice)
		{
			case 1:
				for (int i = 0; i < leftside1.length; i++) //Цикл по левой стороне на 1 блок - дает начальный размер
				{
					for (int j = 0; j < 4; j++) //Цикл по каждому ряду полностью
					{
						leftside1[i][j].display(graf); //Отображение левой стороны @ 1
						midside1[i][j].display(graf); //Отображение центральной стороны @ 1
						rightside1[i][j].display(graf); //Отображение правой стороны @ 1
					}
				}
				break;
			case 3:
				for (int i = 0; i < leftside3.length; i++) //Цикл по левой стороне на 3 блок - дает начальный размер
				{
					for (int j = 0; j < 4; j++) //Цикл по каждому ряду полностью
					{
						leftside3[i][j].display(graf); //Отображение левой стороны @ 3
						midside3[i][j].display(graf); //Отображение центральной стороны @ 3
						rightside3[i][j].display(graf); //Отображение правой стороны @ 3
					}
				}
				break;
			case 5:
				for (int i = 0; i < leftside5.length; i++) //Цикл по левой стороне на 5 блок - дает начальный размер
				{
					for (int j = 0; j < 4; j++) //
					{
						leftside5[i][j].display(graf); //Отображение левой стороны @ 5
						midside5[i][j].display(graf); //Отображение центральной стороны @ 5
						rightside5[i][j].display(graf); //Отображение правой стороны @ 5
					}
				}
				break;
			case 7:
				for (int i = 0; i < leftside7.length; i++) //Цикл по левой стороне на 7 блок - дает начальный размер
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftside7[i][j].display(graf); //Отображение левой стороны @ 7
						midside7[i][j].display(graf); //Отображение центральной стороны @ 7
						rightside7[i][j].display(graf); //Отображение правой стороны @ 7
					}
				}
				break;
			case 9:
				for (int i = 0; i < leftside9.length; i++) //Цикл по левой стороне на 9 блок - дает начальный размер
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftside9[i][j].display(graf); //Отображение левой стороны @ 9
						midside9[i][j].display(graf); //Отображение центральной стороны @ 9
						rightside9[i][j].display(graf); //Отображение правой стороны @ 9
				}}
				break;
			default:
			/* Используется как то, что появляется при запуске программы */
				for (int i = 0; i < leftside1.length; i++) 
				{
					for (int j = 0; j < 4; j++) 
					{
						leftside1[i][j].display(graf); 
						midside1[i][j].display(graf); 
						rightside1[i][j].display(graf); 
					}
				}
				break;
		}
	}
	public void actionPerformed(ActionEvent ev)
	{
		selectedblock = block.getSelectedItem(); //Значения, необходимые для бронирования мест и проверки доступности, взяты из текстовых полей
		selectedtime = time.getSelectedItem();
		tickettype = type.getSelectedItem();

		if (ev.getSource() == submitbut)
		{
			selectedseat = seat.getText();
			int selectseat = Integer.parseInt(selectedseat); //Получение номера места и преобразование его в целое число

			/* Следующий набор операторов if проверяет номер места и преобразует его
в положение X, Y, которое можно использовать для бронирования */

			if (selectseat == 0)
				{convertedseat1 = 0;
				convertedseat2 = 0;}
			if (selectseat == 1)
				{convertedseat1 = 0;
				convertedseat2 = 1;}
			if (selectseat == 2)
				{convertedseat1 = 0;
				convertedseat2 = 2;}
			if (selectseat == 3)
				{convertedseat1 = 0;
				convertedseat2 = 3;}
			if (selectseat == 4)
				{convertedseat1 = 1;
				convertedseat2 = 0;}
			if (selectseat == 5)
				{convertedseat1 = 1;
				convertedseat2 = 1;}
			if (selectseat == 6)
				{convertedseat1 = 1;
				convertedseat2 = 2;}
			if (selectseat == 7)
				{convertedseat1 = 1;
				convertedseat2 = 3;}
			if (selectseat == 8)
				{convertedseat1 = 2;
				convertedseat2 = 0;}
			if (selectseat == 9)
				{convertedseat1 =2;
				convertedseat2 = 1;}
			if (selectseat == 10)
				{convertedseat1 = 2;
				convertedseat2 = 2;}
			if (selectseat == 11)
				{convertedseat1 = 2;
				convertedseat2 = 3;}
			if (selectseat == 12)
				{convertedseat1 = 3;
				convertedseat2 = 0;}
			if (selectseat == 13)
				{convertedseat1 = 3;
				convertedseat2 = 1;}
			if (selectseat == 14)
				{convertedseat1 = 3;
				convertedseat2 = 2;}
			if (selectseat == 15)
				{convertedseat1 = 3;
				convertedseat2 = 3;}


				if (selectedtime == "13:00") //Если они пытаются забронировать билет на 1 час
				{
				timechoice = 1;
				repaint();
				if (selectedblock == "Left Block") // Если они пытаются забронировать место в левом блоке
				{
					int iftaken = leftside1[convertedseat1][convertedseat2].isTaken(); //Использует метод istaken (), чтобы увидеть, принят ли он
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); //Место занято и выводит сообщение об ошибке
					}
					else if (iftaken == 0)
					{
						leftside1[convertedseat1][convertedseat2].setSeat(); //Устанавливает место для забронированных
						repaint(); //Re-displays it
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime); //Создает новые объекты заявок в массиве заявок
						int tempprice = tickets[totaltickets].getSeatPrice(); //Получает цену места, используя метод getSeatPrice ()
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice)); //Обновляет и добавляет в текстовое поле
						totaltickets += 1; //Обновляет общее количество забронированных билетов
						seat.setText("");
					}
				}
				if (selectedblock == "Middle Block")  // Если они пытаются забронировать место в центральном блоке
				{
					int iftaken = midside1[convertedseat1][convertedseat2].isTaken(); 
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); 
					}
					else if (iftaken == 0)
					{
						midside1[convertedseat1][convertedseat2].setSeat(); 
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime); 
						int tempprice = tickets[totaltickets].getSeatPrice();  
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice)); 
						totaltickets += 1; 
						seat.setText("");
					}
				}
				if (selectedblock == "Right Block") 
				{
					int iftaken = rightside1[convertedseat1][convertedseat2].isTaken(); 
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");  
					}
					else if (iftaken == 0)
					{
						rightside1[convertedseat1][convertedseat2].setSeat(); 
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);  
						int tempprice = tickets[totaltickets].getSeatPrice(); 
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice)); 
						totaltickets += 1;
						seat.setText("");
					}
				}
			}

			/*  Код копируется для каждого раза, когда пользователь хочет забронировать*/

			if (selectedtime == "15:00")
			{
				timechoice = 3;
				repaint();

				if (selectedblock == "Left Block")
				{
					int iftaken = leftside3[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftside3[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Middle Block")
				{
					int iftaken = midside3[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midside3[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Right Block")
				{
					int iftaken = rightside3[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightside3[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}

			}
			if (selectedtime == "17:00")
			{
				timechoice = 5;
				repaint();

				if (selectedblock == "Left Block")
				{
					int iftaken = leftside5[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftside5[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Middle Block")
				{
					int iftaken = midside5[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midside5[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Right Block")
				{
					int iftaken = rightside5[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightside5[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
			}
			if (selectedtime == "19:00")
			{
				timechoice = 7;
				repaint();

				if (selectedblock == "Left Block")
				{
					int iftaken = leftside7[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftside7[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Middle Block")
				{
					int iftaken = midside7[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midside7[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Right Block")
				{
					int iftaken = rightside7[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightside7[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
			}
			if (selectedtime == "21:00")
			{
				timechoice = 9;
				repaint();

				if (selectedblock == "Left Block")
				{
					int iftaken = leftside9[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftside9[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Middle Block")
				{
					int iftaken = midside9[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midside9[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedblock == "Right Block")
				{
					int iftaken = rightside9[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightside9[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedblock, selectedtime);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("£"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
			}
		}
		if (ev.getSource() == showbut)
		{
			/* Если пользователь нажал кнопку показа, он устанавливает переменную, а затем перерисовывает желаемое время */

			if (selectedtime == "13:00")
			{
				timechoice = 1;
				repaint();
			}
			if (selectedtime == "15:00")
			{
				timechoice = 3;
				repaint();
			}
			if (selectedtime == "17:00")
			{
				timechoice = 5;
				repaint();
			}
			if (selectedtime == "19:00")
			{
				timechoice = 7;
				repaint();
			}
			if(selectedtime == "21:00")
			{
				timechoice = 9;
				repaint();
			}

		}
		if (ev.getSource() == paybut) //Кнопка оплаты для генерации билетов
		{

  				try{
  					FileWriter stream= new FileWriter("tickets.txt"); //Открытие файла tickets.txt
  					BufferedWriter output = new BufferedWriter(stream);

					for (int i = 0; i < totaltickets; i++) //Перебирая количество забронированных билетов
					{
  						/* Получение необходимых переменных из методов, связанных с объектом */

  						int ticketnum = tickets[i].getSeatNum();
						int ticketprice = tickets[i].getSeatPrice();
						String tickettype = tickets[i].getType();
						String tickettime = tickets[i].getTime();
						String ticketblock = tickets[i].getBlock();
						String newline = System.getProperty("line.separator");

						output.write(newline);
						output.write("Ticket Details");
						output.write(newline);
						output.write(newline);
						output.write("Ticket Number: " + ticketnum); //Написание ticketnum
						output.write(newline);
						output.write("Ticket Price: " + ticketprice);
						output.write(newline);
						output.write("Ticket Type: " + tickettype);
						output.write(newline);
						output.write("Ticket Time: " + tickettime);
						output.write(newline);
						output.write("Ticket Block: " + ticketblock);
						output.write(newline);
						output.write(newline);
					}
					output.close();
  					}catch (Exception e){//Catch исключение, если есть
  					System.err.println("Error: " + e.getMessage());}

  				JOptionPane.showMessageDialog(null, "These tickets have been printed out to the file 'tickets.txt'"); //Сообщение об успехе

  				for(int i=0; i < tickets.length; i++)
  				{
					tickets[i] = null; //Установка значений массива заявок на null, чтобы можно было бронировать новые билеты
				}
				totaltickets = 0; //Сбрасывает сумму билетов на 0
				totalprice = 0; //сбрасывает сумму стоймости на 0
				totalcost.setText(""); //Устанавливает общую стоимость пустого текстового поля
				seat.setText(""); //Стирает текстовое поле номера места
		}
	}
	public static void main(String args[])
	{
		new booking();

	}
}
class Seat
{
	private final int boxheight = 30; //Высота нарисованного ряда сидушек
	private final int boxwidth = 50; //ширина нарисованного ряда сидушек
	private int seatnumber;
	private int seattaken;
	private int x;
	private int y;

	public Seat(int number, int taken, int xstart, int ystart)
	{
		seatnumber = number; //Установить номера места
		seattaken = taken; //Установка, если это принято
		x = xstart; //Положение 
		y = ystart;
	}
	public void display(Graphics graf)
	{
		int xdraw, ydraw;
		switch (seattaken)
		{
		case 0:
			xdraw = x +  boxwidth;
			ydraw = y +  boxheight;
			graf.drawRect(x,y,boxwidth,boxheight);
			graf.drawString(Integer.toString(seatnumber),x+20,y+boxheight*3/4); //Покраска сиденья с номером сиденья, напечатанным внутри
			break;
		case 1:
			xdraw = x +  boxwidth;
			ydraw = y +  boxheight;
			graf.drawRect(x,y,boxwidth,boxheight);
			String msg = "N/A";
			graf.drawString(msg,x+20,y+boxheight*3/4); //Покраска сиденья с надписью N / A внутри
			break;
		default:
			break;
		}

	}
	public int isTaken()
	{
		return seattaken;
	}
	public void setSeat()
	{
		seattaken = 1;
	}
}
class Ticket
{
	private int price;
	private String tickettype;
	private int seatnum;
	private String timeticket;
	private String blockticket;


	public Ticket (String type, int seatnumber, String block, String time)
	{
		seatnum = seatnumber; //Установка билетов места
		tickettype = type; //Установка типа билета
		blockticket = block; //Установка блока
		timeticket = time; //Назначить время

		if (blockticket == "Left Block")
		{

			if (type == "Adult")
			{
				price = 5; //Установка цены для взрослых
			}
			if (type == "OAP")
			{
				price = 3; //Установка цены для студентов анау мынау
			}
			if (type == "Child")
			{
				price = 2;  //Установка цены для детей
			}
		}

		if (blockticket == "Middle Block")
		{

			if (type == "Adult")
			{
				price = 10; 
			}
			if (type == "OAP")
			{
				price = 3; 
			}
			if (type == "Child")
			{
				price = 5;  
			}
		}

		if (blockticket == "Right Block")
		{

			if (type == "Adult")
			{
				price = 5; 
			}
			if (type == "OAP")
			{
				price = 3; 
			}
			if (type == "Child")
			{
				price = 2;  
			}
		}
	}
	/* Следующие методы get используются для печати билетов */
	public int getSeatPrice()
	{
		return price;
	}
	public String getTime()
	{
		return timeticket;
	}
	public String getBlock()
	{
		return blockticket;
	}
	public String getType()
	{
		return tickettype;
	}
	public int getSeatNum()
	{
		return seatnum;
	} 
}