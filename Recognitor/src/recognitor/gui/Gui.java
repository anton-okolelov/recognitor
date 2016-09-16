/**
 * Главное окно приложения
 */

package recognitor.gui;
import java.awt.event.ActionEvent;
import javax.swing.*;
import recognitor.processor.Processor;

public class Gui extends javax.swing.JFrame implements Runnable {

    private JButton selectFileButton;
    private JButton prepareSoundData;
    
    public Gui() {
        initComponents();
    }
    
    private void initComponents() {

        selectFileButton = new JButton();
        selectFileButton.setText("Select File");
        JFileChooser fileChooser = new JFileChooser();
        selectFileButton.addActionListener((ActionEvent event) -> {
            int result = fileChooser.showDialog(null, "Select File");
            if (result == JFileChooser.APPROVE_OPTION) {
                new Processor().process(fileChooser.getSelectedFile());  
            }
        });
        
        prepareSoundData = new JButton();
        prepareSoundData.setText("Prepare sound data");
        prepareSoundData.addActionListener((ActionEvent event) -> {
            System.out.println("ok");
        });
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(selectFileButton)
                .addComponent(prepareSoundData)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(prepareSoundData)
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