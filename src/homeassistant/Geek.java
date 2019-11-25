package homeassistant;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 * Created by Tech Guy on 7/26/2017.
 */
class Geek {

    private String sp;
    JTextField text;
    //input file code
    private Object Charsets;
    private URL url = getClass().getResource("/corpus/5096.dic");
    private URL url2 = getClass().getResource("/corpus/5096.lm");
    private URL url3 = getClass().getResource("/music/best.MP3");
    //File musicfile = new File(url3.getFile());
    //end of input file

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String command, speechgot;

    //getting the user of pc logged in
    private String userName = System.getenv("USERNAME");

    //setting getter and setter methods
    String getSpeech() {
        return sp;
    }

    void setSpeech(String sp) {
        this.sp = sp;
    }
    //end of getter methods

    void micSpeech() throws IOException {
        //activation voice
        try {
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer
                    = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            synthesizer.speakPlainText("OK LETS GET STARTED", null);
            synthesizer.speakPlainText("TELL ME WHAT TO DO", null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            synthesizer.allocate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //end of voice

        // Configuration Object
        edu.cmu.sphinx.api.Configuration configuration = new edu.cmu.sphinx.api.Configuration();

        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath(url.toString());
        // Set path to the language model.
        configuration.setLanguageModelPath(url2.toString());

        //Recognizer Object, Pass the Configuration object
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);

        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);

        //Create SpeechResult Object
        SpeechResult result;
        //Checking if recognizer has recognized the speech
        while ((result = recognize.getResult()) != null) {
            //Get the recognize speech
            command = result.getHypothesis();
            this.setSpeech(command);

            String work = null;
            Process p;
            //Match recognized speech with our commands
            System.out.println(this.getSpeech());
            if (command.equalsIgnoreCase("Hellow Geek") || command.equalsIgnoreCase("Hello Geek") || command.equalsIgnoreCase("Hallo Geek") || command.equalsIgnoreCase("Hey Geek")) {
                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Am Geek Artificial Intelligence System", null);
                    synthesizer.speakPlainText("Hello", null);
                    synthesizer.speakPlainText(userName, null);
                    synthesizer.speakPlainText("How can i help you today", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("Shutdown") || command.equalsIgnoreCase("Goodbye Geek")) {
                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Are you Sure", null);
                    String accept = JOptionPane.showInputDialog("Enter \"yes\" to accept shutdown or \"no\" to reject");
                    if (accept.equalsIgnoreCase("yes")) {
                        synthesizer.speakPlainText("Closing Programs", null);
                        synthesizer.speakPlainText("System", null);
                        synthesizer.speakPlainText("Shutting Down", null);
                        synthesizer.speakPlainText("Goodbye" + userName, null);
                        synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                        synthesizer.allocate();
                        Runtime runtime = Runtime.getRuntime();
                        try {
                            Process proc = runtime.exec("shutdown -s -t 0");
                        } catch (IOException ex) {
                            Logger.getLogger(HomeAssistant.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (accept.equalsIgnoreCase("no") || accept.equalsIgnoreCase("")) {
                        synthesizer.speakPlainText("System  Resuming", null);
                        synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                        synthesizer.allocate();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("Who is your developer") || command.equalsIgnoreCase("Who developed you Pelcher")) {
                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("I am under Development by the TechGuy", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("What is my best SuperCar") || command.equalsIgnoreCase("What is the best SuperCar")) {

                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Nissan GTR", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("I have a problem") || command.equalsIgnoreCase("Have a problem")) {
                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Yes", null);
                    synthesizer.speakPlainText("Am listening", null);
                    synthesizer.speakPlainText("How may i help you", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("What is the time") || command.equalsIgnoreCase("The time is")) {
                try {

                    LocalDateTime now = LocalDateTime.now();
                    SimpleDateFormat ft
                            = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Have you checked on your watch?", null);
                    synthesizer.speakPlainText("Ok...The Current Time and Date is" + dtf.format(now), null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (command.equalsIgnoreCase("show me the time") || command.equalsIgnoreCase("Display time")) {
                try {

                    LocalDateTime now = LocalDateTime.now();
                    SimpleDateFormat ft
                            = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    JOptionPane.showMessageDialog(null, "Ok...The Current Time and Date is\n" + dtf.format(now));
                    synthesizer.allocate();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (command.equalsIgnoreCase("Play my best music")) {
                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Ok", null);
                    synthesizer.speakPlainText("Retrieving your music", null);
                    synthesizer.speakPlainText("please wait", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                    //music paly code
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url3.getFile()).getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        synthesizer.allocate();
                        synthesizer.speakPlainText("Sorry Music Can't Play", null);
                        synthesizer.allocate();
                        ex.printStackTrace();
                    }
                    //end of music paly code
                    if (command.equalsIgnoreCase("play music")) {
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url3.getFile()).getAbsoluteFile());
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch (Exception ex) {
                            System.out.println("Error with playing sound.");
                            ex.printStackTrace();
                        }

                    } else if (command.equalsIgnoreCase("next track")) {

                    } else if (command.equalsIgnoreCase("pause music")) {

                    } else if (command.equalsIgnoreCase("previous track")) {

                    } else if (command.equalsIgnoreCase("exit playing")) {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("exit")) {
                try {
                    System.setProperty("freetts.voices",
                            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
                    Synthesizer synthesizer
                            = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
                    synthesizer.allocate();
                    synthesizer.resume();
                    synthesizer.speakPlainText("Ok", null);
                    synthesizer.speakPlainText("Goodbye" + userName, null);
                    synthesizer.speakPlainText("I hope I was helpful", null);
                    synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                    synthesizer.allocate();
                    System.exit(0);
                } catch (Exception j) {
                    j.printStackTrace();
                }
            } else if (command.equalsIgnoreCase("open file manager")) {
                work = "nautilus";
            } else if (command.equalsIgnoreCase("close file manager")) {
                work = "pkill nautilus";
            } else if (command.equalsIgnoreCase("open browser")) {
                work = "firefox";
            } else if (command.equalsIgnoreCase("close browser")) {
                work = "pkill firefox";
            }
            //In case command recognized is none of the above hence work might be null
            if (work != null) {
                //Execute the command
                p = Runtime.getRuntime().exec(work);
            }

        }

    }
}

