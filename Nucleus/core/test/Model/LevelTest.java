package Model;

import com.nucleus.model.molecule.IGluonPoint;
import com.nucleus.model.level.ILevel;
import com.nucleus.model.molecule.IMolecule;
import com.nucleus.model.particles.INucleon;
import com.nucleus.model.level.INucleonGun;
import com.nucleus.model.nucleusObservers.IObservable;
import com.nucleus.model.nucleusObservers.IObserver;
import com.nucleus.model.level.Level;
import com.nucleus.model.particles.Neutron;
import com.nucleus.model.level.ObservableHelper;
import com.nucleus.model.particles.Proton;
import com.nucleus.model.collision.Vector;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import mocks.MockGluon;
import mocks.MockMolecule;
import mocks.MockNucleon;
import mocks.MockNucleonGun;

import static org.junit.Assert.assertTrue;

public class LevelTest {
    int width = 5;
    int height = 5;
    int levelNumber = 0;

    Vector nucleonPos = new Vector(0, 0);
    Vector nucleonVel = new Vector(0, 0);
    INucleon mockNucleon = new MockNucleon(nucleonPos, nucleonVel);
    ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
    ArrayList<INucleon> nucleonList2 = new ArrayList<INucleon>();

    Vector v1 = new Vector(100, 100);
    Vector v2 = new Vector(200, 200);
    Vector v3 = new Vector(300, 300);
    IGluonPoint gluon1 = new MockGluon(v1, 1, 1);
    IGluonPoint gluon2 = new MockGluon(v2, 1, 1);
    IGluonPoint gluon3 = new MockGluon(v3, 1, 1);
    IGluonPoint[] gluons = {gluon1, gluon2, gluon3};

    IGluonPoint[] gluons2 = {gluon1, gluon2, gluon3};

    INucleonGun gun = new MockNucleonGun(nucleonList);
    INucleonGun gun2 = new MockNucleonGun(nucleonList2);
    MockMolecule molecule = new MockMolecule(gluons);

    ObservableHelper<Level.GameState> obsHelper = new ObservableHelper<Level.GameState>();

    ILevel level = new Level(levelNumber, width, height, gun, molecule,obsHelper);
    ILevel level2 = new Level(levelNumber, width, height, gun2, molecule,obsHelper);
    ILevel level3 = new Level(levelNumber, width, height, gun, molecule,obsHelper);

    @Test
    public void thisAlwaysPasses() {

        assertTrue(true);

    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }


    @Test
    public void testObserver() {

        IObserver<Level.GameState> o = new IObserver<Level.GameState>() {
            @Override
            public void onObservation(IObservable<Level.GameState> o, Level.GameState arg) {
                if (arg.equals(Level.GameState.RUNNING)) {
                    level3.pause();
                } else if (arg.equals(Level.GameState.PAUSED)) {
                    level3.resume();
                }
            }
        };

        assertTrue(level3.getCurrentState().equals(Level.GameState.RUNNING));

        obsHelper.addObserver(o);
        obsHelper.removeObserver(o);
        level3.addObserver(o);
        level3.removeObserver(o);

        o.onObservation(level3,(Level.GameState)level3.getCurrentState());
        //obsHelper.update(level3, (Level.GameState)level3.getCurrentState());

        assertTrue(level3.getCurrentState().equals(Level.GameState.PAUSED));

        o.onObservation(level3,(Level.GameState)level3.getCurrentState());
        //obsHelper.update(level3, (Level.GameState)level3.getCurrentState());
        assertTrue(level3.getCurrentState().equals(Level.GameState.RUNNING));

        o.onObservation(level3,(Level.GameState)level3.getCurrentState());
        //obsHelper.update(level3, (Level.GameState) level3.getCurrentState());
        assertTrue(level3.getCurrentState().equals(Level.GameState.PAUSED));

    }

    @Test
    public void testGetLevelNumber() {

        assertTrue(level.getLevelNumber() == 0);

        assertTrue(!(level.getLevelNumber() > 0));

        assertTrue(!(level.getLevelNumber() < 0));

    }

    @Test
    public void testGetWidth() {

        assertTrue(level.getWidth() == 5);

        assertTrue(!(level.getWidth() > 5));

        assertTrue(!(level.getWidth() < 5));
    }

    @Test
    public void testGetHeight() {

        assertTrue(level.getHeight() == 5);

        assertTrue(!(level.getHeight() > 5));

        assertTrue(!(level.getHeight() < 5));

    }

    @Test
    public void testIsGameWon() {

        molecule.setFull(false);
        assertTrue(level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

        molecule.setFull(true);
        level.update(1); // this also tests the CheckWinGame() method called via the update() method
        assertTrue(!level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));
    }

    @Test
    public void testIsGameLost() {

        molecule.setFull(true);
        assertTrue(level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));


        molecule.setFull(false);
        level.update(1); // this also tests the loseGame() method called via the update() method
        //assertTrue(level.isGameLost());
        assertTrue(!level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

    }

    @Test
    public void testIsGamePaused() {

        assertTrue(level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

        level.pause();
        assertTrue(!level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

    }

    @Test
    public void testGetNucleonGun() {

        assertTrue(level.getNucleonGun() == gun);
        assertTrue(level.getNucleonGun() != gun2);

    }

    @Test
    public void testGetAirBorneNucleons() {

        nucleonList.add(mockNucleon);
        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getAirborneNucleons().add(nucleonList.get(0)));
        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getAirborneNucleons().remove(nucleonList.get(0)));
        assertTrue(level.getAirborneNucleons().size() == 0);

    }

    @Test
    public void testGetMolecule() {

        assertTrue(level.getMolecule() == molecule);

        IMolecule newMolecule = new MockMolecule(gluons);
        assertTrue(level.getMolecule() != newMolecule);

    }

    @Test
    public void testAddAirBorneNucleon() {

        nucleonList.add(mockNucleon);
        level.addAirborneNucleon(nucleonList.get(0));
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.addAirborneNucleon(nucleonList.get(0));
        assertTrue(level.getAirborneNucleons().size() == 2);

    }

    @Test
    public void testIsOutOfBoundsCheck() {

        Vector nucleonVel1 = new Vector(1, 1);
        Vector nucleonVel2 = new Vector(1, 1);
        Vector nucleonPos1 = new Vector(1, 1);
        Vector nucleonPos2 = new Vector(58, 58); //nucleons aren't considered out of bounds until their "trails" (50) and the nucleons whole radius (3) are completely off-screen

        INucleon nucleon1 = new MockNucleon(nucleonPos1, nucleonVel1);
        INucleon nucleon2 = new MockNucleon(nucleonPos2, nucleonVel2);

        assertTrue(!level.isOutOfBoundsCheck(nucleon1));
        assertTrue(level.isOutOfBoundsCheck(nucleon2));

    }

    @Test
    public void testRemoveOutOfBoundsNucleons(){


        //this also tests the removeNucleon method

        Vector nucleonVel1 = new Vector(1, 1);
        Vector nucleonVel2 = new Vector(1, 1);
        Vector nucleonPos1 = new Vector(1, 1);
        Vector nucleonPos2 = new Vector(58, 58); //nucleons aren't considered out of bounds until their "trails" (50) and the nucleons whole radius (3) are completely off-screen

        INucleon nucleon1 = new MockNucleon(nucleonPos1, nucleonVel1);
        INucleon nucleon2 = new MockNucleon(nucleonPos2, nucleonVel2);

        level.addAirborneNucleon(nucleon1);
        level.addAirborneNucleon(nucleon2);

        assertTrue(level.getAirborneNucleons().size() == 2);
        level.removeOutOfBoundsNucleons();

        assertTrue(level.getAirborneNucleons().size() == 1);

    }

    @Test
    public void testPauseAndResume() {

        assertTrue(level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

        level.pause();
        assertTrue(!level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

        level.resume();
        assertTrue(level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

        level.pause();
        assertTrue(!level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

    }

    @Test
    public void testUpdate(){

        //this also tests the checkWinGame method

        //this also  tests checkAllNucleonsStatus() which in turn tests
            //the checkWinGame method
            //the loseGame method
            //the removeNucleon method

        gluon1.setPosition(nucleonPos);

        nucleonList.add(new Proton(nucleonPos, nucleonVel));
        nucleonList.add(new Neutron(nucleonPos, nucleonVel));

        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);

        level.update(1);//this adds the proton to the colliding gluon
        assertTrue(level.getAirborneNucleons().size() == 1);

        level.update(1);//this adds the neutron to the colliding gluon
        assertTrue(level.getAirborneNucleons().size() == 0);

        assertTrue(gluon1.getCurrentProtons() == 1);
        assertTrue(gluon1.getCurrentNeutrons() == 1);
        assertTrue(gluon1.getProtonsNeeded() == 0);
        assertTrue(gluon1.getNeutronsNeeded() == 0);

        nucleonList.add(new Proton(nucleonPos, nucleonVel));

        level.update(1);
        level.update(1);//this adds an other proton to the allready full gluon -> loseGame() is called

        assertTrue(!level.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(level.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

        nucleonList2.add(new Neutron(nucleonPos, nucleonVel));

        level2.update(1);
        level2.update(1);//this adds an other neutron to the allready full gluon -> loseGame() is called

        assertTrue(!level2.getCurrentState().equals(Level.GameState.RUNNING));
        assertTrue(!level2.getCurrentState().equals(Level.GameState.PAUSED));
        assertTrue(!level2.getCurrentState().equals(Level.GameState.PAUSEDWIN));
        assertTrue(level2.getCurrentState().equals(Level.GameState.PAUSEDLOSE));

    }

}