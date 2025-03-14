import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{


@Override
public void keyTyped(KeyEvent e) {
}
	public boolean zPressed, qPressed, sPressed,dPressed,spacePressed,spaceReleased;

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
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_Z) {
			zPressed = false;

		}
		if (keyCode == KeyEvent.VK_Q) {
			qPressed = false;

		}

		if (keyCode == KeyEvent.VK_S) {
			sPressed = false;

		}

		if (keyCode == KeyEvent.VK_D) {
			dPressed = false;

		}

		if (keyCode == KeyEvent.VK_SPACE) {
			spacePressed = false;
			spaceReleased = true;

		}
	}

}
