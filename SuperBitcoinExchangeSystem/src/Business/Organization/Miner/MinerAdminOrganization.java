/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Miner;

import Business.Organization.Organization;
import Business.Role.Miner.MinerAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Lei
 */
public class MinerAdminOrganization extends Organization{
    public MinerAdminOrganization(){
        super(Type.MinerAdmin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MinerAdminRole());
        return roles;
    }
    
    
}
