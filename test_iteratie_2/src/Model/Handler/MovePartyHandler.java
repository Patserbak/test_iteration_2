package Model.Handler;

import Model.Canvas;
import Model.Message;
import Model.Party;
import Model.Point;

/**
 * A handler that handles the actions of a party being moved.
 */
public class MovePartyHandler extends Handler {
	
	/**
	 * Handle a party being moved.
	 * @param canvas		The canvas to edit.
	 * @param x			The x coordinate of the mouse event used to handle these actions.
	 * @param y			The y coordinate of the mouse event used to handle these actions.
	 */
	public static void handle(Canvas canvas, int x, int y ) {
		// Variable for the party being moved
		Party selected = null;
		
		// Find selected party
		for(Party party:canvas.getParties()) {
			if(party.getSelected()) {selected = party;break;}
		}
		
		// If no party is selected -> Nothing happens, return
		if(selected==null) {return;}
		
		// Change Coordinates
		if(canvas.getView() == Canvas.View.SEQUENCE) {
			selected.setPosSeq(x, selected.getPosSeq().getY());
			selected.getLabel().setLabelPositionSeq(x,selected.getLabel().getLabelPositionSequence().getY());
			for (Message m : canvas.getMessages()) {
				if ((m.getSentBy() == selected) || (m.getReicevedBy() == selected)) {
					int xLabel = Math.max(m.getReicevedBy().getPosSeq().getX(), m.getSentBy().getPosSeq().getX()) - Math.abs( (m.getReicevedBy().getPosSeq().getX() - m.getSentBy().getPosSeq().getX() )/2);
					int yLabel = m.getLabel().getLabelPositionSequence().getY();
					m.getLabel().setLabelPositionSeq(new Point(xLabel, yLabel));
				}
			}
		}
		if(canvas.getView() == Canvas.View.COMMUNICATION) {
			selected.setPosComm(x, y);
			selected.getLabel().setLabelPositionComm(x,y);
		}
	}

}
