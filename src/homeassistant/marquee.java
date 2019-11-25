package homeassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tech Guy on 7/26/2017.
 */
public class marquee extends JPanel implements ActionListener {

    private static final int RATE = 12;
    private final Timer timer = new Timer(1500 / RATE, this);
    private final JLabel label = new JLabel();
    private final int n;
    private final String s;
    private int index;

    marquee(String s, int n) {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null String or n<");
        }
        StringBuilder sb = new StringBuilder(n);

        sb.append(" ".repeat(n));

        this.s = sb + s + sb;
        this.n = n;

// label.setFont(new ("Serif", Font.ITALIC, 36));
        label.setText(sb.toString());
        label.setForeground(Color.gray);
        label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
        this.add(label);
    }

    void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        label.setText(s.substring(index, index + n));
    }

}

