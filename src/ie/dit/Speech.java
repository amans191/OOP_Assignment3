package ie.dit;

//voice library
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

//speech class
//this class reads out the text
public class Speech {
    private static String VOICENAME_kevin = "kevin";
    private String text;

    public Speech(String text){
        this.text = text;
    }
    
    public void say(){
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.speak(text);
    }
}
