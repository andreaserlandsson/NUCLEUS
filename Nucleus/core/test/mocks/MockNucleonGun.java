package mocks;

import com.nucleus.Model.INucleon;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.Neutron;
import com.nucleus.Model.Proton;

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

    @Override
    public int getProtonsInGun() {
        int nbrOfProtons = 0;
        for(int i = 0; i < nucleons.size(); i++){
            if(nucleons.get(i).getClass().equals(Proton.class)){
                nbrOfProtons++;
            }
        }
        return nbrOfProtons;
    }

    @Override
    public int getNeutronsInGun() {
        int nbrOfNeutrons = 0;
        for(int i = 0; i < nucleons.size(); i++){
            if(nucleons.get(i).getClass().equals(Neutron.class)){
                nbrOfNeutrons++;
            }
        }
        return nbrOfNeutrons;
    }

    public int getAmmoLeft(){
        return nucleons.size();
    }

}
