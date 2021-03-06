import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ListenerBoard implements ActionListener{
	private MorpionInterface inter;
	
	public ListenerBoard(MorpionInterface inter){
		this.inter = inter;
		
	}
	public void actionPerformed(ActionEvent e){
		JButton btn = ((JButton)e.getSource()); //on trouve quel button a été appuyé
		int[] index = inter.getButtonPosition(btn); // index[0]: i, index[1]: j
		
		if(!btn.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Case indispinible");
		}
		else{
			btn.setText(inter.getCurrentPlayer());
			
			if (inter.isGameOver(index[0], index[1])) {
				JOptionPane.showMessageDialog(null,"Joueur " + inter.getCurrentPlayer() + " a gagne");
				inter.resetBoard();
			}
			else {
				inter.switchPlayers();
				int N = inter.getBoardSize();
				if(index[0] == 0 || index[0]==N-1 || index[1] == 0 ||index[1] == N-1 && !inter.isGameOver(index[0], index[1])){
					inter.changeDimension();
					inter.updatePane();
				}
			}
		}
		
		
	}
}
	

