package Model;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.INucleon;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.Level;
import com.nucleus.Model.Neutron;
import com.nucleus.Model.Proton;
import com.nucleus.Utils.Vector;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;


import java.util.ArrayList;

import mocks.MockGluon;
import mocks.MockMolecule;
import mocks.MockNucleon;
import mocks.MockNucleonGun;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by erik on 19/04/16.
 */
public class LevelTest {
    int width = 5;
    int height = 5;
    int levelNumber = 0;
    Vector gluonPositions = new Vector(1,1);
    int pNeeded = 1;
    int nNeeded = 1;

    Vector nucleonPos = new Vector(0,0);
    Vector nucleonVel = new Vector(0,0);
    INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
    ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
    ArrayList<INucleon> nucleonList2 = new ArrayList<INucleon>();

    Vector v1 = new Vector(100,100);
    Vector v2 = new Vector(200,200);
    Vector v3 = new Vector(300,300);
    IGluonPoint gluon1 = new MockGluon(v1,1,1);
    IGluonPoint gluon2 = new MockGluon(v2,1,1);
    IGluonPoint gluon3 = new MockGluon(v3,1,1);
    IGluonPoint[] gluons = {gluon1,gluon2,gluon3};

    INucleonGun gun = new MockNucleonGun(nucleonList);
    INucleonGun gun2 = new MockNucleonGun(nucleonList2);
    MockMolecule molecule = new MockMolecule(gluons);

    Level level = new Level(levelNumber, width, height, gun, molecule, gluons);
    Level level2 = new Level(levelNumber, width, height, gun2, molecule, gluons);

    @Test
    public void thisAlwaysPasses() {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }

    @Test
    public void testGetLevelNumber(){

        assertTrue(level.getLevelNumber() == 0);

    }

    @Test
    public void testGetWidth(){

        assertTrue(level.getWidth() == 5);
    }

    @Test
    public void testGetHeight(){

        assertTrue(level.getHeight() == 5);

    }

    @Test
    public void testIsGameWon(){
        molecule.setFull(false);
        assertTrue(!level.isGameWon());
        molecule.setFull(true);
        level.update(1); // this also tests the CheckWinGame() method called via the update() method
        assertTrue(level.isGameWon());

    }

    @Test
    public void testIsGameLost(){

        molecule.setFull(true);
        assertTrue(!level.isGameLost());
        molecule.setFull(false);
        level.update(1); // this also tests the loseGame() method called via the update() method
        assertTrue(level.isGameLost());

    }

    @Test
    public void testIsGamePaused(){

        assertTrue(!level.isGamePaused());
        level.pause();
        assertTrue(level.isGamePaused());

    }

    @Test
    public void testSetGamePauesd(){
        level.setGamePaused();
        assertTrue(level.isGamePaused());

    }

    @Test
    public void testGetNucleonGun(){

        assertTrue(level.getNucleonGun() == this.gun);

    }

    @Test
    public void testGetAirBorneNucleons(){

        nucleonList.add(mockNucleon);
        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getAirborneNucleons().add(nucleonList.get(0)));
        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getAirborneNucleons().remove(nucleonList.get(0)));
        assertTrue(level.getAirborneNucleons().size() == 0);

    }

    @Test
    public void testGetMolecule(){

        assertTrue(level.getMolecule() == this.molecule);

    }

    @Test
    public void testGetGluons(){

        assertTrue(level.getGluons() == this.gluons);

    }

    @Test
    public void testAddAirBorneNucleon(){

        nucleonList.add(mockNucleon);
        level.addAirborneNucleon(nucleonList.get(0));
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.addAirborneNucleon(nucleonList.get(0));
        assertTrue(level.getAirborneNucleons().size() == 2);

    }

    @Test
    public void testIsOutOfBoundsCheck(){

    /*public boolean isOutOfBoundsCheck(INucleon nucleon){
        float x = nucleon.getPosition().getX();
        float y = nucleon.getPosition().getY();
        float bufferSize = 50; //nucleons aren't considered out of bounds until their "trails" are completely off-screen
        return x - nucleon.getRadius()>=width+bufferSize || x + nucleon.getRadius()<=0-bufferSize ||
                y - nucleon.getRadius()>=height+bufferSize || y + nucleon.getRadius()<=0-bufferSize; // getRadius is 3
    }*/

        Vector nucleonVel1 = new Vector(1,1);
        Vector nucleonVel2 = new Vector(1,1);
        Vector nucleonPos1 = new Vector(1,1);
        Vector nucleonPos2 = new Vector(58,58); //nucleons aren't considered out of bounds until their "trails" (50) and the nucleons whole radius (3) are completely off-screen

        INucleon nucleon1 = new MockNucleon(nucleonPos1 ,nucleonVel1);
        INucleon nucleon2 = new MockNucleon(nucleonPos2 ,nucleonVel2);

        assertTrue(!level.isOutOfBoundsCheck(nucleon1));
        assertTrue(level.isOutOfBoundsCheck(nucleon2));

    }

    @Test
    public void testRemoveOutOfBoundsNucleons(){

    /* public void removeOutOfBoundsNucleons(){ // checks if any nucleons in airborne Nucleons is out of bounds
        for (int i=0; i<airborneNucleons.size(); i++){
            INucleon nucleon = airborneNucleons.get(i);
            if (isOutOfBoundsCheck(nucleon)){
                removeNucleon(nucleon);
                i--;
            }
        }
    }*/

        //this also tests the removeNucleon method
    /* private void removeNucleon(INucleon nucleon){
        airborneNucleons.remove(nucleon);
    }*/

        Vector nucleonVel1 = new Vector(1,1);
        Vector nucleonVel2 = new Vector(1,1);
        Vector nucleonPos1 = new Vector(1,1);
        Vector nucleonPos2 = new Vector(58,58); //nucleons aren't considered out of bounds until their "trails" (50) and the nucleons whole radius (3) are completely off-screen

        INucleon nucleon1 = new MockNucleon(nucleonPos1 ,nucleonVel1);
        INucleon nucleon2 = new MockNucleon(nucleonPos2 ,nucleonVel2);

        level.addAirborneNucleon(nucleon1);
        level.addAirborneNucleon(nucleon2);

        assertTrue(level.getAirborneNucleons().size() == 2);
        level.removeOutOfBoundsNucleons();

        assertTrue(level.getAirborneNucleons().size() == 1);

    }

    @Test
    public void testPauseAndResume(){

    /*public void pause() {
        currentState = GameState.PAUSED;
        setChanged();
        notifyObservers("pause");
    }*/

    /* public void resume(){
        currentState = GameState.RUNNING;
        setChanged();
    }*/

        level.pause();
        assertTrue(level.isGamePaused());
        level.resume();
        assertTrue(!level.isGamePaused());
        level.pause();
        assertTrue(level.isGamePaused());
        level.resume();
        assertTrue(!level.isGamePaused());
        level.pause();
        level.pause();
        assertTrue(level.isGamePaused());
    }

    @Test
    public void testUpdate(){

    /*public void update(float delta){
        if(currentState==GameState.RUNNING) {
            checkWinGame();
            runTime += delta;
            checkAllNucleonsStatus() {
                INucleon collidingNucleon = null;
                for (IGluonPoint gluon : gluons) {
                    for (INucleon nucleon : airborneNucleons){
                        if (com.nucleus.Model.Collisions.CollisionHandler.collision((ICollidable) gluon, (ICollidable) nucleon)) {
                            if (nucleon.getClass().equals(Proton.class)) {
                                if (gluon.getProtonsNeeded() > 0){
                                    gluon.addProton();
                                    collidingNucleon = nucleon;
                                    checkWinGame();
                                } else {
                                    loseGame();
                                }
                            }
                            else {
                                if (gluon.getNeutronsNeeded() > 0){
                                    gluon.addNeutron();
                                    collidingNucleon = nucleon;
                                    checkWinGame();
                                } else {
                                    loseGame();
                                }
                            }
                        }
                    }
                    if (collidingNucleon != null) {
                        removeNucleon(collidingNucleon);
                    }
                }
        if (collidingNucleon != null){
            removeNucleon(collidingNucleon);
        }
            }
            if (runTime - lastUpdateTime >= updateTime && !gun.isEmpty()) {
                lastUpdateTime = runTime;
                airborneNucleons.add(gun.shoot());
            }
            for (INucleon nucleon : airborneNucleons) {
                nucleon.update(delta);
            }
            removeOutOfBoundsNucleons();
        }
    }*/

        //this also tests the checkWinGame method

        //this also  tests checkAllNucleonsStatus() which in turn tests
            //the checkWinGame method
            //the loseGame method
            //the removeNucleon method

        gluon1.setPosition(nucleonPos);

        nucleonList.add(new Proton(nucleonPos,nucleonVel));
        nucleonList.add(new Neutron(nucleonPos,nucleonVel));

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

        //assertTrue(level.isGameWon()); this does not work since the statements above does not change our MOCK-molecule which is what it shecke to determin if we win


        //molecule.setFull(false);
        //level.update(1);

        nucleonList.add(new Proton(nucleonPos,nucleonVel));

        level.update(1);
        level.update(1);//this adds an other proton to the allready full gluon -> loseGame() is called

        assertTrue(level.isGameLost());

        nucleonList2.add(new Neutron(nucleonPos,nucleonVel));

        level2.update(1);
        level2.update(1);//this adds an other neutron to the allready full gluon -> loseGame() is called

        assertTrue(level2.isGameLost());

    }

    /*
    @Test
    public void testGetNucleons() {

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(1, 1, gun, molecule,gluons);
        assertTrue(level.getAirborneNucleons().size() == 0);
        level.addAirborneNucleon(new MockNucleon());
        assertTrue(level.getAirborneNucleons() != null);
    }

    @Test
    public void testGetNucleonsWhenEmpty(){

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new MockNucleonGun(nucleons);
        Level level = new Level(1, 1, gun, molecule,gluons);
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testOutOfBounds(){

        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(13,13);
        Vector nucleonVel = new Vector(5,5);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel); //levelSize + radius
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule,gluons);
        level.addAirborneNucleon(level.getNucleonGun().shoot());
        System.out.println(level.getAirborneNucleons().size());
        level.removeOutOfBoundsNucleons();

        //Shouldn't this be 0...? Wäwä
        assertTrue(level.getAirborneNucleons().size() == 1);
        System.out.println(level.getAirborneNucleons().get(0).getPosition().getX());
        level.update(1);
        System.out.println(level.getAirborneNucleons().get(0).getPosition().getX());
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.update(6);
        level.removeOutOfBoundsNucleons();
        assertTrue(level.getAirborneNucleons().size() == 1);
        System.out.println(level.getAirborneNucleons().get(0).getPosition().getX());
        assertTrue(level.getAirborneNucleons().size() == 1);
        //still 1 and not 0...


    }

    @Test
    public void testUpdate(){

        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(1,1);
        Vector nucleonVel = new Vector(1,1);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(100, 100, gun, molecule,gluons);

        level.update(1);
        assertTrue(gun.isEmpty());

        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 2.0);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 2.0);


        level.update(1);

        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getAirborneNucleons().isEmpty());

        level.update(1);

        //level.getAirborneNucleons().get(0).getPosition().getX();
        //this will give IndexOutOutOfBounds?? Wääh,

    }

    @Test
    public void testGluonCollisionCheck(){
        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(10,10,gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(1,1);
        Vector nucleonVel = new Vector(1,1);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule,gluons);

        level.update(1);
        assertTrue(level.getGluons()[0].getProtonsNeeded() == 1);

        level.update(1);
        assertTrue(level.getGluons()[0].getProtonsNeeded() == 0);

    }
    */
}
