package com.example.demo.test.common;

public class CourseStudentAbsentQueryDTO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
        * 企业id
    */
    private String enterpriseId;
    /**
         *授课ID
     */
    private String teachingTimeId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getTeachingTimeId() {
        return teachingTimeId;
    }

    public void setTeachingTimeId(String teachingTimeId) {
        this.teachingTimeId = teachingTimeId;
    }
}
