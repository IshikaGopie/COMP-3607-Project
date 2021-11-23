package com.filefixer;

public class student implements studentInterface{
	
    private String participantID;
    
    private String name;
    
    private String studentID;
    /**
     * This student's submission status.
     */
    private boolean studentMissing;
    
    /**
     * Initializes this student's participant ID, name and student ID.
     * Also initializes this student's {@link #studentMissing} variable to {@code true} or 'missing'.
     * @param participantID
     * @param name 
     * @param studentID 
     */
    public student(String participantID, String name, String studentID){
        this.participantID = participantID;
        this.name = name;
        this.studentID = studentID;
        studentMissing = true;
    }

    /**
     * Changes this student's submission status from true to false (or 'missing' to 'present').
     */
    @Override
    public void changeStatus(){
        studentMissing = false;
    }

    
    @Override
    public String getParticipantID() {
        return participantID;
    }

    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStudentID() {
        return studentID;
    }

    
    /** 
     * Returns {@link #studentMissing}.
     * @return boolean: See {@link #studentMissing}.
     */
    @Override
    public boolean getStatus(){
        return studentMissing;
    }
    
    @Override
    public boolean equals(Object O){
        if(O instanceof student){
            if(participantID.equals(((student)O).getParticipantID()) && name.equals(((student)O).getName()) && studentID.equals(((student)O).getStudentID()))
                return true;
        }
        return false;
    }
}
