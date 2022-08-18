package GUI;

import Uczelnia.Uczelnia;
import Wydarzenia.Wydarzenie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class GUI
{
    private Uczelnia uczelnia = new Uczelnia();
    public JPanel mainPanel;
    private JButton wyswietlWszystkoButton;
    public JTextArea OutputText;
    private JButton zapiszPlikButton;
    private JButton sortujButton;
    private JButton wyszukajButton;
    private JButton usunButton;
    private JButton wpiszButton;
    private JButton wczytajButton;
    private JComboBox wyszukajTypBox;
    private JComboBox wpiszBox;
    private JTextField poleNPlikuWczyt;
    private JTextField poleNPlikuZap;
    private JComboBox wyswietlBox;
    private JComboBox usunTypBox;
    private JComboBox sortujTypBox;
    private JComboBox sortujBox;
    private JTextField textInput;
    private JComboBox wyszukajBox;
    private JComboBox usunBox;
    private JButton zatwierdzButton;
    private boolean waitingForInput = true;

    public GUI()
    {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        PrintStream printStream = new PrintStream(new ChangeOutputStream(OutputText));
        System.setOut(printStream);
        System.setErr(printStream);

        uczelnia.setWpisywanie(textInput);
        uczelnia.setWpisywanieWybor(wpiszBox);
        uczelnia.setOutputText(OutputText);

        wyswietlWszystkoButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                OutputText.setText(null);
                if (checkForDatabase())
                {
                    switch (wyswietlBox.getSelectedIndex())
                    {
                        case 0:
                            uczelnia.wyswietlWszystkie();
                            break;
                        case 1, 2, 3:
                            uczelnia.wyswietlWszystkie(wyswietlBox.getSelectedItem().toString());
                            break;
                        case 4:
                            uczelnia.getBiblioteka().wyswietlWszystkie();
                            break;
                        case 5:
                            uczelnia.wyswietlWydarzenia();
                            break;
                        case 6:
                            uczelnia.wyswietlObserwatorow();
                            break;
                    }


                }

            }
        });
        zapiszPlikButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                OutputText.setText(null);
                if (checkForDatabase())
                {
                    uczelnia.zapiszDoPliku(poleNPlikuZap.getText().toString());
                    poleNPlikuZap.setText("");
                } else
                    System.out.println("Brak bazy danych");
            }
        });
        wczytajButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                OutputText.setText(null);
                uczelnia.wczytajZPliku(poleNPlikuWczyt.getText());
                poleNPlikuWczyt.setText("");
                uczelnia.setWpisywanie(textInput);
                uczelnia.setWpisywanieWybor(wpiszBox);
                uczelnia.setOutputText(OutputText);
            }
        });
        wyszukajButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                OutputText.setText(null);
                if (checkForDatabase())
                {
                    if (wyszukajTypBox.getSelectedItem().toString().equals("Kurs"))
                    {
                        uczelnia.getBiblioteka().wyszukajKurs(wyszukajBox.getSelectedItem().toString(), textInput.getText());
                    } else if (wyszukajTypBox.getSelectedIndex() != 0)
                        uczelnia.wyszukajOsobe(wyszukajBox.getSelectedItem().toString(), textInput.getText(), wyszukajTypBox.getSelectedItem().toString());

                } else
                    System.out.println("Brak bazy danych");
            }
        });
        wpiszButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                OutputText.setText(null);
                if (checkForDatabase())
                {
                    if (wpiszBox.getSelectedIndex() == 4)
                    {
                        uczelnia.getBiblioteka().stworzKurs();
                    } else if (wpiszBox.getSelectedIndex() != 0 &&wpiszBox.getSelectedIndex()!=5)
                        uczelnia.wpiszOsoba();
                    else
                    {
                        String[] a = textInput.getText().split("  ");
                        uczelnia.dodajWydarzenie(new Wydarzenie(a[0],a[1]));
                        textInput.removeAll();
                    }

                } else
                    System.out.println("Brak bazy danych");
            }
        });

        sortujButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                OutputText.setText(null);
                if (checkForDatabase())
                {
                    if (sortujTypBox.getSelectedItem().toString().equals("Osoba"))
                        uczelnia.posortujWedlug(sortujBox.getSelectedItem().toString());
                    else if (sortujTypBox.getSelectedItem().toString().equals("Kurs"))
                        uczelnia.getBiblioteka().posortujWedlug(sortujBox.getSelectedItem().toString());
                } else
                    System.out.println("Brak bazy danych");
            }
        });
        usunButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                OutputText.setText(null);
                if (checkForDatabase())
                {
                    if (usunTypBox.getSelectedItem().toString().equals("Kurs"))
                        uczelnia.usunOsoba(usunBox.getSelectedItem().toString(), textInput.getText().toString(), usunTypBox.getSelectedItem().toString());
                    else if(usunTypBox.getSelectedIndex()==5)
                    {
                        uczelnia.usunDuplikaty();
                    }
                    else if (usunTypBox.getSelectedIndex() != 0)
                    {
                        uczelnia.getBiblioteka().usunKurs(usunBox.getSelectedItem().toString(), textInput.getText().toString());
                    }
                    else
                    {
                        System.out.println("Nie wybrano typu do usuniecia");
                    }

                } else
                    System.out.println("Brak bazy danych");
            }
        });
    }

    public boolean checkForDatabase()
    {
        if (uczelnia != null)
        {
            return true;
        } else
            return false;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 11, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(1534, 575), null, 0, false));
        wyszukajButton = new JButton();
        wyszukajButton.setText("Wyszukaj");
        panel1.add(wyszukajButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(1, 25), new Dimension(1, 98), new Dimension(1, 25), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(1, 10), null, 0, false));
        zapiszPlikButton = new JButton();
        zapiszPlikButton.setText("Zapisz plik");
        panel1.add(zapiszPlikButton, new com.intellij.uiDesigner.core.GridConstraints(1, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        wczytajButton = new JButton();
        wczytajButton.setText("Wczytaj plik");
        panel1.add(wczytajButton, new com.intellij.uiDesigner.core.GridConstraints(1, 10, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Nazwa pliku");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 10, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        poleNPlikuWczyt = new JTextField();
        panel1.add(poleNPlikuWczyt, new com.intellij.uiDesigner.core.GridConstraints(4, 10, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nazwa pliku");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 1), null, 0, false));
        poleNPlikuZap = new JTextField();
        panel1.add(poleNPlikuZap, new com.intellij.uiDesigner.core.GridConstraints(4, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        wyswietlWszystkoButton = new JButton();
        wyswietlWszystkoButton.setText("Wyswietl");
        panel1.add(wyswietlWszystkoButton, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        wpiszButton = new JButton();
        wpiszButton.setText("Wpisz");
        panel1.add(wpiszButton, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        usunButton = new JButton();
        usunButton.setText("Usun");
        panel1.add(usunButton, new com.intellij.uiDesigner.core.GridConstraints(1, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        sortujButton = new JButton();
        sortujButton.setText("Sortuj");
        panel1.add(sortujButton, new com.intellij.uiDesigner.core.GridConstraints(1, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 75), new Dimension(150, 144), new Dimension(150, 150), 0, false));
        wyszukajTypBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("");
        defaultComboBoxModel1.addElement("Student");
        defaultComboBoxModel1.addElement("PracownikA");
        defaultComboBoxModel1.addElement("Pracownik_BD");
        defaultComboBoxModel1.addElement("Kurs");
        wyszukajTypBox.setModel(defaultComboBoxModel1);
        panel1.add(wyszukajTypBox, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wyswietlBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("");
        defaultComboBoxModel2.addElement("Student");
        defaultComboBoxModel2.addElement("PracownikA");
        defaultComboBoxModel2.addElement("PracownikB_D");
        defaultComboBoxModel2.addElement("Kursy");
        wyswietlBox.setModel(defaultComboBoxModel2);
        panel1.add(wyswietlBox, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wpiszBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("");
        defaultComboBoxModel3.addElement("Student");
        defaultComboBoxModel3.addElement("PracownikA");
        defaultComboBoxModel3.addElement("PracownikB_D");
        defaultComboBoxModel3.addElement("Kurs");
        wpiszBox.setModel(defaultComboBoxModel3);
        panel1.add(wpiszBox, new com.intellij.uiDesigner.core.GridConstraints(2, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sortujTypBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("");
        defaultComboBoxModel4.addElement("Osoba");
        defaultComboBoxModel4.addElement("Kurs");
        sortujTypBox.setModel(defaultComboBoxModel4);
        panel1.add(sortujTypBox, new com.intellij.uiDesigner.core.GridConstraints(2, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sortujBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("");
        defaultComboBoxModel5.addElement("nazwisko");
        defaultComboBoxModel5.addElement("nazwiskoP");
        defaultComboBoxModel5.addElement("nazwiskoImie");
        defaultComboBoxModel5.addElement("ects");
        defaultComboBoxModel5.addElement("nazwiskoWiek");
        sortujBox.setModel(defaultComboBoxModel5);
        panel1.add(sortujBox, new com.intellij.uiDesigner.core.GridConstraints(4, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        wyszukajBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("");
        defaultComboBoxModel6.addElement("imie");
        defaultComboBoxModel6.addElement("nazwisko");
        defaultComboBoxModel6.addElement("imieP");
        defaultComboBoxModel6.addElement("nazwiskoP");
        defaultComboBoxModel6.addElement("nazwaKursu");
        defaultComboBoxModel6.addElement("ects");
        defaultComboBoxModel6.addElement("indeks");
        defaultComboBoxModel6.addElement("wiek");
        defaultComboBoxModel6.addElement("rokStudiow");
        defaultComboBoxModel6.addElement("pesel");
        defaultComboBoxModel6.addElement("stazPracy");
        defaultComboBoxModel6.addElement("pensja");
        defaultComboBoxModel6.addElement("dorobekNaukowy");
        defaultComboBoxModel6.addElement("stanowisko");
        wyszukajBox.setModel(defaultComboBoxModel6);
        panel1.add(wyszukajBox, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usunBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("");
        defaultComboBoxModel7.addElement("imie");
        defaultComboBoxModel7.addElement("nazwisko");
        defaultComboBoxModel7.addElement("imieP");
        defaultComboBoxModel7.addElement("nazwiskoP");
        defaultComboBoxModel7.addElement("nazwaKursu");
        defaultComboBoxModel7.addElement("ects");
        defaultComboBoxModel7.addElement("indeks");
        defaultComboBoxModel7.addElement("wiek");
        defaultComboBoxModel7.addElement("rokStudiow");
        defaultComboBoxModel7.addElement("pesel");
        defaultComboBoxModel7.addElement("stazPracy");
        defaultComboBoxModel7.addElement("pensja");
        defaultComboBoxModel7.addElement("dorobekNaukowy");
        defaultComboBoxModel7.addElement("stanowisko");
        usunBox.setModel(defaultComboBoxModel7);
        panel1.add(usunBox, new com.intellij.uiDesigner.core.GridConstraints(4, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usunTypBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("");
        defaultComboBoxModel8.addElement("Student");
        defaultComboBoxModel8.addElement("PracownikA");
        defaultComboBoxModel8.addElement("PracownikB_D");
        defaultComboBoxModel8.addElement("Kurs");
        usunTypBox.setModel(defaultComboBoxModel8);
        panel1.add(usunTypBox, new com.intellij.uiDesigner.core.GridConstraints(2, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(3, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textInput = new JTextField();
        panel2.add(textInput, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(300, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("TextInput");
        panel2.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(32);
        scrollPane1.setVerticalScrollBarPolicy(21);
        mainPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(1500, 200), new Dimension(1500, 200), new Dimension(1500, 200), 0, false));
        OutputText = new JTextArea();
        OutputText.setEditable(false);
        OutputText.setText("");
        OutputText.setWrapStyleWord(false);
        scrollPane1.setViewportView(OutputText);
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        mainPanel.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
    }
}
