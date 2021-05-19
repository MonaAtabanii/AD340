package com.example.dateprofile;

public class MatchesProfiles {

    private String name;
    private String bio;
    private int pic;

    public MatchesProfiles(String name, String bio, int pic) {
        this.name = name;
        this.bio = bio;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getPic() {
        return pic;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }


}
