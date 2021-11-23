package com.filefixer;
/**
 * Interface for the {@link student} class.
 */
public interface studentInterface{
    /**
     * See {@link student#changeStatus()}.
	 */
    public void changeStatus();
    /**
     * @return String: See {@link student#participantID}.
     */
    public String getParticipantID();
    /**
     * @return String: See {@link student#name}.
     */
    public String getName();
    /**
     * @return String: See {@link student#studentID}.
     */
    public String getStudentID();
    /**
     * @return boolean: See {@link student#studentMissing}.
     */
    public boolean getStatus();
}
