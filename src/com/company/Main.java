package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        int a;
        while(true){
            System.out.println("Выберите режим работы программы: 1. 20 случайных фигур. 2. Отобразить картинку по указанному пути 3. Анимация \n");
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextInt();
            switch(a){
                case 1:
                    new Create();
                    break;
                case 2:
                    System.out.println("Введите путь к искомому изображению");
                    String path = new String();
                    Scanner sc = new Scanner(System.in);
                    path = sc.nextLine();
                    new Show(path);
                    break;
                case 3:
                    new Animation();
                    break;
            }
        }
    }
    public static class Create extends JFrame {
        Circle circle;
        Square square;
        public Create() {
            setSize(1015, 840);
            setResizable(false);
            JPanel panel = new JPanel();
            JButton button = new JButton("НАЖМИ МЕНЯ");
            button.setSize(100, 20);
            panel.add(button);
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setVisible(false);
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 4; j++) {
                            int rand = (int) (Math.random() * 2);
                            switch (rand) {
                                case 0:
                                    circle = new Circle(i * 200, j * 200);
                                    add(circle);
                                    setVisible(true);
                                    break;
                                case 1:
                                    square = new Square(i * 200, j * 200);
                                    add(square);
                                    setVisible(true);
                                    break;
                            }
                        }
                    }
                }
            };
            button.addActionListener(actionListener);
            add(panel);
            setVisible(true);
        }
    }
    public static class Circle extends JComponent{
        private int x, y;
        public Circle(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void paint(Graphics graphics){
            super.paint(graphics);
            int red = (int)(Math.random()*256);
            int green = (int)(Math.random()*256);
            int blue = (int)(Math.random()*256);
            Graphics2D graphics2d = (Graphics2D)graphics;
            Color color = new Color(red, green, blue);
            graphics2d.setPaint(color);
            graphics2d.fillOval(x, y, 196, 196);
        }
    }
    public static class Square extends JComponent {
        private int x, y;
        public Square(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void paint(Graphics graphics){
            super.paint(graphics);
            int red = (int)(Math.random()*256);
            int green = (int)(Math.random()*256);
            int blue = (int)(Math.random()*256);
            Graphics2D graphics2d = (Graphics2D)graphics;
            Color color = new Color(red, green, blue);
            graphics2d.setPaint(color);
            graphics2d.fillRect(x, y, 196, 196);
        }
    }
    public static class Show extends JFrame {
        public Show(String path){
            setSize(300, 210);
            setResizable(false);
            setVisible(true);
            Graphics graphics;
            Image image;
            image = new ImageIcon(path).getImage();
            graphics = getGraphics();
            graphics.drawImage(image, 0, 30,null);
        }
    }
    public static class Animation extends JFrame {
        int width = 426, height = 243;
        JPanel pnl = new JPanel();
        public Animation() {
            setSize(width,height);
            setVisible(true);
            setResizable(false);
            Graphics graphics;
            Image image;
            ArrayList<Image> images = new ArrayList<>();
            for (int i = 0; i < 59; i++)
                images.add(new ImageIcon("C:/Program Files (x86)/Jeff/frame_" + i + "_delay-0.06s.jpg").getImage());
            while(true){
                for (int i = 0; i < 59; i++) {
                    image = images.get(i);
                    graphics = getGraphics();
                    graphics.drawImage(image,0,30, width, height,null);
                    timeDelay();
                }
            }
        }
        private void timeDelay() {
            try{
                Thread.sleep(50);
            }
            catch (InterruptedException e){}
        }
    }

}