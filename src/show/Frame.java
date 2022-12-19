package show;

import schedule.Generate;
import selection.Selection;
import show.input_data.Data;
import show.util.JTableUtils;
import teacher.TeacherSchedule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.*;

public class Frame extends JFrame {
    private JPanel panelMain;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JTable table6;
    private JTable tableInput;
    private JScrollPane scrollPane1;
    private JButton teacherButton;
    private JButton educationProgramButton;
    private JSpinner spinnerCourse;
    private JSpinner spinnerGroup;
    private JLabel course;
    private JLabel group;
    private JButton addButton;
    private JButton showButton;
    private JButton showEducationProgramButton;
    private JButton showAllTeachersButton;
    private JButton clearButton;

    private List<TeacherSchedule> teacherSchedules = new ArrayList<>();

    private Data data = new Data();

    private boolean flag = false;

    private String[] scheduleSchem = {"Time", "Object", "Teacher"};
    private String[] techerSchem = {"Teacher", "Object"};
    private String[] educationSchem = {"Object", "Count couple"};

    private String[] time = {"8.00 - 9.35", "9.45-11.20", "11.30-13.05", "13.25-15.00", "15.10-16.45", "16.55-18.30", "18.40-20.00"};
    private List<JTable> tables = List.of(table1, table2, table3, table4, table5, table6);


    public Frame() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 150, true, true, true, false);
        tableInput.setRowHeight(30);
        setTables();
        changeHeandkerAll(scheduleSchem);
        setTeacherTable();





        repaint();

        showEducationProgramButton.setVisible(false);
        educationProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setEducationTable();
            }
        });
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTeacherTable();

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(flag){
                    data.addProgram(JTableUtils.readStringMatrixFromJTable(tableInput),(Integer) spinnerCourse.getValue(), (Integer) spinnerGroup.getValue());
                }else {
                    data.addTeacher(JTableUtils.readStringMatrixFromJTable(tableInput));
                }
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                teacherSchedules = Generate.getTeacherSchedule(data.getPrograms(), data.getTeachers());

                if(!flag)
                    return;

                showStudentSchedule();

                data.show();
            }
        });
        showAllTeachersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setTeacherTable();
                writeArrTojtable(tableInput, data.getTableTeachers());
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data = new Data();
            }
        });
        showEducationProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println("Dont use it");
                /*setEducationTable();
                System.out.println("+");

                teacherSchedules = Generate.getTeacherSchedule(data.getPrograms(), data.getTeachers());

                List<TeacherSchedule> ts = Selection.byGroupCourse(teacherSchedules, (Integer) spinnerCourse.getValue(), (Integer) spinnerGroup.getValue());

                String[][] s = new String[ts.size()][2];

                for (int i = 0; i < s.length; i++) {
                    s[i][0] = ts.get(i).getCouple().getTitle();
                    s[i][1] = ts.get(i).getCount()+"";
                    System.out.println(Arrays.toString(s[i]));
                }


                writeArrTojtable(tableInput, s);*/
            }
        });
        teacherButton.doClick();

    }

    private void writeArrTojtable(JTable table, String[][] data){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                table.setValueAt(data[i][j], i, j);
            }
        }
    }

    public void setTime(){
        for (JTable t:tables) {
            for (int i = 0; i < time.length; i++) {
                t.setValueAt(time[i], i, 0);
            }
        }
        repaint();
    }

    public void showStudentSchedule(){
        List<TeacherSchedule> ts = Selection.byGroupCourse(teacherSchedules, (Integer) spinnerCourse.getValue(), (Integer) spinnerGroup.getValue());

        for (int i = 1; i < 6; i++) {
            List<TeacherSchedule> ts2 = Selection.byDay(ts, DayOfWeek.of(i));

            for (TeacherSchedule t:ts2) {
                tables.get(i-1).setValueAt(t.getCouple().getTitle(),  t.getCount(), 1);
                tables.get(i-1).setValueAt(t.getTeacher().getName(),  t.getCount(), 2);
            }

        }

    }

    public void setTeacherTable(){
        changeHandler(tableInput, techerSchem, 10);
        flag = false;
        setVisibleComponents(flag);
        repaint();
    }

    public void setEducationTable(){
        changeHandler(tableInput, educationSchem, 10);
        flag = true;
        setVisibleComponents(flag);
        repaint();
    }
    public void setTables(){
        for (JTable t:tables) {
            JTableUtils.initJTableForArray(t, 150, false, true, false, false);
            t.setRowHeight(30);

        }
        //setTime();
    }

    public void setVisibleComponents(boolean f){
        spinnerCourse.setVisible(f);
        spinnerGroup.setVisible(f);
        course.setVisible(f);
        group.setVisible(f);
    }

    private void changeHeandkerAll(String[] nameRows){
        for (JTable t:tables) {
            changeHandler(t, nameRows, 7);
        }
        setTime();
    }
    private void changeHandler(JTable table, String[] nameCols, int countRow){
        String[][] arr = new String[countRow][nameCols.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], "");
        }

        JTableUtils.writeArrayToJTable(table, arr);
        for (int i = 0; i < nameCols.length; i++) {
            table.getColumnModel().getColumn(i).setHeaderValue(nameCols[i]);
            table.getTableHeader().repaint();
        }
    }

    private void createNotChangableAll(List<JTable> tables){
        for (JTable t:tables) {
            notChangable(t);
        }
    }
    private void notChangable(JTable table){
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(tableModel);
    }


}
