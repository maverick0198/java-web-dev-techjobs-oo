package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    @Override
    public String toString() {
        if((getName() == null || getName().equals(""))
                && (getEmployer()== null || getEmployer().getValue().equals(""))
                && (getLocation()==null || getLocation().getValue().equals(""))
                && (getPositionType()==null || getPositionType().getValue().equals(""))
                && (getCoreCompetency()==null || getCoreCompetency().getValue().equals(""))){
            return "\nOOPS! This job does not seem to exist.\n";
        }
        String name = this.getName();
        String employer = this.getEmployer().getValue();
        String location = this.getLocation().getValue();
        String positionType = this.getPositionType().getValue();
        String coreCompetency = this.getCoreCompetency().getValue();

        if(name == null || name.equals("")){
            name = "Data not available";
        }
        if(employer == null || employer.equals("")){
            employer = "Data not available";
        }
        if(location == null || location.equals("")){
            location = "Data not available";
        }
        if(positionType == null || positionType.equals("")){
            positionType = "Data not available";
        }
        if(coreCompetency == null || coreCompetency.equals("")){
            coreCompetency = "Data not available";
        }
        return "\n" +
                "ID: " + id +
                "\nName: " + name +
                "\nEmployer: " + employer +
                "\nLocation: " + location +
                "\nPosition Type: " + positionType +
                "\nCore Competency: " + coreCompetency +
                "\n\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
