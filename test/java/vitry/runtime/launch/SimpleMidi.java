package vitry.runtime.launch;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

public class SimpleMidi
{

    /**
     * @param args
     * @throws MidiUnavailableException 
     * @throws InvalidMidiDataException 
     */
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException
    {
        int i = 22;
        System.out.println(MidiSystem.getMidiDeviceInfo()[i]);
        MidiDevice dev = MidiSystem.getMidiDevice(MidiSystem.getMidiDeviceInfo()[i]);
        dev.open();
        
        Receiver r = dev.getReceiver();

        ShortMessage on = new ShortMessage();
        on.setMessage(ShortMessage.NOTE_ON, 0, 80, 80);
        ShortMessage off = new ShortMessage();
        off.setMessage(ShortMessage.NOTE_ON, 0, 80, 0);
        
        while (true) {
            try
            {
                Thread.sleep(500);
                r.send(on, 0);
                Thread.sleep(500);
                r.send(off, 0);
            }
            catch (InterruptedException e)
            {
                dev.close();
            }
        }
        
    }

}
