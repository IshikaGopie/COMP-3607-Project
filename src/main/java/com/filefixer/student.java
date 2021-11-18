package com.filefixer;

public class student implements studentINTERFACE{
    private String participant_ID;
    private String name;
    private String student_ID;
    private boolean student_missing;
    
    public student(String participant_ID, String name, String student_ID){
        this.participant_ID = participant_ID;
        this.name = name;
        this.student_ID = student_ID;
        student_missing = true;
    }

    @Override
    public String getparticipant_ID() {
        return participant_ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getstudent_ID() {
        return student_ID;
    }

    @Override
    public void changeStatus(){
        student_missing = false;
    }

    @Override
    public boolean getStatus(){
        return student_missing;
    }


}
