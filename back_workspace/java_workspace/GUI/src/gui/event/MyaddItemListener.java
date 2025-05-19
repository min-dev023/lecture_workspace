package gui.event;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MyaddItemListener implements ItemListener 
{
	public void itemStateChanged(ItemEvent e){
		System.out.println("초이스 바꿨음.");
	}
}
