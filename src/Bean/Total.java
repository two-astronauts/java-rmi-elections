/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Total implements Serializable {
    private static final long serialVersionUID = 1L;

    private int registered;
    private int votes;

    public Total(int registered, int votes) {
        this.registered = registered;
        this.votes = votes;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
