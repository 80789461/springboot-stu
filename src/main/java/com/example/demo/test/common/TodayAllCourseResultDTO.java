package com.example.demo.test.common;

public class TodayAllCourseResultDTO {
	   
    private static final long serialVersionUID = 282996229726807263L;

    private String teachingTimeId;
    
    private String teachingId;
    
    private String roomName;
    
    private String teacherId;
    
    private String courseId;
    
    private String courseName;
    
    private String openId;
    
    private String teachingStartTime;
   
    private String teachingEndTime;
    
    private String studentName;
    
    /**
     * 备注信息
     */
    private String message;
    
    /**
     * desc: 过期时间
      */
     private Long timeOut;
    
    public String getTeachingTimeId() {
        return teachingTimeId;
    }

    public void setTeachingTimeId(String teachingTimeId) {
        this.teachingTimeId = teachingTimeId;
    }

    public String getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(String teachingId) {
        this.teachingId = teachingId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTeachingStartTime() {
        return teachingStartTime;
    }

    public void setTeachingStartTime(String teachingStartTime) {
        this.teachingStartTime = teachingStartTime;
    }

    public String getTeachingEndTime() {
        return teachingEndTime;
    }

    public void setTeachingEndTime(String teachingEndTime) {
        this.teachingEndTime = teachingEndTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
