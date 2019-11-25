package homeassistant;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * Created by Tech Guy on 7/26/2017.
 */
class HomeAssistant {

    private Geek voice = new Geek();

    //getting the user of pc logged in
    private String userName = System.getenv("USERNAME");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private JLabel name, show, ltext, ltext2, detect, ltext3;
    JButton mic, lin, info, sdown;
    JProgressBar bar;

    JFrame frame;
    //
    URL url = getClass().getResource("/resources/mic3.png");
    URL url2 = getClass().getResource("/resources/inbox1.png");
    URL url3 = getClass().getResource("/resources/mic2.jpeg");
    URL url4 = getClass().getResource("/resources/info.png");
    URL url5 = getClass().getResource("/resources/out.png");
    ImageIcon icon = new ImageIcon(url);
    ImageIcon image2 = new ImageIcon(url2);
    ImageIcon image3 = new ImageIcon(url3);
    ImageIcon image4 = new ImageIcon(url4);
    ImageIcon image5 = new ImageIcon(url5);
    //
    //setting ma default image icon to my frames
    Image iconimage = new ImageIcon(url).getImage();

    //end of frames
    void homeAssistant() {

        detect = new JLabel(image2);
        bar = new JProgressBar();
        bar.hide();
        name = new JLabel("Say...Hello Geek");
        name.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
        show = new JLabel("(Voice Recognition)");
        show.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        show.setForeground(Color.BLUE);
        ltext = new JLabel("Powered by AI");
        ltext.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        ltext.setForeground(Color.black);
        ltext2 = new JLabel("...Speech Received...");
        ltext2.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        ltext2.setForeground(Color.BLUE);
        ltext3 = new JLabel("Learn.Code.Teach");
        ltext3.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        ltext3.setForeground(Color.BLUE);
        String s = "Artificial Intelligence System(Voice Recognition)";
        marquee mp = new marquee(s, 50);
        mp.setBackground(Color.lightGray);
        mp.start();

        voice.text = new JTextField(20);
        voice.text.setEditable(false);
        voice.text.setBackground(Color.lightGray);
        voice.text.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
        voice.text.setText("What You Speak Will Appear Here");
        voice.setSpeech(voice.command);
        voice.text.setText(voice.getSpeech());
        // JOptionPane.showMessageDialog(null, voice.getSpeech());

        sdown = new JButton(image5);
        sdown.setBackground(Color.green);
        sdown.setToolTipText("Exit System...");
        sdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        sdown.setCursor(new Cursor(Cursor.HAND_CURSOR));

        info = new JButton(image4);
        info.setToolTipText("Read What to ask the system");
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This are some of things you can ask Geek the System to do for you or give you answers.\n"
                        + "\n\bHellow Geek\n"
                        + "\bPlay my best music\n"
                        + "\bpause music\n"
                        + "\bplay music\n"
                        + "\bnext track\n"
                        + "\bprevious track\n"
                        + "\bexit playing\n"
                        + "\bexit\n"
                        + "\bWhat is the time\n"
                        + "\bThe time is \n"
                        + "\bshow me the time\n"
                        + "\bDisplay time\n"
                        + "\bWhat is my best SuperCar\n"
                        + "\bWhat is the best SuperCar\n"
                        + "\bHave a problem\n"
                        + "\bI have a problem\n"
                        + "\bWho is your developer\n"
                        + "\bWho developed you Geek\n"
                        + "\bShutdown \n"
                        + "\nThe above are the knowledge based defined language in this system.\n"
                        + "\nDeveloper\n"
                        + "0713255791\n"
                        + "dev.techguy@gmail.com\n"
                        + "\nCaution\n"
                        + "\tTell System to Terminate By saying \"EXIT\"\n"
                        + "\tClick the mic button to activate the system for use.Else system wont function");
            }
        });
        info.setCursor(new Cursor(Cursor.HAND_CURSOR));


        mic = new JButton(icon);
        mic.setSize(20, 20);
        mic.setBackground(Color.lightGray);
        mic.setToolTipText("Please click to activate the mic");
        mic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This is a testing version of a personal computer assistant.");
            }
        });
        mic.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //END OF CODE

        JPanel panelname = new JPanel(new GridBagLayout());
        GridBagConstraints v = new GridBagConstraints();
        v.anchor = GridBagConstraints.CENTER;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 0;
        v.ipady = 0;
        v.gridx = 0;
        v.gridy = 0;

        JPanel panelcontent = new JPanel(new GridBagLayout());
        v.anchor = GridBagConstraints.BELOW_BASELINE;
        v.insets = new Insets(0, 0, 0, 0);
        v.ipadx = 0;
        v.ipady = 0;
        v.gridx = 0;
        v.gridy = 0;
        panelcontent.add(ltext2, v);
        v.gridy++;
        panelcontent.add(voice.text, v);
        v.gridy++;
        v.insets = new Insets(10, 0, 0, 0);
        panelcontent.add(info, v);
        v.gridy++;
        v.insets = new Insets(140, 0, 0, 0);
        v.anchor = GridBagConstraints.BELOW_BASELINE;
        panelcontent.add(ltext, v);
        v.gridy++;
        v.insets = new Insets(20, 0, 0, 0);
        panelcontent.add(sdown, v);
        panelcontent.setBorder(new TitledBorder("Top Tech"));
        //panelcontent.setBackground(Color.lightGray);

        JPanel panelmic = new JPanel(new GridBagLayout());
        v.anchor = GridBagConstraints.BELOW_BASELINE;
        v.insets = new Insets(0, 0, 10, 0);
        v.ipadx = 0;
        v.ipady = 0;
        v.gridx = 0;
        v.gridy = 0;
        panelmic.add(name, v);
        v.gridy++;
        panelmic.add(ltext3, v);
        v.gridy++;
        v.insets = new Insets(0, 0, 0, 0);
        panelmic.add(mic, v);
        v.gridy++;
        v.anchor = GridBagConstraints.BELOW_BASELINE;
        panelmic.add(show, v);
        panelmic.setBorder(new TitledBorder(""));

        v.anchor = GridBagConstraints.BELOW_BASELINE;
        v.insets = new Insets(100, 0, 0, 0);
        v.ipadx = 0;
        v.ipady = 0;
        v.gridx = 0;
        v.gridy = 5;
//        panelmic.add(detect, v);
//        v.gridy++;
        v.insets = new Insets(10, 0, 10, 0);
        panelmic.add(bar, v);
        v.gridy++;
        // panelmic.add(mp, v);
        //panelmic.setBorder(new TitledBorder(""));
        panelmic.setBackground(Color.lightGray);

        JPanel panelmain = new JPanel(new BorderLayout(0, 0));
        panelmain.add("North", panelname);
        panelmain.add("West", panelcontent);
        panelmain.add("Center", panelmic);
        panelmain.setBorder(new TitledBorder("Cool System"));
        // panelmain.setBackground(Color.blue);

        frame = new JFrame("Artificial System");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", Color.blue);
        } catch (Exception c) {
        }
        frame.setUndecorated(true);
        frame.setIconImage(iconimage);
        frame.add(panelmain);
        frame.setSize(850, 550);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
    }

    void caution() {
        //caution to user code
        try {
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer
                    = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            synthesizer.speakPlainText("Hello" + userName, null);
            synthesizer.speakPlainText("What can I do For you today", null);
            synthesizer.speakPlainText("Please Click", null);
            synthesizer.speakPlainText("The information button to read what you can tell me to do", null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            synthesizer.allocate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //end of caution code
    }

//    public static void main(String[] args) throws IOException {
//        homeAssistant home = new homeAssistant();
//        home.homeAssistant();
//
//    }

}

