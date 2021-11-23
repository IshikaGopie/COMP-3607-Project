package com.filefixer;
/**
 * Interface for the {@link Student} class.
 */
public interface StudentInterface{
    /**
     * See {@link Student#changeStatus()}.
	 */
    public void changeStatus();
    /**
     * @return String: See {@link Student#participantID}.
     */
    public String getParticipantID();
    /**
     * @return String: See {@link Student#name}.
     */
    public String getName();
    /**
     * @return String: See {@link Student#studentID}.
     */
    public String getStudentID();
    /**
     * @return boolean: See {@link Student#studentMissing}.
     */
    public boolean getStatus();
}
