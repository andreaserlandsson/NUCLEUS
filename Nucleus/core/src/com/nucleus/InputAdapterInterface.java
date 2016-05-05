package com.nucleus;


// POSSIBLE OBSOLETE, ?? ? ? ? ? ? ?




public interface InputAdapterInterface {
    boolean touchDragged(int x, int y, int p);
    boolean keyDown(int keycode);
    boolean keyUp(int keycode);
    boolean keyTyped(char character);
    boolean touchDown(int screenX, int screenY, int pointer, int button);
    boolean touchUp(int screenX, int screenY, int pointer, int button);
    boolean mouseMoved(int screenX, int screenY);
    boolean scrolled(int amount);
}
