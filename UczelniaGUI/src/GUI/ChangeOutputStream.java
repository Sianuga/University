package GUI;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class ChangeOutputStream extends OutputStream {
    private JTextArea textArea;

    public ChangeOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }


    public void write(int b) throws IOException {
        textArea.append(String.valueOf((char)b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
