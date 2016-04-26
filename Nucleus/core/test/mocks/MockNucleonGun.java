package mocks;

import com.nucleus.INucleon;
import com.nucleus.INucleonGun;

import java.util.ArrayList;

/**
 * Created by erik on 22/04/16.
 */
public class MockNucleonGun implements INucleonGun {
    ArrayList<INucleon> nucleons = new ArrayList<INucleon>();

    public MockNucleonGun(ArrayList<INucleon> nucleons){
        this.nucleons = nucleons;
    }

    public INucleon shoot() {
            INucleon nucleon = nucleons.get(0);
            nucleons.remove(0);
            return nucleon;
        }

    public boolean isEmpty() {
        if (nucleons.size()==0)
            return true;
        return false;
    }
}
