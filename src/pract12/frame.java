package pract12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class frame extends JFrame {
    public frame(){
        super("Application");
        JTextPane textEditor = new JTextPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu newMenu = new JMenu("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        JMenuItem textItem = new JMenuItem("Text");
        JMenuItem imageItem = new JMenuItem("Image");
        JMenuItem musicItem = new JMenuItem("Music");
        newMenu.add(textItem);
        newMenu.add(imageItem);
        newMenu.add(musicItem);
        menuBar.add(fileMenu);
        frame.this.setJMenuBar(menuBar);
        getContentPane().add(new JScrollPane(textEditor));

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser saveFile = new JFileChooser();
                saveFile.showSaveDialog(null);
                File file = new File("");
                file = saveFile.getSelectedFile();
                try(FileWriter writer = new FileWriter(file)) {
                    char [] buf = new char [(int) file.length()];
                    writer.write(textEditor.getText());
                    writer.flush();
                }
                catch (Exception exception){}
            }
        });
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser openFile = new JFileChooser();
                openFile.showOpenDialog(null);
                File file = new File("");
                file = openFile.getSelectedFile();
                try(FileReader reader = new FileReader(file)){
                    //считываем файл как есть
                    //вначале задаем какой нибудь буфер(временная переменная), для хранения этого файла
                    //[]- так как это массив buf - имя переменнной(временная переменная), т.к массив динамический
                    //нужно указать на это - new; потом пишем размер массива типа int он равен file
                    char [] buf = new char [(int) file.length()];
                    reader.read(buf); //считываем данные и заносим в переменную buf
                    textEditor.setText(new String(buf));  //выводим текст (массив символов) - конвертируем в строки


                } catch (Exception exception){

                }
            }
        });
        textItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               textEditor.setText("");
            }
        });
    }
}
