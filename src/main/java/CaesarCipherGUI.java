import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarCipherGUI extends JFrame {
    private JTextField offsetField;
    private JTextArea messageField, encryptedMessageField, decryptedMessageField, messageToDecipherField;
    private CaesarCipher cipher;


    public CaesarCipherGUI() {
        cipher = new CaesarCipher();

        JPanel caesarCipherPanel = new JPanel();
        JPanel offsetPanel = new JPanel();

        JMenuBar menuBar = new JMenuBar();
        JMenu caesarCipherMenu = new JMenu("Caesar Cipher");
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
                clear();
            }
        });
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });

        caesarCipherMenu.add(clear);
        caesarCipherMenu.add(quit);
        menuBar.add(caesarCipherMenu);
        this.setJMenuBar(menuBar);

        JLabel messageLabel = new JLabel("Message:");
        JPanel messagePanel = new JPanel();
        messagePanel.add(messageLabel);

        JLabel encryptedMessageLabel = new JLabel("Encrypted Message:");
        JPanel encryptedMessagePanel = new JPanel();
        encryptedMessagePanel.add(encryptedMessageLabel);

        JLabel decryptedMessageLabel = new JLabel("Decipher:");
        JPanel decryptedMessagePanel = new JPanel();
        decryptedMessagePanel.add(decryptedMessageLabel);

        JLabel messageToDecipherLabel = new JLabel("Enter text to decipher:");
        JPanel messageToDecipherPanel = new JPanel();
        messageToDecipherPanel.add(messageToDecipherLabel);

        JLabel offsetLabel = new JLabel("Offset:");

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                if(!getMessage().isEmpty() && !getOffset().isEmpty() && validateOffset(getOffset())) {
                    setEncryptedMessage(cipher.cipher(getMessage(), Integer.parseInt(getOffset())));
                }
            }
        });

        JButton decipherButton = new JButton("Decipher");
        decipherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDecryptedMessage(cipher.decipher(getMessageToDecipherField(), Integer.parseInt(getOffset())));
            }
        });

        messageField = new JTextArea("Enter the message here!");
        messageField.setColumns(20);
        messageField.setLineWrap(true);
        messageField.setRows(5);
        messageField.setWrapStyleWord(true);

        messageToDecipherField = new JTextArea("Enter message to decipher!");
        messageToDecipherField.setColumns(20);
        messageToDecipherField.setLineWrap(true);
        messageToDecipherField.setWrapStyleWord(true);
        messageToDecipherField.setRows(5);

        encryptedMessageField = new JTextArea();
        encryptedMessageField.setEditable(false);

        decryptedMessageField = new JTextArea();
        decryptedMessageField.setEditable(false);

        offsetField = new JTextField("");
        offsetField.setColumns(4);

        caesarCipherPanel.setLayout(new BoxLayout(caesarCipherPanel, BoxLayout.PAGE_AXIS));

        caesarCipherPanel.add(messagePanel);
        caesarCipherPanel.add(messageField);
        caesarCipherPanel.add(encryptedMessagePanel);
        caesarCipherPanel.add(encryptedMessageField);
        caesarCipherPanel.add(messageToDecipherPanel);
        caesarCipherPanel.add(messageToDecipherField);
        caesarCipherPanel.add(decryptedMessagePanel);
        caesarCipherPanel.add(decryptedMessageField);


        offsetPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        offsetPanel.add(offsetLabel);
        offsetPanel.add(offsetField);

        caesarCipherPanel.add(offsetPanel);
        caesarCipherPanel.add(encryptButton);
        caesarCipherPanel.add(decipherButton);
        caesarCipherPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));

        add(caesarCipherPanel);

        this.setSize(1200, 600);
        this.setTitle("Caesar Cipher");
        setVisible(true);
    }

    public String getMessage()
    {
        return messageField.getText();
    }

    public String getEncryptedMessage() {
        return encryptedMessageField.getText();
    }

    public String getMessageToDecipherField() {
        return messageToDecipherField.getText();
    }

    public String getOffset() {
        return offsetField.getText();
    }

    public void setEncryptedMessage(String eMessage)
    {
        encryptedMessageField.setText(eMessage);
    }

    public void setDecryptedMessage(String dMessage) {
        decryptedMessageField.setText(dMessage);
    }

    public void clear() {
        messageField.setText("");
        encryptedMessageField.setText("");
        offsetField.setText("");
    }

    public boolean validateOffset(String shiftVal) {
        int i;
        boolean ret = true;
        try {
            i = Integer.parseInt(shiftVal);
            if(i < 1) {
                ret = false;
            }
        }
        catch(NumberFormatException e) {
            ret = false;
        }

        return ret;
    }
}
