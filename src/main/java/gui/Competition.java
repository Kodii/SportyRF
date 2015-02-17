package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kordian on 2014-12-31.
 */

public class Competition extends JFrame {

    private JTable jtableStartList, jtableStartList2;
    private JPanel jpanelMainPanel, jpanelCompetitionTitle,
            jpanelCompetitionDate, jpanelCompetitionPlace,
            jpanelCompetitionLaps, jpanelCompetitionType,
            jpanelCompetitionButtons, jpanelCompetitionCheckBoxes;
    private JComboBox jboxFirstOption, jboxCompetitionType;
    private JLabel jlabelFirstOption, jlabelCompetitionTitle,
            jlabelCompetitionDate, jlabelCompetitionPlace,
            jlabelCompetitionLaps, jlabelCompetitionType,
            jlabelCompetitionCheckBoxes;
    private JTextField jtextfieldCompetitionTitle, jtextfieldCompetitionDate,
            jtextfieldCompetitionPlace, jtextfieldCompetitionLaps,
            jtextfieldCompetitionType;
    private JCheckBox jcheckboxCompetitionBirth, jcheckboxCompetitionCity,
            jcheckboxCompetitionState, jcheckboxCompetitionCategory,
            jcheckboxCompetitionGender, jcheckboxCompetitionWeight,
            jcheckboxCompetitionHeight, jcheckboxCompetitionTeam;
    private String[] columnNames,listFirstOption;
    private JButton jbuttonNewCompetitionConfirm;

    public Competition() {
        dispose();
    }
    public Competition(JFrame window) {

        setTitle("NOWE ZAWODY");
        setSize(650, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        //initUI();
    }

    public void initUI(final JPanel jpanelInsidee, final JScrollPane rightPane) {

        jpanelMainPanel = new JPanel();
        jpanelMainPanel.setLayout(new BoxLayout(jpanelMainPanel, BoxLayout.Y_AXIS));

        jpanelCompetitionTitle = new JPanel();
        jpanelCompetitionTitle.setLayout(new GridLayout(1,2));

        jpanelCompetitionDate = new JPanel();
        jpanelCompetitionDate.setLayout(new GridLayout(1,2));

        jpanelCompetitionPlace = new JPanel();
        jpanelCompetitionPlace.setLayout(new GridLayout(1,2));

        jpanelCompetitionLaps = new JPanel();
        jpanelCompetitionLaps.setLayout(new GridLayout(1,2));

        jpanelCompetitionType = new JPanel();
        jpanelCompetitionType.setLayout(new GridLayout(1,2));

        jpanelCompetitionButtons = new JPanel();
        jpanelCompetitionButtons.setLayout(new GridLayout(1,2));
        jpanelCompetitionCheckBoxes = new JPanel();
        jpanelCompetitionCheckBoxes.setLayout(new GridLayout(2,4));


        jlabelCompetitionTitle = new JLabel("Nazwa zawodów");
        jlabelCompetitionTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jtextfieldCompetitionTitle = new JTextField();

        jlabelCompetitionDate = new JLabel("Data zawodów");
        jlabelCompetitionDate.setHorizontalAlignment(SwingConstants.CENTER);
        jtextfieldCompetitionDate = new JTextField();

        jlabelCompetitionPlace = new JLabel("Miejsce zawodów");
        jlabelCompetitionPlace.setHorizontalAlignment(SwingConstants.CENTER);
        jtextfieldCompetitionPlace = new JTextField();

        jlabelCompetitionLaps = new JLabel("Liczba okrążeń");
        jlabelCompetitionLaps.setHorizontalAlignment(SwingConstants.CENTER);
        jtextfieldCompetitionLaps = new JTextField();

        jlabelCompetitionType = new JLabel("Rodzaj startu");
        jlabelCompetitionType.setHorizontalAlignment(SwingConstants.CENTER);
        jboxCompetitionType = new JComboBox();
        jboxCompetitionType.addItem("Wspólny");
        jboxCompetitionType.addItem("Indywidualny");


        jlabelCompetitionCheckBoxes = new JLabel("Kolumny tabeli");
        jlabelCompetitionCheckBoxes.setHorizontalAlignment(SwingConstants.CENTER);
        jcheckboxCompetitionBirth = new JCheckBox("Data UR");
        jcheckboxCompetitionCity = new JCheckBox("Miasto");
        jcheckboxCompetitionState = new JCheckBox("Powiat");
        jcheckboxCompetitionCategory = new JCheckBox("Kategoria");
        jcheckboxCompetitionGender = new JCheckBox("Płeć");
        jcheckboxCompetitionWeight = new JCheckBox("Waga");
        jcheckboxCompetitionHeight = new JCheckBox("Wzrost");
        jcheckboxCompetitionTeam = new JCheckBox("Drużyna");

        jbuttonNewCompetitionConfirm = new JButton("OK");
        jbuttonNewCompetitionConfirm.setHorizontalAlignment(SwingConstants.CENTER);

//        final String firstOptionItems[] = new String[] {"A"};
//
//        jlabelFirstOption = new JLabel("Pierwsze Pole: ");
//        jlabelFirstOption.setSize(10,10);
//        jboxFirstOption = new JComboBox(firstOptionItems);


        Container contentPane = new Container();
        contentPane = getContentPane();

        contentPane.add(jpanelMainPanel, BorderLayout.NORTH);

        jpanelCompetitionTitle.add(jlabelCompetitionTitle);
        jpanelCompetitionTitle.add(jtextfieldCompetitionTitle);
        jpanelMainPanel.add(jpanelCompetitionTitle);

        jpanelCompetitionDate.add(jlabelCompetitionDate);
        jpanelCompetitionDate.add(jtextfieldCompetitionDate);
        jpanelMainPanel.add(jpanelCompetitionDate);

        jpanelCompetitionPlace.add(jlabelCompetitionPlace);
        jpanelCompetitionPlace.add(jtextfieldCompetitionPlace);
        jpanelMainPanel.add(jpanelCompetitionPlace);

        jpanelCompetitionLaps.add(jlabelCompetitionLaps);
        jpanelCompetitionLaps.add(jtextfieldCompetitionLaps);
        jpanelMainPanel.add(jpanelCompetitionLaps);

        jpanelCompetitionType.add(jlabelCompetitionType);
        jpanelCompetitionType.add(jboxCompetitionType);
        jpanelMainPanel.add(jpanelCompetitionType);

        jpanelCompetitionButtons.add(jlabelCompetitionCheckBoxes);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionBirth);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionCity);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionState);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionCategory);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionGender);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionWeight);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionHeight);
        jpanelCompetitionCheckBoxes.add(jcheckboxCompetitionTeam);
        jpanelCompetitionButtons.add(jpanelCompetitionCheckBoxes);

        jpanelMainPanel.add(jpanelCompetitionButtons);

        jpanelMainPanel.add(jbuttonNewCompetitionConfirm);

        //jpanelCompetitionButtons.add(jbuttonNewCompetitionConfirm);

//        test1.add(jlabelCompetitionDate);
//        test1.add(jtextfieldCompetitionDate);
//        jpanelMainPanel.add(test1);



        //jpanelMainPanel.add(jbuttonNewCompetitionConfirm, BorderLayout.PAGE_END);

//        jboxFirstOption.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if(jboxFirstOption.getSelectedItem() == "A") {
//                    listFirstOption = new String[] {"A"};
//                    jpanelInsidee.removeAll();
//                    jpanelInsidee.removeAll();
//                    JTable list2 = createList2();
//                    JScrollPane listScroller = new JScrollPane(list2);
//                    jpanelInsidee.add(listScroller, BorderLayout.WEST);
//                    jpanelInsidee.add(rightPane, BorderLayout.EAST);
//                }
//                if(jboxFirstOption.getSelectedItem() == "B") {
//                    listFirstOption = new String[] {"B"};
//                    jpanelInsidee.removeAll();
//                    jpanelInsidee.removeAll();
//                    JTable list2 = createList2();
//                    JScrollPane listScroller = new JScrollPane(list2);
//                    jpanelInsidee.add(listScroller, BorderLayout.WEST);
//                    jpanelInsidee.add(rightPane, BorderLayout.EAST);
//                }
//            }
//        });
        jbuttonNewCompetitionConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listFirstOption = new String[] {"NR", "NAZWISKO", "IMIE", jtextfieldCompetitionTitle.getText()};
                jpanelInsidee.removeAll();
                jpanelInsidee.removeAll();
                JTable list2 = createList2();
                JScrollPane listScroller = new JScrollPane(list2);
                jpanelInsidee.add(listScroller, BorderLayout.WEST);
                jpanelInsidee.add(rightPane, BorderLayout.EAST);


            }
        });

    }

    public JTable createList1() {

        String[] columnNames = {};
        Object[][] data = {};

        jtableStartList = new JTable(data, columnNames);
        jtableStartList.setFillsViewportHeight(true);
        setRowColor(jtableStartList);


//      SETING COLUMNS WIDHT

        TableColumn column = null;

        for (int i = 0; i < data.length; i++) {
            column = jtableStartList.getColumnModel().getColumn(i);
            //column.setResizable(false);
            if (i == 0) {
                column.setPreferredWidth(10);
            }
            else if ( (i>1) && (i<5) ) {
                column.setPreferredWidth(50);
            }
            else {
                column.setPreferredWidth(100);
            }
        }


//      SETING COLUMNS WIDHT

        return jtableStartList;
    }




    public JTable createList2() {

        columnNames = new String[listFirstOption.length]; //{listFirstOption[0], listFirstOption[1]};
        for (int i = 0; i < listFirstOption.length; i++){
            columnNames[i] = listFirstOption[i];
            System.out.println(columnNames[i]);
        }
        //columnNames = new String[]{"NR", "NAZWISKO", "IMIE", "DATA", "MIASTO", "KATEGORIA"};
        Object[][] data = {{"123", "123", "123", "123"}};

        jtableStartList2 = new JTable(data, columnNames);
        jtableStartList2.setFillsViewportHeight(true);
        setRowColor(jtableStartList2);

//      SETING COLUMNS WIDHT

//        TableColumn column = null;
//        for (int i = 0; i < data.length; i++) {
//            column = jtableStartList2.getColumnModel().getColumn(i);
//            //column.setResizable(false);
//            if (i == 0) {
//                column.setPreferredWidth(10);
//            }
//            else if ( (i>1) && (i<5) ) {
//                column.setPreferredWidth(50);
//            }
//            else {
//                column.setPreferredWidth(100);
//            }
//        }

//      SETING COLUMNS WIDHT

        return jtableStartList2;
    }

    public void setRowColor(JTable table) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                return this;
            }
        });
    }



}

