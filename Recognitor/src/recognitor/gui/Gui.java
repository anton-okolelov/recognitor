
package recognitor.gui;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;

public class Gui extends javax.swing.JFrame implements Runnable {

    private JButton selectFileButton;
    
    public Gui() {
        initComponents();
    }
                   
    private void processFile(File file) {
        System.out.println(file.getName());
    }
    
    private void initComponents() {

        selectFileButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        selectFileButton.setText("Select File");

        JFileChooser fileChooser = new JFileChooser();
        
        selectFileButton.addActionListener((ActionEvent event) -> {
            int result = fileChooser.showDialog(null, "Select File");
            if (result == JFileChooser.APPROVE_OPTION) {
                processFile(fileChooser.getSelectedFile());
            }
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(selectFileButton)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(selectFileButton)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }
                   

    @Override
    public void run() {
        setVisible(true);
    }
}