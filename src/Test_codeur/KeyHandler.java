package Test_codeur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{


@Override
public void keyTyped(KeyEvent e) {
}
	public boolean zPressed, qPressed, sPressed,dPressed,spacePressed,spaceReleased,aPressed,aReleased,dReleased,sReleased,qReleased,zReleased;

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_Z) {
			zPressed = true;
			

		}

		if (keyCode == KeyEvent.VK_Q) {
			qPressed = true;

		}
		if (keyCode == KeyEvent.VK_S) {
			sPressed = true;
		}

		if (keyCode == KeyEvent.VK_D) {
			dPressed = true;

		}
		if (keyCode == KeyEvent.VK_SPACE) {
			spacePressed = true;
			spaceReleased = false;

		}
		if (keyCode == KeyEvent.VK_A) {
			aPressed = true;
			aReleased = false;
		}
			
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_Z) {
			zPressed = false;
			zReleased = true;

		}
		if (keyCode == KeyEvent.VK_Q) {
			qPressed = false;
			qReleased = true;

		}

		if (keyCode == KeyEvent.VK_S) {
			sPressed = false;
			sReleased = true;

		}

		if (keyCode == KeyEvent.VK_D) {
			dPressed = false;
			dReleased = true;

		}

		if (keyCode == KeyEvent.VK_SPACE) {
			spacePressed = false;
			spaceReleased = true;

		}
		if (keyCode == KeyEvent.VK_A) {
			aPressed = false;
			aReleased =true;
		}
	}

}
