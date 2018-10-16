package com.mgatelabs.piper.ui.panels;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.common.collect.ImmutableList;
import com.mgatelabs.piper.ui.utils.WebLogHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by @mgatelabs (Michael Fuller) on 9/25/2017 for Phone-Piper
 */
public class LogPanel extends JPanel {

    private WebLogHandler webLogHandler;

    private JTable table;

    private DefaultTableModel defaultTableModel;

    private Timer timer;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public LogPanel(WebLogHandler webLogHandler) {
        super();
        this.webLogHandler = webLogHandler;

        build();
    }

    private void build() {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0f;
        c.weighty = 1.0f;

        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Class");
        defaultTableModel.addColumn("Time");
        defaultTableModel.addColumn("Level");
        defaultTableModel.addColumn("Msg");

        table = new JTable(defaultTableModel);

        JScrollPane jScrollPane = new JScrollPane(table);

        this.add(jScrollPane, c);

        this.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImmutableList<ILoggingEvent> records = webLogHandler.getEvents();
                try {
                    if (records.size() > 0) {
                        final String[] cols = new String[4];
                        for (ILoggingEvent logRecord : records) {
                            StackTraceElement callerData = logRecord.getCallerData()[0];
                            cols[0] = callerData.getClassName().substring(callerData.getClassName().lastIndexOf('.')) + "." + callerData.getMethodName() + "(" + callerData.getLineNumber() + ")";
                            cols[1] = sdf.format(new Date(logRecord.getTimeStamp()));
                            cols[2] = logRecord.getLevel().toString();
                            cols[3] = logRecord.getMessage();
                            defaultTableModel.insertRow(0, cols);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                while (defaultTableModel.getRowCount() > 50) {
                    defaultTableModel.removeRow(defaultTableModel.getRowCount() - 1);
                }
            }
        });

        timer.start();
    }
}
